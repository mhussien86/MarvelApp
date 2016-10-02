package com.ihorizons.marvelapp.views.imagesgallery;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;

import com.ihorizons.marvelapp.R;
import com.ihorizons.marvelapp.views.BaseActivity;

/**
 * Created by mohamed on 02/10/16.
 */
public class ComicsImagesGallreyActivity extends BaseActivity{


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.common_activity_without_toolbar);
        startFragment();
    }

    private void startFragment() {

        ComicsImagesGalleryFragment comicsGalleryFragment = new ComicsImagesGalleryFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.layCommonActivity, comicsGalleryFragment).commit();
    }
}
