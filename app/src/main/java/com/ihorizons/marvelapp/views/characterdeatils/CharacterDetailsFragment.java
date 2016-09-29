package com.ihorizons.marvelapp.views.characterdeatils;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ihorizons.marvelapp.R;
import com.ihorizons.marvelapp.dtos.ListOfCarachtersDTO;
import com.ihorizons.marvelapp.views.BaseFragment;
import com.ihorizons.marvelapp.views.UIConstants;

import org.parceler.Parcel;
import org.parceler.Parcels;

import butterknife.Bind;

/**
 * Created by mohamed on 24/09/16.
 */
public class CharacterDetailsFragment extends BaseFragment{

    View mRootView ;

    @Bind(R.id.comics_view_pager)
    ViewPager comicsViewPager ;

    ComicsPagerAdapter comicsPagerAdapter ;


    ListOfCarachtersDTO.Result result ;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mRootView = inflater.inflate(R.layout.charcter_details_fragment,container,false);

        getIntentExtras();
        Log.e("Name", ""+result.getComics().getItems().get(0).getName() );
        return mRootView;
    }



    public void getIntentExtras(){

        try {
            result = Parcels.unwrap(getActivity().getIntent().getParcelableExtra(UIConstants.CHARACTER_EXTRAS));

        }catch (Exception e){

            e.printStackTrace();
        }

    }
}
