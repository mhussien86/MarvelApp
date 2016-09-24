package com.ihorizons.marvelapp.interactors;

import com.ihorizons.marvelapp.dtos.ListOfCarachtersDTO;

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
    void getAllMarvelCharacters(OnAllCharactersFetchedListener onAllCharactersFetchedListener);

    void unSubscribeAll();




}
