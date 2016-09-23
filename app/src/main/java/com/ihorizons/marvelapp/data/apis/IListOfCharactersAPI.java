package com.ihorizons.marvelapp.data.apis;

import com.ihorizons.marvelapp.dtos.ListOfCarachtersDTO;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by mohamed on 24/09/16.
 */
public interface IListOfCharactersAPI {


    @GET("v1/public/characters?apikey=b9ad9dbe3b3f86fd5e05150b7ffa67cd")
    Observable<ListOfCarachtersDTO> getAllCharacters();

}
