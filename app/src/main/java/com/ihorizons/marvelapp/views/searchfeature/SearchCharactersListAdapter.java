package com.ihorizons.marvelapp.views.searchfeature;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.LinearLayoutManager;
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
import com.ihorizons.marvelapp.views.charachterslist.OnLoadMoreListener;

import java.util.List;

/**
 * Created by mohamed on 24/09/16.
 */
public class SearchCharactersListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private List<ListOfCarachtersDTO.Result> results ;
    private final OnItemClickListener listener;
    private OnLoadMoreListener mOnLoadMoreListener;
    private Context context ;

    private final int VIEW_TYPE_ITEM = 0;
    private final int VIEW_TYPE_LOADING = 1;

    private boolean isLoading;
    private int visibleThreshold = 5 ;
    private int lastVisibleItem, totalItemCount;
    public interface OnItemClickListener {
        void onItemClick(ListOfCarachtersDTO.Result result);
    }

    public SearchCharactersListAdapter(List<ListOfCarachtersDTO.Result> results, OnItemClickListener listener, Context context , RecyclerView mRecyclerView){
        this.results = results ;
        this.listener = listener ;
        this.context = context ;

        final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) mRecyclerView.getLayoutManager();
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                totalItemCount = linearLayoutManager.getItemCount();
//                visibleThreshold = linearLayoutManager.getChildCount();
                lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();


                if (!isLoading && totalItemCount <= (lastVisibleItem + visibleThreshold)) {
                    if (mOnLoadMoreListener != null) {
                        mOnLoadMoreListener.onLoadMore();
                    }
                    isLoading = true;
                }
            }
        });
    }


    public void setOnLoadMoreListener(OnLoadMoreListener mOnLoadMoreListener) {
        this.mOnLoadMoreListener = mOnLoadMoreListener;
    }

    @Override
    public int getItemViewType(int position) {
        return results.get(position) == null ? VIEW_TYPE_LOADING : VIEW_TYPE_ITEM;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RecyclerView.ViewHolder vh;
        if (viewType == VIEW_TYPE_ITEM) {
            View listItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_result_character_list_item, parent, false);
            vh = new CharactersViewHolder(listItem);

        }else{
            View view =  LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_loading_item, parent, false);
            vh = new LoadingViewHolder(view);
        }


        return vh;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {


        if(holder instanceof CharactersViewHolder){

            final CharactersViewHolder charactersViewHolder = (CharactersViewHolder)holder ;
            charactersViewHolder.bind(results.get(position), listener);
            ListOfCarachtersDTO.Result result = results.get(position);
            charactersViewHolder.characterName.setText(result.getName());

//        Glide.with(context).load(results.get(position).getThumbnail().getPath()+"."+results.get(position).getThumbnail().getExtension()).asBitmap().diskCacheStrategy(DiskCacheStrategy.ALL).placeholder(R.mipmap.ic_launcher).centerCrop().into(charactersViewHolder.characterImage);

        Glide.with(context).load(results.get(position).getThumbnail().getPath() + "." + results.get(position).getThumbnail().getExtension()).asBitmap().fitCenter().centerCrop().diskCacheStrategy(DiskCacheStrategy.ALL).placeholder(R.mipmap.ic_launcher).into(new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(final Bitmap bitmap, GlideAnimation glideAnimation) {
                charactersViewHolder.characterImage.setImageBitmap(bitmap); // Possibly runOnUiThread()
                Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
                    @Override
                    public void onGenerated(Palette palette) {
                        try {
//                            holder.textBackground.setBackgroundColor(palette.getDarkVibrantSwatch().getRgb());
                            charactersViewHolder.characterName.setTextColor(Color.WHITE);
                        } catch (Exception e) {
                            e.printStackTrace();
                            charactersViewHolder.characterName.setTextColor(Color.WHITE);
                        }
                    }
                });
            }
        });
          }else if (holder instanceof LoadingViewHolder) {
            LoadingViewHolder loadingViewHolder = (LoadingViewHolder) holder;
            loadingViewHolder.progressBar.setIndeterminate(true);
        }

    }


    @Override
    public int getItemCount() {
        return results == null ? 0 : results.size();
    }

    public void setLoaded() {
        isLoading = false;
    }

}
