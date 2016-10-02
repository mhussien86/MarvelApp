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
import com.ihorizons.marvelapp.dtos.ListOfCarachtersDTO;
import com.ihorizons.marvelapp.dtos.SeriesResponse;

import java.util.List;

/**
 * Created by mohamed on 01/10/16.
 */
public class SeriesListAdapter extends RecyclerView.Adapter<SeriesListAdapter.MyViewHolder> {

    private List<SeriesResponse.Result> results ;

    private Context mContext ;

    private final OnItemClickListener listener;


    public SeriesListAdapter(List<SeriesResponse.Result> results, Context context,OnItemClickListener listener) {
        this.results = results ;
        this.mContext = context ;
        this.listener = listener ;

    }
    public interface OnItemClickListener {
        void onItemClick(SeriesResponse.Result result);
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.horizental_list_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        SeriesResponse.Result result = results.get(position);

        if(result.getThumbnail()!= null) {
            holder.bind(result, listener);
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

        public void bind(final SeriesResponse.Result result, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(result);
                }
            });        }
    }
}