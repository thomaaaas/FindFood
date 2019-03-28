package com.example.tnormant.findfood;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class RestaurantListAdapter extends RecyclerView.Adapter<RestaurantListAdapter.RestaurantViewHolder>{

class RestaurantViewHolder extends RecyclerView.ViewHolder {
    private final TextView RestaurantItemView;
    Button button;

    private RestaurantViewHolder(View itemView) {
        super(itemView);
        RestaurantItemView = itemView.findViewById(R.id.textView);
        button = itemView.findViewById(R.id.button_id);
    }
}

    private final LayoutInflater mInflater;
    private List<Restaurant> mRestaurant; // Cached copy of words

    RestaurantListAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public RestaurantViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.fragment_my_liste, parent, false);

        return new RestaurantViewHolder(itemView);
    }



    @Override
    public void onBindViewHolder(RestaurantViewHolder holder, int position) {
        if (mRestaurant != null) {
            final Restaurant current = mRestaurant.get(position);
            holder.RestaurantItemView.setText(current.getNom());
            holder.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        } else {
            // Covers the case of data not being ready yet.
            holder.RestaurantItemView.setText("Pas de restaurant");
        }
    }

    void setRestaurants(List<Restaurant> restaurants) {
        mRestaurant = restaurants;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mRestaurant != null)
            return mRestaurant.size();
        else return 0;
    }
}
