package com.ihorizons.marvelapp.views.characterdeatils;


import android.os.Bundle;
import android.support.annotation.Nullable;
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
public class CharacterDetailsFragment extends BaseFragment implements CharacterDetailsView{

    View mRootView ;

    @Bind(R.id.character_name)
    TextView characterName ;

    @Bind(R.id.charachter_image)
    ImageView characterImage ;

    @Bind(R.id.description_content)
    TextView descriptionTextView ;

    @Bind(R.id.back_button)
    ImageButton backButton ;


    @Bind(R.id.comics_gallary)
    LinearLayout comicsGallery;

    @Bind(R.id.events_gallary)
    LinearLayout eventsGallery;

    @Bind(R.id.series_gallary)
    LinearLayout seriesGallery;

    @Bind(R.id.stories_gallary)
    LinearLayout storiesGallery;

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
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mRootView = inflater.inflate(R.layout.charcter_details_fragment,container,false);

        ButterKnife.bind(this,mRootView);
        getIntentExtras();
        fillDetailsData();


        characterDetailsPresenter = new CharacterDetailsPresenterImpl(this);
        characterDetailsPresenter.getMarvelCharactersDetails(result.getId());
        return mRootView;
    }

    private void initLayoutsVisibility() {




    }


    public void getIntentExtras(){

        try {
            result = Parcels.unwrap(getActivity().getIntent().getParcelableExtra(UIConstants.CHARACTER_EXTRAS));

        }catch (Exception e){

            e.printStackTrace();
        }

    }

    @OnClick(R.id.back_button)
    public void backButton(View view) {
        getActivity().onBackPressed();

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

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

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
        setImagesToHorizontalScrollView(comicsResponse);

        EventsResponse eventsResponse = (EventsResponse)marvelCharactersDetails.get(APIConstants.EVENTS_RESPONSE);
        setImagesToHorizontalScrollView(eventsResponse);


        StoriesResponse storiesResponse = (StoriesResponse) marvelCharactersDetails.get(APIConstants.STORIES_RESPONSE);
        setImagesToHorizontalScrollView(storiesResponse);

        SeriesResponse seriesResponse = (SeriesResponse)marvelCharactersDetails.get(APIConstants.SERIES_RESPONSE);
        setImagesToHorizontalScrollView(seriesResponse);

    }


    void setImagesToHorizontalScrollView(Object response){


        if(response instanceof ComicsResponse){

            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);


            for (int i = 0; i <  ((ComicsResponse) response).getData().getResults().size(); i++) {
                layoutParams.setMargins(0, 0, 20, 0);
                layoutParams.gravity = Gravity.CENTER;
                ImageView imageView = new ImageView(getActivity());
                Glide.with(getContext()).load(((ComicsResponse) response).getData().getResults().get(i).getImages().get(i).getPath()+"."+((ComicsResponse) response).getData().getResults().get(i).getImages().get(i).getExtension()).asBitmap().diskCacheStrategy(DiskCacheStrategy.ALL).placeholder(R.mipmap.ic_launcher).into(imageView);
                imageView.setLayoutParams(layoutParams);
                imageView.getLayoutParams().width  = ViewGroup.LayoutParams.MATCH_PARENT;
                imageView.getLayoutParams().height = ViewGroup.LayoutParams.MATCH_PARENT;

                comicsGallery.addView(imageView);

            }
        }else if (response instanceof EventsResponse ){
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);


            for (int i = 0; i <  ((EventsResponse) response).getData().getResults().size(); i++) {
                layoutParams.setMargins(0, 0, 20, 0);
                layoutParams.gravity = Gravity.CENTER;
                ImageView imageView = new ImageView(getActivity());
                Glide.with(getContext()).load(((EventsResponse) response).getData().getResults().get(i).getThumbnail().getPath()+"."+((EventsResponse) response).getData().getResults().get(i).getThumbnail().getExtension()).asBitmap().diskCacheStrategy(DiskCacheStrategy.ALL).placeholder(R.mipmap.ic_launcher).into(imageView);
                imageView.setLayoutParams(layoutParams);
                imageView.getLayoutParams().width  = ViewGroup.LayoutParams.MATCH_PARENT;
                imageView.getLayoutParams().height = ViewGroup.LayoutParams.MATCH_PARENT;

                eventsGallery.addView(imageView);

            }
        }else if (response instanceof StoriesResponse){
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);


            for (int i = 0; i <  ((StoriesResponse) response).getData().getResults().size(); i++) {
                layoutParams.setMargins(0, 0, 20, 0);
                layoutParams.gravity = Gravity.CENTER;
                ImageView imageView = new ImageView(getActivity());
                Glide.with(getContext()).load(((StoriesResponse) response).getData().getResults().get(i).getThumbnail().getPath()+"."+((StoriesResponse) response).getData().getResults().get(i).getThumbnail().getExtension()).asBitmap().diskCacheStrategy(DiskCacheStrategy.ALL).placeholder(R.mipmap.ic_launcher).into(imageView);
                imageView.setLayoutParams(layoutParams);
                imageView.getLayoutParams().width  = ViewGroup.LayoutParams.MATCH_PARENT;
                imageView.getLayoutParams().height = ViewGroup.LayoutParams.MATCH_PARENT;

                storiesGallery.addView(imageView);

            }
        }else {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);


            for (int i = 0; i <  ((SeriesResponse) response).getData().getResults().size(); i++) {
                layoutParams.setMargins(0, 0, 20, 0);
                layoutParams.gravity = Gravity.CENTER;
                ImageView imageView = new ImageView(getActivity());
                Glide.with(getContext()).load(((SeriesResponse) response).getData().getResults().get(i).getThumbnail().getPath()+"."+((SeriesResponse) response).getData().getResults().get(i).getThumbnail().getExtension()).asBitmap().diskCacheStrategy(DiskCacheStrategy.ALL).placeholder(R.mipmap.ic_launcher).into(imageView);
                imageView.setLayoutParams(layoutParams);
                imageView.getLayoutParams().width  = ViewGroup.LayoutParams.MATCH_PARENT;
                imageView.getLayoutParams().height = ViewGroup.LayoutParams.MATCH_PARENT;
                seriesGallery.addView(imageView);

            }
        }



    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        characterDetailsPresenter.onDestroy();
        ButterKnife.unbind(this);
    }
}
