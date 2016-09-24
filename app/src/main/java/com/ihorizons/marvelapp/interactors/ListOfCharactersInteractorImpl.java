package com.ihorizons.marvelapp.interactors;

import com.ihorizons.marvelapp.data.ServiceGenerator;
import com.ihorizons.marvelapp.data.apis.IListOfCharactersAPI;
import com.ihorizons.marvelapp.dtos.ListOfCarachtersDTO;

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

    public ListOfCharactersInteractorImpl() {
        listOfCharactersAPI = new ServiceGenerator().createService(IListOfCharactersAPI.class);
        mCompositeSubscription = new CompositeSubscription();
    }

    @Override
    public void getAllMarvelCharacters(final OnAllCharactersFetchedListener onAllCharactersFetchedListener) {


        Observable<ListOfCarachtersDTO> observable = listOfCharactersAPI.getAllCharacters();

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
}
