package com.ihorizons.marvelapp.interactors;

import com.ihorizons.marvelapp.data.ServiceGenerator;
import com.ihorizons.marvelapp.data.APIConstants;
import com.ihorizons.marvelapp.data.apis.IListOfCharactersAPI;
import com.ihorizons.marvelapp.dtos.ComicsResponse;
import com.ihorizons.marvelapp.dtos.DetailsResponse;
import com.ihorizons.marvelapp.dtos.EventsResponse;
import com.ihorizons.marvelapp.dtos.ListOfCarachtersDTO;
import com.ihorizons.marvelapp.dtos.SeriesResponse;
import com.ihorizons.marvelapp.dtos.StoriesResponse;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func4;
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
    public void loadMoreMarvelCharcters(int next, final OnMoreCharactersFetchedListener onMoreCharactersFetchedListener) {
        try {
            hashKey =  generateMD5Hash(timeStamp,secretKey, publicKey);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        Observable<ListOfCarachtersDTO> observable = listOfCharactersAPI.getAllCharacters(timeStamp ,publicKey,hashKey ,"10", ""+next);

        mCompositeSubscription.add(observable
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ListOfCarachtersDTO>() {
                    @Override
                    public void onNext(ListOfCarachtersDTO listOfCarachtersDTO) {

                        onMoreCharactersFetchedListener.onMoreSuccess(listOfCarachtersDTO);
                    }

                    @Override
                    public void onCompleted() {


                    }

                    @Override
                    public void onError(final Throwable error) {

                        onMoreCharactersFetchedListener.onMoreError(""+error.getLocalizedMessage());

                    }
                }));

    }

    @Override
    public void getAllMarvelCharacters(final OnAllCharactersFetchedListener onAllCharactersFetchedListener) {


        try {
            hashKey =  generateMD5Hash(timeStamp,secretKey, publicKey);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        Observable<ListOfCarachtersDTO> observable = listOfCharactersAPI.getAllCharacters(timeStamp ,publicKey,hashKey ,"10", "");

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
    public void getSearchResultForMarvelCharacters(String name, final OnAllCharactersFetchedListener onAllCharactersFetchedListener) {

        try {
            hashKey =  generateMD5Hash(timeStamp,secretKey, publicKey);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        Observable<ListOfCarachtersDTO> observable = listOfCharactersAPI.getAllCharactersStartsWith(timeStamp ,publicKey,hashKey ,"10", "", name);

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
    public void getMoreSearchResultForMarvelCharacters(int next, String name, final OnMoreCharactersFetchedListener onMoreCharactersFetchedListener) {

        try {
            hashKey =  generateMD5Hash(timeStamp,secretKey, publicKey);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        Observable<ListOfCarachtersDTO> observable = listOfCharactersAPI.getAllCharactersStartsWith(timeStamp ,publicKey,hashKey ,"10", ""+next,name);

        mCompositeSubscription.add(observable
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ListOfCarachtersDTO>() {
                    @Override
                    public void onNext(ListOfCarachtersDTO listOfCarachtersDTO) {

                        onMoreCharactersFetchedListener.onMoreSuccess(listOfCarachtersDTO);
                    }

                    @Override
                    public void onCompleted() {


                    }

                    @Override
                    public void onError(final Throwable error) {

                        onMoreCharactersFetchedListener.onMoreError(""+error.getLocalizedMessage());

                    }
                }));
    }

    @Override
    public void loadCharacterDetails(int id, final OnLoadCharacterDetails onLoadCharacterDetails) {

        try {
            hashKey =  generateMD5Hash(timeStamp,secretKey, publicKey);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        Observable fetchData = Observable.zip( // Fetch all deails together
                listOfCharactersAPI.getCharacterComics(id,timeStamp, publicKey,hashKey),
                listOfCharactersAPI.getCharacterEvents(id,timeStamp, publicKey,hashKey),
                listOfCharactersAPI.getCharacterSeries(id,timeStamp, publicKey,hashKey),
                listOfCharactersAPI.getCharacterStories(id, timeStamp, publicKey,hashKey),


        new Func4<ComicsResponse, EventsResponse, SeriesResponse, StoriesResponse, HashMap<String, DetailsResponse>>() {


                    @Override
                    public HashMap call(final ComicsResponse comicsResponse,final EventsResponse eventsResponse,final SeriesResponse seriesResponse,final StoriesResponse storiesResponse) {

                        HashMap detailsData = new HashMap();

                        detailsData.put(APIConstants.COMICS_RESPONSE, comicsResponse);
                        detailsData.put(APIConstants.EVENTS_RESPONSE, eventsResponse);
                        detailsData.put(APIConstants.SERIES_RESPONSE, seriesResponse);
                        detailsData.put(APIConstants.STORIES_RESPONSE, storiesResponse);


                        return detailsData;
                    }
                });





               mCompositeSubscription.add(fetchData
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Subscriber<HashMap<String, DetailsResponse>>() {
                            @Override
                            public void onNext(final HashMap<String, DetailsResponse> detailsData) {


                                onLoadCharacterDetails.onLoadDetailsSuccess(detailsData);
                            }

                            @Override
                            public void onCompleted() {


                            }

                            @Override
                            public void onError(final Throwable error) {

                                onLoadCharacterDetails.onLoadDeatilsError(""+error.getLocalizedMessage());

                            }
                        })
                );
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
