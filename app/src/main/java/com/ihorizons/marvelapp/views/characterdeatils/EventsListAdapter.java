package com.ihorizons.marvelapp.views.characterdeatils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.ihorizons.marvelapp.R;
import com.ihorizons.marvelapp.dtos.ComicsResponse;
import com.ihorizons.marvelapp.dtos.EventsResponse;

import java.util.List;

/**
 * Created by mohamed on 01/10/16.
 */
public class EventsListAdapter extends RecyclerView.Adapter<EventsListAdapter.MyViewHolder> {

    private List<EventsResponse.Result> results ;

    private Context mContext ;



    public EventsListAdapter(List<EventsResponse.Result> results, Context context) {
        this.results = results ;
        this.mContext = context ;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.pager_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        EventsResponse.Result result = results.get(position);

        if(result.getThumbnail()!=null) {
            holder.itemText.setText(result.getTitle());
            Glide.with(mContext).load(result.getThumbnail().getPath() + "." + result.getThumbnail().getExtension()).asBitmap().diskCacheStrategy(DiskCacheStrategy.ALL).placeholder(R.mipmap.ic_launcher).into(holder.itemImage);
        }
    }

    @Override
    public int getItemCount() {
        return results.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageView itemImage ;
        public TextView itemText ;
        public MyViewHolder(View view) {
            super(view);
            itemImage = (ImageView) view.findViewById(R.id.imageView);
            itemText = (TextView) view.findViewById(R.id.item_text);
        }
    }
}