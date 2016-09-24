package com.ihorizons.marvelapp.views.charachterslist;

import com.ihorizons.marvelapp.dtos.ListOfCarachtersDTO;

/**
 * Created by mohamed on 24/09/16.
 */
public interface IListOfCharactersView {


    void showLoading();
    void hideLoading();

    void showInternetConnectionError();

    void showError(String errorMessage);

    void setCharactersList(ListOfCarachtersDTO listOfCarachtersDTO);
}
