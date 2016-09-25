package com.ihorizons.marvelapp.views.charachterslist;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.ihorizons.marvelapp.R;
import com.ihorizons.marvelapp.dtos.ListOfCarachtersDTO;
import com.ihorizons.marvelapp.views.BaseFragment;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by mohamed on 24/09/16.
 */
public class ListOfCharactersFragment extends BaseFragment implements IListOfCharactersView {


    View mRootView ;

    IListOfCharactersPresenter listOfCharactersPresenter ;

    CharactersListAdapter charactersListAdapter ;

    @Bind(R.id.layout_loading)
    View mLoadingLayout ;

    @Bind(R.id.recycler_view)
    RecyclerView mRecyclerView ;

    int next = 0 ;
    List<ListOfCarachtersDTO.Result> resultList ;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mRootView = inflater.inflate(R.layout.characters_list_fragment,container,false);

        ButterKnife.bind(this,mRootView);
        listOfCharactersPresenter = new ListOfCharactersPresenterImpl(this);
        listOfCharactersPresenter.getMarvelCharactersList();

        return mRootView;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(llm);
        mRecyclerView.setHasFixedSize(true);

    }


    @Override
    public void showLoading() {

        mLoadingLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {


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
    public void setCharactersList(final ListOfCarachtersDTO listOfCarachtersDTO) {


        resultList = listOfCarachtersDTO.getData().getResults();

        charactersListAdapter = new CharactersListAdapter(listOfCarachtersDTO.getData().getResults(), new CharactersListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(ListOfCarachtersDTO.Result result) {



            }
        },getContext(),mRecyclerView);


        mRecyclerView.setAdapter(charactersListAdapter);
        charactersListAdapter.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {

                next += (listOfCarachtersDTO.getData().getLimit()+listOfCarachtersDTO.getData().getOffset()) ;
                listOfCharactersPresenter.getMoreMarvelCharacters(next);

            }
        });
    }

    @Override
    public void handleMoreItems(ListOfCarachtersDTO listOfCarachtersDTO) {

        resultList.addAll(listOfCarachtersDTO.getData().getResults());
        charactersListAdapter.notifyDataSetChanged();
        charactersListAdapter.setLoaded();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        listOfCharactersPresenter.onDestroy();
        ButterKnife.unbind(this);
    }
}
