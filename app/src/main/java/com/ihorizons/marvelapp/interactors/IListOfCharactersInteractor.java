package com.ihorizons.marvelapp.interactors;

import com.ihorizons.marvelapp.dtos.ListOfCarachtersDTO;

/**
 * Created by mohamed on 24/09/16.
 */
public interface IListOfCharactersInteractor {

     interface OnAllCharactersFetchedListener {

        void onSuccess(ListOfCarachtersDTO listOfCarachtersDTO);
        void onError(String errorMessage);


    }

    void getAllMarvelCharacters(OnAllCharactersFetchedListener onAllCharactersFetchedListener);

    void unSubscribeAll();




}
