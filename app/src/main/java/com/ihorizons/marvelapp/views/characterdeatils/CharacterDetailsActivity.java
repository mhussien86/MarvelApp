package com.ihorizons.marvelapp.views.characterdeatils;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;

import com.ihorizons.marvelapp.R;
import com.ihorizons.marvelapp.views.BaseActivity;

/**
 * Created by mohamed on 24/09/16.
 */
public class CharacterDetailsActivity extends BaseActivity {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.common_activity_without_toolbar);
        startFragment();
    }

    private void startFragment() {

        CharacterDetailsFragment characterDetailsFragment = new CharacterDetailsFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.layCommonActivity, characterDetailsFragment).commit();
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();

        overridePendingTransition(R.anim.no_change, R.anim.slide_down);
        finish();

    }
}
