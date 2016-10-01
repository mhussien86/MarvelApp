package com.ihorizons.marvelapp.interactors;

import com.ihorizons.marvelapp.dtos.DetailsResponse;
import com.ihorizons.marvelapp.dtos.ListOfCarachtersDTO;

import java.util.HashMap;

/**
 * Created by mohamed on 24/09/16.
 */
public interface IListOfCharactersInteractor {

    void loadMoreMarvelCharcters(int next, OnMoreCharactersFetchedListener onMoreCharactersFetchedListener);

    interface OnAllCharactersFetchedListener {

        void onSuccess(ListOfCarachtersDTO listOfCarachtersDTO);
        void onError(String errorMessage);


    }

    interface OnMoreCharactersFetchedListener {

        void onMoreSuccess(ListOfCarachtersDTO listOfCarachtersDTO);
        void onMoreError(String errorMessage);


    }

    interface OnLoadCharacterDetails {

        void onLoadDetailsSuccess(HashMap<String, DetailsResponse> marvelCharactersDetails);
        void onLoadDeatilsError(String errorMessage);


    }



    void getAllMarvelCharacters(OnAllCharactersFetchedListener onAllCharactersFetchedListener);


    void getSearchResultForMarvelCharacters(String name , OnAllCharactersFetchedListener onAllCharactersFetchedListener);
    void getMoreSearchResultForMarvelCharacters(int next , String name , OnMoreCharactersFetchedListener onMoreCharactersFetchedListener);
    void loadCharacterDetails(int id, OnLoadCharacterDetails onLoadCharacterDetails);
    void unSubscribeAll();




}
