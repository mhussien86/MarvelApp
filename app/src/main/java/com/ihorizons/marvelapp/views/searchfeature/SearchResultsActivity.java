package com.ihorizons.marvelapp.views.searchfeature;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.ihorizons.marvelapp.R;
import com.ihorizons.marvelapp.views.BaseActivity;
import com.ihorizons.marvelapp.views.BaseFragment;
import com.ihorizons.marvelapp.views.charachterslist.ListOfCharactersFragment;

/**
 * Created by mohamed on 24/09/16.
 */
public class SearchResultsActivity extends BaseActivity{


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_activity);
//        initToolBar();
        startFragment();

    }

    private void startFragment() {

        SearchResultFragment searchResultFragment = new SearchResultFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.layCommonActivity, searchResultFragment).commit();
    }


}
