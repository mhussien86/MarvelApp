package com.ihorizons.marvelapp.views.characterdeatils;

import com.ihorizons.marvelapp.dtos.DetailsResponse;
import com.ihorizons.marvelapp.dtos.ListOfCarachtersDTO;

import java.util.HashMap;

/**
 * Created by mohamed on 30/09/16.
 */
public interface CharacterDetailsView {


    void showLoading();
    void hideLoading();

    void showInternetConnectionError();

    void showError(String errorMessage);

    void setMarvelCharactersDetails(HashMap<String, DetailsResponse> marvelCharactersDetails);

}
