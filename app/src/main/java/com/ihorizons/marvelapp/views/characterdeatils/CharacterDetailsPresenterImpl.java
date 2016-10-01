package com.ihorizons.marvelapp.views.characterdeatils;

import com.ihorizons.marvelapp.dtos.DetailsResponse;
import com.ihorizons.marvelapp.dtos.ListOfCarachtersDTO;
import com.ihorizons.marvelapp.interactors.IListOfCharactersInteractor;
import com.ihorizons.marvelapp.interactors.ListOfCharactersInteractorImpl;

import java.util.HashMap;

/**
 * Created by mohamed on 30/09/16.
 */
public class CharacterDetailsPresenterImpl implements CharacterDetailsPresenter, IListOfCharactersInteractor.OnLoadCharacterDetails {


    private CharacterDetailsView characterDetailsView ;
    private IListOfCharactersInteractor iListOfCharactersInteractor ;

    public CharacterDetailsPresenterImpl(CharacterDetailsView characterDetailsView){

        this.characterDetailsView = characterDetailsView ;
        iListOfCharactersInteractor = new ListOfCharactersInteractorImpl();

    }



    @Override
    public void getMarvelCharactersDetails(int id) {


        iListOfCharactersInteractor.loadCharacterDetails(id, this);
    }

    @Override
    public void onDestroy() {

        characterDetailsView = null;
        iListOfCharactersInteractor.unSubscribeAll();
    }


    @Override
    public void onLoadDetailsSuccess(HashMap<String, DetailsResponse> marvelCharactersDetails) {
        characterDetailsView.setMarvelCharactersDetails(marvelCharactersDetails);

    }

    @Override
    public void onLoadDeatilsError(String errorMessage) {


        characterDetailsView.showError(errorMessage);


    }
}
