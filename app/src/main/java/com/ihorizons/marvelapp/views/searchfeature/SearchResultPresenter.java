package com.ihorizons.marvelapp.views.searchfeature;

/**
 * Created by mohamed on 25/09/16.
 */
public interface SearchResultPresenter {


    void getSearchCharactersList(String name);

    void onDestroy();

    void getMoreSearchMarvelCharacters(int next, String name);
}
