package com.ihorizons.marvelapp.views.charachterslist;

import com.ihorizons.marvelapp.dtos.ListOfCarachtersDTO;
import com.ihorizons.marvelapp.interactors.IListOfCharactersInteractor;
import com.ihorizons.marvelapp.interactors.ListOfCharactersInteractorImpl;

/**
 * Created by mohamed on 24/09/16.
 */
public class ListOfCharactersPresenterImpl implements IListOfCharactersPresenter, IListOfCharactersInteractor.OnAllCharactersFetchedListener, IListOfCharactersInteractor.OnMoreCharactersFetchedListener {


    private IListOfCharactersView listOfCharactersView ;
    IListOfCharactersInteractor listOfCharactersInteractor ;


    public ListOfCharactersPresenterImpl (IListOfCharactersView listOfCharactersView){
        this.listOfCharactersView = listOfCharactersView ;
        listOfCharactersInteractor = new ListOfCharactersInteractorImpl();
    }
    @Override
    public void getMarvelCharactersList() {

        listOfCharactersView.showLoading();
        listOfCharactersInteractor.getAllMarvelCharacters(this);

    }

    @Override
    public void onDestroy() {

        listOfCharactersView = null ;
        listOfCharactersInteractor.unSubscribeAll();
    }

    @Override
    public void getMoreMarvelCharacters(int next) {
        listOfCharactersInteractor.loadMoreMarvelCharcters(next , this);

    }

    @Override
    public void onSuccess(ListOfCarachtersDTO listOfCarachtersDTO) {

        listOfCharactersView.hideLoading();
        listOfCharactersView.setCharactersList(listOfCarachtersDTO);
    }

    @Override
    public void onError(String errorMessage) {

        listOfCharactersView.hideLoading();
        listOfCharactersView.showError(errorMessage);
    }

    @Override
    public void onMoreSuccess(ListOfCarachtersDTO listOfCarachtersDTO) {

        listOfCharactersView.hideLoading();
        listOfCharactersView.handleMoreItems(listOfCarachtersDTO);

    }

    @Override
    public void onMoreError(String errorMessage) {

    }
}
