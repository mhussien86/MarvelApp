package com.ihorizons.marvelapp.views.searchfeature;

import com.ihorizons.marvelapp.dtos.ListOfCarachtersDTO;

/**
 * Created by mohamed on 25/09/16.
 */
public interface SearchResultView {



    void showLoading();
    void hideLoading();

    void showInternetConnectionError();

    void showError(String errorMessage);

    void setSearchCharactersList(ListOfCarachtersDTO listOfCarachtersDTO);

    void handleMoreSearchItems(ListOfCarachtersDTO listOfCarachtersDTO);
}
