package com.ihorizons.marvelapp.views.charachterslist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;

import com.ihorizons.marvelapp.R;
import com.ihorizons.marvelapp.views.BaseActivity;

/**
 * Created by mohamed on 23/09/16.
 */
public class ListOfCharactersActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.common_activity);
            startFragment();
    }



    private void startFragment() {

        ListOfCharactersFragment listOfCharactersFragment = new ListOfCharactersFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.layCommonActivity, listOfCharactersFragment).commit();
    }

}
