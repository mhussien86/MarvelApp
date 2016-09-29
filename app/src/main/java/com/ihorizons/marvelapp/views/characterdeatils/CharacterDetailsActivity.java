package com.ihorizons.marvelapp.views.characterdeatils;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;

import com.ihorizons.marvelapp.R;
import com.ihorizons.marvelapp.views.BaseActivity;
import com.ihorizons.marvelapp.views.searchfeature.SearchResultFragment;

/**
 * Created by mohamed on 24/09/16.
 */
public class CharacterDetailsActivity extends BaseActivity {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.common_activity);
        startFragment();
    }

    private void startFragment() {

        CharacterDetailsFragment characterDetailsFragment = new CharacterDetailsFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.layCommonActivity, characterDetailsFragment).commit();
    }

}
