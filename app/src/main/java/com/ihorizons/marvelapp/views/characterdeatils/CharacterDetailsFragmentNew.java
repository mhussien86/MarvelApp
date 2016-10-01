package com.ihorizons.marvelapp.views.characterdeatils;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.ihorizons.marvelapp.R;
import com.ihorizons.marvelapp.data.APIConstants;
import com.ihorizons.marvelapp.dtos.ComicsResponse;
import com.ihorizons.marvelapp.dtos.DetailsResponse;
import com.ihorizons.marvelapp.dtos.EventsResponse;
import com.ihorizons.marvelapp.dtos.ListOfCarachtersDTO;
import com.ihorizons.marvelapp.dtos.SeriesResponse;
import com.ihorizons.marvelapp.dtos.StoriesResponse;
import com.ihorizons.marvelapp.views.BaseFragment;
import com.ihorizons.marvelapp.views.UIConstants;

import org.parceler.Parcels;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by mohamed on 24/09/16.
 */
public class CharacterDetailsFragmentNew extends BaseFragment implements CharacterDetailsView{

    View mRootView ;

    @Bind(R.id.character_name)
    TextView characterName ;

    @Bind(R.id.charachter_image)
    ImageView characterImage ;

    @Bind(R.id.description_content)
    TextView descriptionTextView ;

    @Bind(R.id.back_button)
    ImageButton backButton ;

    @Bind(R.id.layout_loading)
    View mLoadingLayout ;

    @Bind(R.id.comics_recycler_view)
    RecyclerView comicsGallery;

    @Bind(R.id.events_recycler_view)
    RecyclerView eventsGallery;

    @Bind(R.id.series_recycler_view)
    RecyclerView seriesGallery;

    @Bind(R.id.stories_recycler_view)
    RecyclerView storiesGallery;

    @Bind(R.id.comics_layout)
    LinearLayout comicsLayout;

    @Bind(R.id.stories_layout)
    LinearLayout storiesLayout;

    @Bind(R.id.series_layout)
    LinearLayout seriesLayout;

    @Bind(R.id.events_layout)
    LinearLayout eventsLayout;

    @Bind(R.id.links_layout)
    LinearLayout linksLayout;

    CharacterDetailsPresenter characterDetailsPresenter ;


    ListOfCarachtersDTO.Result result ;

    ComicsListAdapter comicsListAdapter ;

    StoriesListAdapter storiesListAdapter ;

    EventsListAdapter eventsListAdapter ;

    SeriesListAdapter seriesListAdapter ;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mRootView = inflater.inflate(R.layout.charcter_details_fragment_new,container,false);

        ButterKnife.bind(this,mRootView);
        getIntentExtras();
        fillDetailsData();


        characterDetailsPresenter = new CharacterDetailsPresenterImpl(this);
        characterDetailsPresenter.getMarvelCharactersDetails(result.getId());
        return mRootView;
    }



    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.HORIZONTAL);
        comicsGallery.setLayoutManager(llm);
        comicsGallery.setHasFixedSize(true);

        LinearLayoutManager llm2 = new LinearLayoutManager(getActivity());
        llm2.setOrientation(LinearLayoutManager.HORIZONTAL);
        eventsGallery.setLayoutManager(llm2);
        eventsGallery.setHasFixedSize(true);

        LinearLayoutManager llm3 = new LinearLayoutManager(getActivity());
        llm3.setOrientation(LinearLayoutManager.HORIZONTAL);
        storiesGallery.setLayoutManager(llm3);
        storiesGallery.setHasFixedSize(true);


        LinearLayoutManager llm4 = new LinearLayoutManager(getActivity());
        llm4.setOrientation(LinearLayoutManager.HORIZONTAL);
        seriesGallery.setLayoutManager(llm4);
        seriesGallery.setHasFixedSize(true);
    }

    public void getIntentExtras(){

        try {
            result = Parcels.unwrap(getActivity().getIntent().getParcelableExtra(UIConstants.CHARACTER_EXTRAS));

        }catch (Exception e){

            e.printStackTrace();
        }

    }


    void fillDetailsData(){
        if(result.getDescription().length()>0){
            descriptionTextView.setText(""+result.getDescription());

        }else {
            descriptionTextView.setText(getResources().getString(R.string.no_description));

        }
        Glide.with(getContext()).load(result.getThumbnail().getPath()+"."+result.getThumbnail().getExtension()).diskCacheStrategy(DiskCacheStrategy.ALL).placeholder(R.mipmap.ic_launcher).into(characterImage);

        characterName.setText(result.getName());
    }

    @OnClick({R.id.back_button, R.id.wiki_link,R.id.detail_link, R.id.comic_link})
    public void backButton(View view) {

        if(view.getId()==R.id.back_button) {
            getActivity().onBackPressed();
        }else if (view.getId()==R.id.wiki_link){

        }else if (view.getId()==R.id.detail_link){

        }else if (view.getId()==R.id.comic_link){

        }
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

    }

    @Override
    public void setMarvelCharactersDetails(HashMap<String, DetailsResponse> marvelCharactersDetails) {


        ComicsResponse comicsResponse = (ComicsResponse)marvelCharactersDetails.get(APIConstants.COMICS_RESPONSE);


        comicsListAdapter = new ComicsListAdapter(comicsResponse.getData().getResults(),getContext());

        comicsGallery.setAdapter(comicsListAdapter);


        EventsResponse eventsResponse = (EventsResponse)marvelCharactersDetails.get(APIConstants.EVENTS_RESPONSE);

        eventsListAdapter = new EventsListAdapter(eventsResponse.getData().getResults(),getContext());

        eventsGallery.setAdapter(eventsListAdapter);

        StoriesResponse storiesResponse = (StoriesResponse) marvelCharactersDetails.get(APIConstants.STORIES_RESPONSE);

        storiesListAdapter = new StoriesListAdapter(storiesResponse.getData().getResults(),getContext());
        storiesGallery.setAdapter(storiesListAdapter);

        SeriesResponse seriesResponse = (SeriesResponse)marvelCharactersDetails.get(APIConstants.SERIES_RESPONSE);

        seriesListAdapter = new SeriesListAdapter(seriesResponse.getData().getResults(),getContext());
        seriesGallery.setAdapter(seriesListAdapter);
    }




    @Override
    public void onDestroy() {
        super.onDestroy();
        characterDetailsPresenter.onDestroy();
        ButterKnife.unbind(this);
    }
}