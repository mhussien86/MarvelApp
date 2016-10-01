package com.ihorizons.marvelapp.views.characterdeatils;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.ihorizons.marvelapp.R;
import com.ihorizons.marvelapp.dtos.ComicsResponse;

import java.util.List;

/**
 * Created by mohamed on 29/09/16.
 */
public class ComicsPagerAdapter extends PagerAdapter {

    Context mContext;
    LayoutInflater mLayoutInflater;
    ViewPager viewPager ;
    LinearLayout thumbnails ;
    private List<ComicsResponse.Result> results ;
    public ComicsPagerAdapter(Context context, List<ComicsResponse.Result> result, ViewPager viewPager, LinearLayout thumbnails) {
        mContext = context;
        this.results = result ;
        this.thumbnails = thumbnails ;
        this.viewPager = viewPager ;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return results.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = mLayoutInflater.inflate(R.layout.pager_item, container, false);
        container.addView(itemView);

//        ImageView imageView = (ImageView) itemView.findViewById(R.id.imageView);

        // Get the border size to show around each image
        int borderSize = thumbnails.getPaddingTop();

        // Get the size of the actual thumbnail image
        int thumbnailSize = ((LinearLayout.LayoutParams)
                viewPager.getLayoutParams()).bottomMargin - (borderSize*2);

        // Set the thumbnail layout parameters. Adjust as required

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(thumbnailSize, thumbnailSize);
        params.setMargins(0, 0, borderSize, 0);

        final ImageView thumbView = new ImageView(mContext);
        thumbView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        thumbView.setLayoutParams(params);
        Glide.with(mContext).load(results.get(position).getImages().get(position).getPath()+"."+results.get(position).getImages().get(position).getExtension()).asBitmap().diskCacheStrategy(DiskCacheStrategy.ALL).placeholder(R.mipmap.ic_launcher).into(thumbView);
        thumbnails.addView(thumbView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}