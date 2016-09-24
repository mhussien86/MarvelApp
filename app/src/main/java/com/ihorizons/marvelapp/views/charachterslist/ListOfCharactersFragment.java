package com.ihorizons.marvelapp.views.charachterslist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ihorizons.marvelapp.R;
import com.ihorizons.marvelapp.dtos.ListOfCarachtersDTO;
import com.ihorizons.marvelapp.views.BaseFragment;

import butterknife.Bind;

/**
 * Created by mohamed on 24/09/16.
 */
public class ListOfCharactersFragment extends BaseFragment implements IListOfCharactersView {


    View mRootView ;

    IListOfCharactersPresenter listOfCharactersPresenter ;

    @Bind(R.id.layout_loading)
    View mLoadingLayout ;

//    @Bind(R.id.recycler_view)
//    RecyclerView mRecyclerView ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mRootView = inflater.inflate(R.layout.characters_list_fragment,container,false);

        listOfCharactersPresenter = new ListOfCharactersPresenterImpl(this);
        listOfCharactersPresenter.getMarvelCharactersList();

        return mRootView;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
//        mRecyclerView.setLayoutManager(mLayoutManager);


    }

    @Override
    public void showLoading() {

        if(mLoadingLayout !=null)
        mLoadingLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {

        if(mLoadingLayout !=null)
        mLoadingLayout.setVisibility(View.GONE);
    }

    @Override
    public void showInternetConnectionError() {



    }

    @Override
    public void showError(String errorMessage) {

        Snackbar.make(getView(),""+errorMessage,Snackbar.LENGTH_LONG).show();

    }

    @Override
    public void setCharactersList(ListOfCarachtersDTO listOfCarachtersDTO) {





    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        listOfCharactersPresenter.onDestroy();
    }
}
