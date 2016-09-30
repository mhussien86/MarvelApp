package com.ihorizons.marvelapp.views.characterdeatils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.ihorizons.marvelapp.R;
import com.ihorizons.marvelapp.dtos.ListOfCarachtersDTO;
import com.ihorizons.marvelapp.views.BaseFragment;
import com.ihorizons.marvelapp.views.UIConstants;

import org.parceler.Parcel;
import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by mohamed on 24/09/16.
 */
public class CharacterDetailsFragment extends BaseFragment{

    View mRootView ;

    @Bind(R.id.comics_view_pager)
    ViewPager comicsViewPager ;


    @Bind(R.id.charachter_image)
    ImageView characterImage ;

    @Bind(R.id.description_content)
    TextView descriptionTextView ;

    @Bind(R.id.back_button)
            ImageButton backButton ;
    ComicsPagerAdapter comicsPagerAdapter ;


    ListOfCarachtersDTO.Result result ;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mRootView = inflater.inflate(R.layout.charcter_details_fragment,container,false);

        ButterKnife.bind(this,mRootView);
        getIntentExtras();

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               getActivity().onBackPressed();
            }
        });
        return mRootView;
    }



    public void getIntentExtras(){

        try {
            result = Parcels.unwrap(getActivity().getIntent().getParcelableExtra(UIConstants.CHARACTER_EXTRAS));
            descriptionTextView.setText(""+result.getId());
            Glide.with(getContext()).load(result.getThumbnail().getPath()+"."+result.getThumbnail().getExtension()).diskCacheStrategy(DiskCacheStrategy.ALL).placeholder(R.mipmap.ic_launcher).into(characterImage);

        }catch (Exception e){

            e.printStackTrace();
        }

    }




}
