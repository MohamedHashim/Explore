package com.example.mohamed.explore;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Provides UI for the view with Tile.
 */
public class TileContentFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView recyclerView = (RecyclerView) inflater.inflate(
                R.layout.recycler_view_tour, container, false);
        ContentAdapter adapter = new ContentAdapter(getActivity(),getTours());
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        // Set padding for Tiles
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        return recyclerView;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

//        public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
//            super(inflater.inflate(R.layout.item_card, parent, false));
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Context context = v.getContext();
//                    Intent intent = new Intent(context, DetailActivity.class);
//                    context.startActivity(intent);
//                }
//            });
//        }
//OUR VIEWS
        ImageView img;
        TextView nameTxt,posTxt;
        SearchView sv;
        ImageButton shareImageButton;

        ItemClickListener itemClickListener;


        public ViewHolder(final View itemView) {
            super(itemView);

            this.img= (ImageView) itemView.findViewById(R.id.card_image_tour);
            this.nameTxt= (TextView) itemView.findViewById(R.id.card_title_tour);
            //this.posTxt= (TextView) itemView.findViewById(R.id.card_text);

            itemView.setOnClickListener(this);
        }



        @Override
        public void onClick(View v) {
            this.itemClickListener.onItemClick(v,getLayoutPosition());

        }

        public void setItemClickListener(ItemClickListener ictour)
        {
            this.itemClickListener=ictour;
        }
    }

    /**
     * Adapter to display recycler view.
     */
    public static class ContentAdapter extends RecyclerView.Adapter<ViewHolder> {
        // Set numbers of Tiles in RecyclerView.
//        private static final int LENGTH = 18;
//
//        public ContentAdapter() {
//            // no-op
//        }
//
//        @Override
//        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//            return new ViewHolder(LayoutInflater.from(parent.getContext()), parent);
//        }
//
//        @Override
//        public void onBindViewHolder(ViewHolder holder, int position) {
//            // no-op
//        }
//
//        @Override
//        public int getItemCount() {
//            return LENGTH;
//        }
        Context c;
        ArrayList<Item> tours,filterList;
        CustomFilter filter;


        public ContentAdapter(Context ctx, ArrayList<Item> tours)
        {
            this.c=ctx;
            this.tours=tours;
            this.filterList=tours;
        }


        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            //CONVERT XML TO VIEW ONBJ
            View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_tour,null);

            tours.get(0).setImg(R.drawable.nile);
            tours.get(1).setImg(R.drawable.abusimble);
            tours.get(2).setImg(R.drawable.karnak2);

            //HOLDER
            ViewHolder holder=new ViewHolder(v);

            return holder;
        }

        //DATA BOUND TO VIEWS
        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {

            //BIND DATA
//            holder.posTxt.setText(players.get(position).getPos());
            holder.nameTxt.setText(tours.get(position).getName());
            holder.img.setImageResource(tours.get(position).getImg());


            //IMPLEMENT CLICK LISTENET
//        holder.setItemClickListener(new ItemClickListener() {
//            @Override
//            public void onItemClick(View v, int pos) {
//                Snackbar.make(v,players.get(pos).getName(), Snackbar.LENGTH_SHORT).show();
//            }
//        });
//            holder.shareImageButton.setOnClickListener(new View.OnClickListener(){
//                @Override
//                public void onClick(View v) {
//                    Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
//                    sharingIntent.setType("text/plain");
//                    sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "AndroidSolved");
//                    sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Now Learn Android with AndroidSolved clicke here to visit https://androidsolved.wordpress.com/ ");
//                    c.startActivity(Intent.createChooser(sharingIntent, "Share via"));
//                }
//            });
            holder.setItemClickListener(new ItemClickListener() {
                @Override
                public void onItemClick(View v, int pos) {
                    Intent intent = new Intent(c,TourVrVideoActivity.class);
                    intent.putExtra("IDtour",pos);
                    c.startActivity(intent);
                }
            });
        }

        //GET TOTAL NUM OF PLAYERS
        @Override
        public int getItemCount() {
            return tours.size();
        }

        //RETURN FILTER OBJ
//        @Override
//        public Filter getFilter() {
//            if(filter==null)
//            {
//                filter=new CustomFilter(filterList,this);
//            }
//
//            return filter;
//        }
    }


    private ArrayList<Item> getTours()
    {
        ArrayList<Item> items=new ArrayList<>();
        Item p=new Item();
        p.setName(getString(R.string.tour1));
      //  p.setImg(R.drawable.ic_favorite);
        items.add(p);

        p=new Item();
        p.setName(getString(R.string.tour2));
       // p.setImg(R.drawable.ic_favorite);
        items.add(p);

        p=new Item();
        p.setName(getString(R.string.tour3));
       // p.setImg(R.drawable.ic_favorite);
        items.add(p);



        return items;
    }
}