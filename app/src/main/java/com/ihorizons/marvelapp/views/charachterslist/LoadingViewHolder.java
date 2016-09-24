package com.ihorizons.marvelapp.views.charachterslist;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.ihorizons.marvelapp.R;

/**
 * Created by mohamed on 24/09/16.
 */
public class LoadingViewHolder extends RecyclerView.ViewHolder {

    public ProgressBar progressBar;

    public LoadingViewHolder(View itemView) {
        super(itemView);
        progressBar = (ProgressBar) itemView.findViewById(R.id.load_more_progress);
    }
}
