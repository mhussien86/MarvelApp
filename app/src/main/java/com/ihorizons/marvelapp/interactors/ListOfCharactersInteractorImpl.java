package com.ihorizons.marvelapp.interactors;

import com.ihorizons.marvelapp.data.ServiceGenerator;
import com.ihorizons.marvelapp.data.apis.IListOfCharactersAPI;
import com.ihorizons.marvelapp.dtos.ListOfCarachtersDTO;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Timestamp;
import java.util.Date;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by mohamed on 24/09/16.
 */
public class ListOfCharactersInteractorImpl implements IListOfCharactersInteractor {



    CompositeSubscription mCompositeSubscription;
    IListOfCharactersAPI listOfCharactersAPI ;

    String  timeStamp = generateTimeStamp();
    String publicKey = "b9ad9dbe3b3f86fd5e05150b7ffa67cd" ;
    String secretKey = "47e12027235d0585d966685ccafcbc9831a59c75" ;
    String hashKey ;
    public ListOfCharactersInteractorImpl() {
        listOfCharactersAPI = new ServiceGenerator().createService(IListOfCharactersAPI.class);
        mCompositeSubscription = new CompositeSubscription();


    }

    @Override
    public void getAllMarvelCharacters(final OnAllCharactersFetchedListener onAllCharactersFetchedListener) {


        try {
            hashKey =  generateMD5Hash(timeStamp,secretKey, publicKey);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        Observable<ListOfCarachtersDTO> observable = listOfCharactersAPI.getAllCharacters(timeStamp ,publicKey,hashKey );

        mCompositeSubscription.add(observable
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ListOfCarachtersDTO>() {
                    @Override
                    public void onNext(ListOfCarachtersDTO listOfCarachtersDTO) {

                        onAllCharactersFetchedListener.onSuccess(listOfCarachtersDTO);
                    }

                    @Override
                    public void onCompleted() {


                    }

                    @Override
                    public void onError(final Throwable error) {

                        onAllCharactersFetchedListener.onError(""+error.getLocalizedMessage());

                    }
                }));



    }

    @Override
    public void unSubscribeAll() {
        if(null !=mCompositeSubscription && mCompositeSubscription.hasSubscriptions()) {
            mCompositeSubscription.unsubscribe();
        }
    }



    String generateMD5Hash(String timeStamp, String secretKey  , String publicKey ) throws NoSuchAlgorithmException {

        String s=timeStamp + secretKey +publicKey ;
        MessageDigest m=MessageDigest.getInstance("MD5");
        m.update(s.getBytes(),0,s.length());

        return ""+new BigInteger(1,m.digest()).toString(16);
    }


    String generateTimeStamp(){
        Date date = new Date();

        return ""+date.getTime();
    }
}
