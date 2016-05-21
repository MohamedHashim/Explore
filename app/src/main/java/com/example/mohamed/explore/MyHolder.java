package com.example.mohamed.explore;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Hp on 3/17/2016.
 */
public class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    //OUR VIEWS
    ImageView img;
    TextView nameTxt,posTxt;
    SearchView sv;
    ImageButton shareImageButton;

    ItemClickListener itemClickListener;


    public MyHolder(final View itemView) {
        super(itemView);

        this.img= (ImageView) itemView.findViewById(R.id.card_image);
        this.nameTxt= (TextView) itemView.findViewById(R.id.card_title);
        //this.posTxt= (TextView) itemView.findViewById(R.id.card_text);
        this.shareImageButton = (ImageButton) itemView.findViewById(R.id.share_button);

        itemView.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        this.itemClickListener.onItemClick(v,getLayoutPosition());

    }

    public void setItemClickListener(ItemClickListener ic)
    {
        this.itemClickListener=ic;
    }
}
