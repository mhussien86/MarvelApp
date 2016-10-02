package com.ihorizons.marvelapp.views.characterdeatils;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ihorizons.marvelapp.R;
import com.ihorizons.marvelapp.dtos.ComicsResponse;
import com.ihorizons.marvelapp.views.BaseFragment;
import com.ihorizons.marvelapp.views.UIConstants;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by mohamed on 02/10/16.
 */
public class ImagesGalleryFragment extends BaseFragment {


    @Bind(R.id.pager)
    ViewPager imagesPager ;

    ImagesPagerAdapter imagesPagerAdapter ;

    View mRootView ;
    private ComicsResponse.Result result;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mRootView = inflater.inflate(R.layout.images_gallery_fragment,container,false);

        ButterKnife.bind(this,mRootView);

        getIntentExtras();

        return mRootView;
    }

    public void getIntentExtras(){

        try {
            result = Parcels.unwrap(getActivity().getIntent().getParcelableExtra(UIConstants.CHARACTER_EXTRAS));

        }catch (Exception e){

            e.printStackTrace();
        }

    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        imagesPagerAdapter = new ImagesPagerAdapter(getContext(),result );


    }


}
