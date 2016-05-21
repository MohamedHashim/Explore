package com.example.mohamed.explore;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Hp on 3/17/2016.
 */
public class MyAdapter extends RecyclerView.Adapter<MyHolder> {

    Context c;
    ArrayList<Item> players,filterList;
    CustomFilter filter;


    public MyAdapter(Context ctx, ArrayList<Item> players)
    {
        this.c=ctx;
        this.players=players;
        this.filterList=players;
    }


    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //CONVERT XML TO VIEW ONBJ
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card,null);

        players.get(0).setImg(R.drawable.fountain2);
        players.get(1).setImg(R.drawable.ski2);
        players.get(2).setImg(R.drawable.sea2);

        //HOLDER
        MyHolder holder=new MyHolder(v);

        return holder;
    }

    //DATA BOUND TO VIEWS
    @Override
    public void onBindViewHolder(final MyHolder holder, int position) {

        //BIND DATA
//        holder.posTxt.setText(players.get(position).getPos());
        holder.nameTxt.setText(players.get(position).getName());
        holder.img.setImageResource(players.get(position).getImg());


        //IMPLEMENT CLICK LISTENET
//        holder.setItemClickListener(new ItemClickListener() {
//            @Override
//            public void onItemClick(View v, int pos) {
//                Snackbar.make(v,players.get(pos).getName(), Snackbar.LENGTH_SHORT).show();
//            }
//        });
        holder.shareImageButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "AndroidSolved");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Now Learn Android with AndroidSolved clicke here to visit https://androidsolved.wordpress.com/ ");
                c.startActivity(Intent.createChooser(sharingIntent, "Share via"));
            }
        });
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                Intent intent = new Intent(c,SimpleVrVideoActivity.class);
                intent.putExtra("ID",pos);
                c.startActivity(intent);
            }
        });
    }

    //GET TOTAL NUM OF PLAYERS
    @Override
    public int getItemCount() {
        return players.size();
    }

    //RETURN FILTER OBJ
//    @Override
//    public Filter getFilter() {
//        if(filter==null)
//        {
//            filter=new CustomFilter(filterList,this);
//        }
//
//        return filter;
//    }
}
