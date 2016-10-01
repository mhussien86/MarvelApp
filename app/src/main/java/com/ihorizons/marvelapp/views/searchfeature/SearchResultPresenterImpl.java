package com.ihorizons.marvelapp.views.searchfeature;

import com.ihorizons.marvelapp.dtos.ListOfCarachtersDTO;
import com.ihorizons.marvelapp.interactors.IListOfCharactersInteractor;
import com.ihorizons.marvelapp.interactors.ListOfCharactersInteractorImpl;

/**
 * Created by mohamed on 25/09/16.
 */
public class SearchResultPresenterImpl  implements SearchResultPresenter, IListOfCharactersInteractor.OnAllCharactersFetchedListener, IListOfCharactersInteractor.OnMoreCharactersFetchedListener {

    private SearchResultView searchResultView ;
    private IListOfCharactersInteractor listOfCharactersInteractor ;


    public SearchResultPresenterImpl(SearchResultView searchResultView){

        this.searchResultView = searchResultView ;
        listOfCharactersInteractor = new ListOfCharactersInteractorImpl();
    }

    @Override
    public void getSearchCharactersList(String name) {

        searchResultView.showLoading();
        listOfCharactersInteractor.getSearchResultForMarvelCharacters(name, this);
    }

    @Override
    public void onDestroy() {

        searchResultView = null ;
        listOfCharactersInteractor.unSubscribeAll();
    }

    @Override
    public void getMoreSearchMarvelCharacters(int next, String name) {

        listOfCharactersInteractor.getMoreSearchResultForMarvelCharacters(next,name, this);
    }

    @Override
    public void onSuccess(ListOfCarachtersDTO listOfCarachtersDTO) {

        searchResultView.hideLoading();
        searchResultView.setSearchCharactersList(listOfCarachtersDTO);

    }

    @Override
    public void onError(String errorMessage) {

        searchResultView.hideLoading();
        searchResultView.showError(errorMessage);

    }

    @Override
    public void onMoreSuccess(ListOfCarachtersDTO listOfCarachtersDTO) {

        searchResultView.hideLoading();
        searchResultView.handleMoreSearchItems(listOfCarachtersDTO);


    }

    @Override
    public void onMoreError(String errorMessage) {

        searchResultView.hideLoading();
        searchResultView.showError(errorMessage);


    }
}
