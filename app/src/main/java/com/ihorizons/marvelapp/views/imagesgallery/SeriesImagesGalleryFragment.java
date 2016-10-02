package com.ihorizons.marvelapp.views.imagesgallery;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ihorizons.marvelapp.R;
import com.ihorizons.marvelapp.dtos.ComicsResponse;
import com.ihorizons.marvelapp.dtos.SeriesResponse;
import com.ihorizons.marvelapp.views.BaseFragment;
import com.ihorizons.marvelapp.views.UIConstants;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by mohamed on 02/10/16.
 */
public class SeriesImagesGalleryFragment extends BaseFragment {


    @Bind(R.id.pager)
    ViewPager imagesPager ;

    SeriesImagesPagerAdapter seriesImagesPagerAdapter;

    View mRootView ;
    private List<SeriesResponse.Result> result;

    private List<SeriesResponse.Result> filteredResult;

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
            result =  (List<SeriesResponse.Result>) getActivity().getIntent().getSerializableExtra(UIConstants.CHARACTER_EXTRAS);
            filteredResult = new ArrayList<>() ;
            for(int i = 0 ; i < result.size(); i ++ ){

                if(result.get(i).getThumbnail().getPath().length()>0){
                    filteredResult.add(result.get(i));
                }
            }

        }catch (Exception e){

            e.printStackTrace();
        }

    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        seriesImagesPagerAdapter = new SeriesImagesPagerAdapter(getContext(),filteredResult );
        imagesPager.setAdapter(seriesImagesPagerAdapter);
        imagesPager.setClipToPadding(false);
        imagesPager.setPadding(80, 40, 80, 40);
        imagesPager.setPageMargin(60);
        imagesPager.setPageTransformer(false, new ViewPager.PageTransformer() {
                    @Override
                    public void transformPage(View page, float position) {
                        if (position < -1) {
                            page.setScaleY(0.7f);
                            page.setAlpha(1);
                        } else if (position <= 1) {
                            float scaleFactor = Math.max(0.7f, 1 - Math.abs(position - 0.14285715f));
                            page.setScaleX(scaleFactor);
                            page.setScaleY(scaleFactor);
                            page.setAlpha(scaleFactor);
                        } else {
                            page.setScaleY(0.7f);
                            page.setAlpha(1);
                        }
                    }
                });

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
