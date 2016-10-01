package com.ihorizons.marvelapp.data.apis;

import com.ihorizons.marvelapp.dtos.ComicsResponse;
import com.ihorizons.marvelapp.dtos.DetailsResponse;
import com.ihorizons.marvelapp.dtos.EventsResponse;
import com.ihorizons.marvelapp.dtos.ListOfCarachtersDTO;
import com.ihorizons.marvelapp.dtos.SeriesResponse;
import com.ihorizons.marvelapp.dtos.StoriesResponse;

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


    @GET("v1/public/characters?")
    Observable<ListOfCarachtersDTO> getAllCharactersStartsWith(@Query("ts") String timestamp , @Query("apikey") String apikey, @Query("hash") String hash , @Query("limit") String limit,@Query("offset") String offset , @Query("nameStartsWith") String nameStartsWith);


    @GET("v1/public/characters/{characterId}/comics?")
    Observable<ComicsResponse> getCharacterComics(@Path("characterId") int characterId , @Query("ts") String timestamp,@Query("apikey") String apikey,@Query("hash") String hash);


    @GET("v1/public/characters/{characterId}/events?")
    Observable<EventsResponse> getCharacterEvents(@Path("characterId") int characterId ,@Query("ts") String timestamp, @Query("apikey") String apikey,@Query("hash") String hash);


    @GET("v1/public/characters/{characterId}/series?")
    Observable<SeriesResponse> getCharacterSeries(@Path("characterId") int characterId ,@Query("ts") String timestamp, @Query("apikey") String apikey,@Query("hash") String hash);


    @GET("v1/public/characters/{characterId}/stories?")
    Observable<StoriesResponse> getCharacterStories(@Path("characterId") int characterId ,@Query("ts") String timestamp, @Query("apikey") String apikey,@Query("hash") String hash);

}
