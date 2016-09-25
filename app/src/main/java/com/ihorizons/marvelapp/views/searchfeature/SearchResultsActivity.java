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
import com.ihorizons.marvelapp.views.charachterslist.ListOfCharactersFragment;

/**
 * Created by mohamed on 24/09/16.
 */
public class SearchResultsActivity extends AppCompatActivity{


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_activity);
        initToolBar();
        startFragment();

    }

    private void startFragment() {

        SearchResultFragment searchResultFragment = new SearchResultFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.layCommonActivity, searchResultFragment).commit();
    }

    public void initToolBar() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.search_toolbar);

        final EditText searchEditText = (EditText)toolbar.findViewById(R.id.search_edit);
        final ImageButton clearButton = (ImageButton)toolbar.findViewById(R.id.clear_button);
        ImageButton backButton = (ImageButton)toolbar.findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!searchEditText.getText().toString().isEmpty() ){
                    clearButton.setVisibility(View.VISIBLE);
                    clearButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            searchEditText.setText("");
                        }
                    });
                }else{
                    clearButton.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        setSupportActionBar(toolbar);

    }
}
