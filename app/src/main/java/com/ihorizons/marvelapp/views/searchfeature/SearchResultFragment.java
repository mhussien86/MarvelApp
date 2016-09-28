package com.ihorizons.marvelapp.views.searchfeature;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import com.ihorizons.marvelapp.R;
import com.ihorizons.marvelapp.dtos.ListOfCarachtersDTO;
import com.ihorizons.marvelapp.views.BaseFragment;
import com.ihorizons.marvelapp.views.charachterslist.*;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by mohamed on 25/09/16.
 */
public class SearchResultFragment extends BaseFragment implements SearchResultView{


    SearchResultPresenter searchResultPresenter ;

    SearchCharactersListAdapter charactersListAdapter ;

    @Bind(R.id.layout_loading)
    View mLoadingLayout ;

    @Bind(R.id.recycler_view)
    RecyclerView mRecyclerView ;

    int next = 0 ;
    List<ListOfCarachtersDTO.Result> resultList ;
    View mRootView ;

    EditText searchEditText ;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mRootView = inflater.inflate(R.layout.search_resut_fragment, container , false);

        initToolBar();

        ButterKnife.bind(this,mRootView);
        searchResultPresenter = new SearchResultPresenterImpl(this);

        return mRootView;
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
    public void setSearchCharactersList(final ListOfCarachtersDTO listOfCarachtersDTO) {

        resultList = listOfCarachtersDTO.getData().getResults();

        charactersListAdapter = new SearchCharactersListAdapter(listOfCarachtersDTO.getData().getResults(), new SearchCharactersListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(ListOfCarachtersDTO.Result result) {



            }
        },getContext(),mRecyclerView);


        mRecyclerView.setAdapter(charactersListAdapter);
        charactersListAdapter.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {

                next += (listOfCarachtersDTO.getData().getLimit()+listOfCarachtersDTO.getData().getOffset()) ;
                searchResultPresenter.getMoreSearchMarvelCharacters(next,""+searchEditText.getText().toString());

            }
        });

    }

    @Override
    public void handleMoreSearchItems(ListOfCarachtersDTO listOfCarachtersDTO) {


        resultList.addAll(listOfCarachtersDTO.getData().getResults());
        charactersListAdapter.notifyDataSetChanged();
        charactersListAdapter.setLoaded();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        searchResultPresenter.onDestroy();
        ButterKnife.unbind(this);
    }

    public void initToolBar() {

        Toolbar toolbar = (Toolbar) mRootView.findViewById(R.id.search_toolbar);

        searchEditText = (EditText)toolbar.findViewById(R.id.search_edit);
        final ImageButton clearButton = (ImageButton)toolbar.findViewById(R.id.clear_button);
        ImageButton backButton = (ImageButton)toolbar.findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
            }
        });
        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if(!searchEditText.getText().toString().isEmpty() && charSequence.toString().trim().length()>0){
                    searchResultPresenter.getSearchCharactersList(charSequence.toString().trim());
                    clearButton.setVisibility(View.VISIBLE);
                    clearButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            searchEditText.setText("");
                        }
                    });
                }else{
                    clearButton.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {



            }
        });

        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

    }
}
