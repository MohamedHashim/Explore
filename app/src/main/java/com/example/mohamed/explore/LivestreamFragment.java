package com.example.mohamed.explore;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Provides UI for the view with Cards.
 */
public class LivestreamFragment extends Fragment {
    private ProgressDialog progressDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        RecyclerView recyclerView = (RecyclerView) inflater.inflate(
                R.layout.recycler_view, container, false);
        progressDialog = new ProgressDialog(getActivity());
//            progressDialog.setCancelable(false);
//            progressDialog.setTitle("Please wait..");
//            progressDialog.setMessage("Loading..");
//            progressDialog.show();
   return inflater.inflate(R.layout.loading,container,false);
    }

//        @Override
//        public void onStart() {
//            super.onStart();
//
//            //show progressBar
//            progressDialog = new ProgressDialog(getActivity());
//            progressDialog.setCancelable(false);
//            progressDialog.setTitle("Please wait..");
//            progressDialog.setMessage("Loading..");
//            progressDialog.show();
//        }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item_card, parent, false));
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, SimpleVrVideoActivity.class);
                    context.startActivity(intent);
                }
            });

            // Adding Snackbar to Action Button inside card
//            Button button = (Button)itemView.findViewById(R.id.action_button);
//            button.setOnClickListener(new View.OnClickListener(){
//                @Override
//                public void onClick(View v) {
//                    Snackbar.make(v, "Action is pressed",
//                            Snackbar.LENGTH_LONG).show();
//                }
//            });

//            ImageButton favoriteImageButton =
//                    (ImageButton) itemView.findViewById(R.id
// .favorite_button);
//            favoriteImageButton.setOnClickListener(new View.OnClickListener(){
//                @Override
//                public void onClick(View v) {
//                    Snackbar.make(v, "Added to Favorite",
//                            Snackbar.LENGTH_LONG).show();
//                }
//            });

//            ImageButton shareImageButton = (ImageButton) itemView.findViewById(R.id.share_button);
//            shareImageButton.setOnClickListener(new View.OnClickListener(){
//                @Override
//                public void onClick(View v) {
//                    Snackbar.make(v, "Share article",
//                            Snackbar.LENGTH_LONG).show();
//                }
//            });



        }
    }

    /**
     * Adapter to display recycler view.
     */
    public static class ContentAdapter extends RecyclerView.Adapter<ViewHolder> {
        // Set numbers of Card in RecyclerView.
        private static final int LENGTH = 6;

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            return new ViewHolder(LayoutInflater.from(parent.getContext()), parent);


        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            // no-op
        }

        @Override
        public int getItemCount() {
            return LENGTH;
        }
    }




}
