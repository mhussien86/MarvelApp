package com.ihorizons.marvelapp.data.apis;

import com.ihorizons.marvelapp.dtos.ListOfCarachtersDTO;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by mohamed on 24/09/16.
 */
public interface IListOfCharactersAPI {


    @GET("v1/public/characters?")
    Observable<ListOfCarachtersDTO> getAllCharacters(@Query("ts") String timestamp , @Query("apikey") String apikey, @Query("hash") String hash , @Query("limit") String limit,@Query("offset") String offset);

}
