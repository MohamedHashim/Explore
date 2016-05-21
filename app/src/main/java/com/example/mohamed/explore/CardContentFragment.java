package com.example.mohamed.explore;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Provides UI for the view with Cards.
 */
public class CardContentFragment extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView recyclerView = (RecyclerView) inflater.inflate(
                R.layout.recycler_view, container, false);
        MyAdapter adapter = new MyAdapter(getActivity(),getPlayers());
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        //SET ITS PROPETRIES
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        return recyclerView;
    }


//
//    public static class ViewHolder extends RecyclerView.ViewHolder {
//
//        public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
//            super(inflater.inflate(R.layout.item_card, parent, false));
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Context context = v.getContext();
//                    Intent intent = new Intent(context, SimpleVrVideoActivity.class);
//                    context.startActivity(intent);
//                }
//            });
//
//            // Adding Snackbar to Action Button inside card
////            Button button = (Button)itemView.findViewById(R.id.action_button);
////            button.setOnClickListener(new View.OnClickListener(){
////                @Override
////                public void onClick(View v) {
////                    Snackbar.make(v, "Action is pressed",
////                            Snackbar.LENGTH_LONG).show();
////                }
////            });
//
////            ImageButton favoriteImageButton =
////                    (ImageButton) itemView.findViewById(R.id
//// .favorite_button);
////            favoriteImageButton.setOnClickListener(new View.OnClickListener(){
////                @Override
////                public void onClick(View v) {
////                    Snackbar.make(v, "Added to Favorite",
////                            Snackbar.LENGTH_LONG).show();
////                }
////            });
//
////            ImageButton shareImageButton = (ImageButton) itemView.findViewById(R.id.share_button);
////            shareImageButton.setOnClickListener(new View.OnClickListener(){
////                @Override
////                public void onClick(View v) {
////                    Snackbar.make(v, "Share article",
////                            Snackbar.LENGTH_LONG).show();
////                }
////            });
//
//
//
//        }
//    }
//
//    /**
//     * Adapter to display recycler view.
//     */
//    public static class ContentAdapter extends RecyclerView.Adapter<ViewHolder> {
//        // Set numbers of Card in RecyclerView.
//        private static final int LENGTH = 6;
//
//        @Override
//        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//
//            return new ViewHolder(LayoutInflater.from(parent.getContext()), parent);
//
//
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
//    }
//

    //ADD PLAYERS TO ARRAYLIST
    private ArrayList<Item> getPlayers()
    {
        ArrayList<Item> items=new ArrayList<>();
        Item p=new Item();
        p.setName(getString(R.string.title1));
        p.setPos(getString(R.string.desc1));
//        p.setImg(R.drawable.ic_favorite);
        items.add(p);

        p=new Item();
        p.setName(getString(R.string.title2));
        p.setPos(getString(R.string.desc2));
//        p.setImg(R.drawable.ic_favorite);
        items.add(p);

        p=new Item();
        p.setName(getString(R.string.title3));
        p.setPos(getString(R.string.desc3));
//        p.setImg(R.drawable.ic_favorite);
        items.add(p);

//        p=new Item();
//        p.setName("\"We had to leave,\" A Refugee Story from Greece ");
//        p.setPos("Greece. One refugee at the camp explains why he and his family left war-torn Afghanistan, boarded a dangerously overcrowded boat, and set off into rough winter waters to try to reach “a more developed country”. Doctors Without Borders/Médecins Sans Frontières (MSF) is working in Lesbos to help boats in trouble safely reach shore, and to provide medical assistance. ");
//        p.setImg(R.drawable.refugee);
//        items.add(p);




        return items;
    }

}
