package com.ihorizons.marvelapp.views.imagesgallery;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.ihorizons.marvelapp.R;
import com.ihorizons.marvelapp.dtos.ComicsResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mohamed on 29/09/16.
 */
public class ComicsImagesPagerAdapter extends PagerAdapter {

    Context mContext;
    LayoutInflater mLayoutInflater;
    private  List<ComicsResponse.Result>  results ;

    public ComicsImagesPagerAdapter(Context context, List<ComicsResponse.Result> result) {
        mContext = context;
        this.results = result ;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return results.size();
    }



    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((RelativeLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = mLayoutInflater.inflate(R.layout.pager_item, container, false);
        ComicsResponse.Result result = results.get(position);
        if(result.getImages().size() > 0 && result.getImages().get(0).getPath().length()>0) {
            ImageView itemImage = (ImageView) itemView.findViewById(R.id.imageView);
            TextView imageText = (TextView) itemView.findViewById(R.id.item_text);
            TextView imageTextTotal = (TextView) itemView.findViewById(R.id.item_text_total);

            imageTextTotal.setText(""+(position+1)+" / "+""+results.size());
            ImageButton close = (ImageButton)itemView.findViewById(R.id.clear_button);
            close.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((Activity)mContext).finish();
                }
            });
            imageText.setText(result.getTitle());
            Glide.with(mContext).load(result.getImages().get(0).getPath() + "." + result.getImages().get(0).getExtension()).asBitmap().diskCacheStrategy(DiskCacheStrategy.ALL).placeholder(R.mipmap.ic_launcher).into(itemImage);

            ((ViewPager) container).addView(itemView);
            return itemView;
        }
        return null;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((RelativeLayout) object);
    }
}