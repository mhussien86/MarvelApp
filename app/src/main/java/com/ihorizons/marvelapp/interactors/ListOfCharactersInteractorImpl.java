package com.ihorizons.marvelapp.interactors;

import com.ihorizons.marvelapp.data.ServiceGenerator;
import com.ihorizons.marvelapp.data.apis.IListOfCharactersAPI;
import com.ihorizons.marvelapp.dtos.ComicsResponse;
import com.ihorizons.marvelapp.dtos.ListOfCarachtersDTO;

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
    public void loadCharacterDetails(int id) {

        Observable fetchData = Observable.zip( // Fetch all deails together
                listOfCharactersAPI.getCharacterComics(id, publicKey),
                listOfCharactersAPI.getCharacterEvents(id, publicKey),
                listOfCharactersAPI.getCharacterSeries(id, publicKey),
                listOfCharactersAPI.getCharacterStories(id, publicKey),

                new Func4() {
                    @Override
                    public Object call(Object o, Object o2, Object o3, Object o4) {
                        return null;
                    }
                });


        /*      new Func2<CurrentWeatherDataEnvelope, WeatherForecastListDataEnvelope, HashMap<String, WeatherDataEnvelope>>() {
                    @Override
                    public HashMap call(final CurrentWeatherDataEnvelope currentWeather,
                                        final WeatherForecastListDataEnvelope weatherForecasts) {

                        HashMap weatherData = new HashMap();
                        weatherData.put(Constants.KEY_CURRENT_WEATHER, currentWeather);
                        weatherData.put(Constants.KEY_WEATHER_FORECASTS, weatherForecasts);
                        return weatherData;
                    }

                });*/




     /*           mCompositeSubscription.add(fetchdata
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Subscriber<HashMap<String, WeatherDataEnvelope>>() {
                            @Override
                            public void onNext(final HashMap<String, WeatherDataEnvelope> weatherData) {

                                onRequestFinished.onDataFetchedSuccessful(weatherData);
                            }

                            @Override
                            public void onCompleted() {


                            }

                            @Override
                            public void onError(final Throwable error) {

                                onRequestFinished.onError();

                            }
                        })
                );*/
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
