package com.ihorizons.marvelapp.views.charachterslist;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.ihorizons.marvelapp.R;
import com.ihorizons.marvelapp.dtos.ListOfCarachtersDTO;

import java.util.List;

/**
 * Created by mohamed on 24/09/16.
 */
public class CharactersListAdapter extends RecyclerView.Adapter<CharactersViewHolder> {


    private List<ListOfCarachtersDTO.Result> results ;
    private final OnItemClickListener listener;

    private Context context ;

    public interface OnItemClickListener {
        void onItemClick(ListOfCarachtersDTO.Result result);
    }

    public CharactersListAdapter (List<ListOfCarachtersDTO.Result> results, OnItemClickListener listener, Context context){
        this.results = results ;
        this.listener = listener ;
        this.context = context ;
    }

    @Override
    public CharactersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View listItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.character_list_item,parent,false);

        return new CharactersViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(final CharactersViewHolder holder, int position) {

        holder.bind(results.get(position), listener);
        ListOfCarachtersDTO.Result result = results.get(position) ;
        holder.characterName.setText(result.getName());

//        Glide.with(context).load(results.get(position).getThumbnail().getPath()+"."+results.get(position).getThumbnail().getExtension()).asBitmap().diskCacheStrategy(DiskCacheStrategy.ALL).placeholder(R.mipmap.ic_launcher).crossFade().centerCrop().into(holder.characterImage);

        Glide.with(context).load(results.get(position).getThumbnail().getPath()+"."+results.get(position).getThumbnail().getExtension()).asBitmap().fitCenter().centerCrop().diskCacheStrategy(DiskCacheStrategy.ALL).placeholder(R.mipmap.ic_launcher).into(new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(final Bitmap bitmap, GlideAnimation glideAnimation) {
                holder.characterImage.setImageBitmap(bitmap); // Possibly runOnUiThread()
                Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
                    @Override
                    public void onGenerated(Palette palette) {
                        try {
//                            holder.textBackground.setBackgroundColor(palette.getDarkVibrantSwatch().getRgb());
                            holder.characterName.setTextColor(Color.WHITE);
                        } catch (Exception e) {
                            e.printStackTrace();
                            holder.characterName.setTextColor(Color.WHITE);
                        }
                    }
                });
            }
        });



    }

    @Override
    public int getItemCount() {
        return results.size();
    }
}
