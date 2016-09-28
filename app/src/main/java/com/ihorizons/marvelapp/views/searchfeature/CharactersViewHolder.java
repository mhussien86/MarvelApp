package com.ihorizons.marvelapp.views.searchfeature;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ihorizons.marvelapp.R;
import com.ihorizons.marvelapp.dtos.ListOfCarachtersDTO;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by mohamed on 24/09/16.
 */
public class CharactersViewHolder extends RecyclerView.ViewHolder {


    @Bind(R.id.character_name)
    TextView characterName ;

   @Bind(R.id.item_icon)
    ImageView characterImage ;
    public CharactersViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    public void bind(final ListOfCarachtersDTO.Result result, final SearchCharactersListAdapter.OnItemClickListener listener) {

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClick(result);
            }
        });
    }

}
