package com.example.tnormant.findfood;


import android.arch.lifecycle.LiveData;
import android.os.Bundle;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;


public class NewRestaurantFragment extends Fragment {

    // TODO: Rename and change types of parameters
    private EditText nameRestaurant;
    private EditText latitude;
    private EditText longitude;
    private Button buttonRestaurant;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_new_restaurant, container, false);

        nameRestaurant = rootView.findViewById(R.id.nameRestaurant);
        latitude = rootView.findViewById(R.id.latitude);
        longitude = rootView.findViewById(R.id.longitude);
        buttonRestaurant = rootView.findViewById(R.id.buttonRestaurant);
        buttonRestaurant.setOnClickListener(buttonRestaurantListener);

        return rootView;


    }

    private View.OnClickListener buttonRestaurantListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            System.out.println(nameRestaurant.getText().toString()+ " nom RESTO !!!!");
            Restaurant resto = new Restaurant();
            resto.setNom(nameRestaurant.getText().toString());
            resto.setLatitude(Float.parseFloat(latitude.getText().toString()));
            resto.setLongitude(Float.parseFloat(longitude.getText().toString()));
        }
    };

}
