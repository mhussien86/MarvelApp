package com.ihorizons.marvelapp.views.charachterslist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.ihorizons.marvelapp.R;
import com.ihorizons.marvelapp.views.BaseActivity;
import com.ihorizons.marvelapp.views.searchfeature.SearchResultsActivity;

/**
 * Created by mohamed on 23/09/16.
 */
public class ListOfCharactersActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.common_activity);
        initToolBar();
            startFragment();
    }



    private void startFragment() {

        ListOfCharactersFragment listOfCharactersFragment = new ListOfCharactersFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.layCommonActivity, listOfCharactersFragment).commit();
    }

    public void initToolBar() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.common_toolbar);

        TextView title = (TextView)toolbar.findViewById(R.id.toolbar_title);
        title.setText(R.string.app_title);
        ImageButton searchButton = (ImageButton)toolbar.findViewById(R.id.search_button);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListOfCharactersActivity.this,SearchResultsActivity.class);
                startActivity(intent);
            }
        });

        setSupportActionBar(toolbar);

    }

}
