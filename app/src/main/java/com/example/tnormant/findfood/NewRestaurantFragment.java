package com.example.tnormant.findfood;


import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.maps.MapView;

import java.util.List;


public class NewRestaurantFragment extends Fragment {

    // TODO: Rename and change types of parameters
    private EditText nameRestaurant;
    private EditText latitude;
    private EditText longitude;
    private Button buttonRestaurant;
    private RestaurantViewModel mRestaurantViewModel;
    private MyListeFragment liste;
    MainActivity mainActivity;
    int NO_RESTAURANT = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_new_restaurant, container, false);
        mRestaurantViewModel = ViewModelProviders.of(this).get(RestaurantViewModel.class);
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
            if (!nameRestaurant.getText().toString().equals("") || !latitude.getText().toString().equals("")
                || !longitude.getText().toString().equals("")){
                Restaurant restaurant = new Restaurant(NO_RESTAURANT,Float.parseFloat(latitude.getText().toString()),
                        Float.parseFloat(longitude.getText().toString()),nameRestaurant.getText().toString());
                mRestaurantViewModel.insert(restaurant);

                MyListeFragment newFragment = new MyListeFragment();
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.content_main, newFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

                ((MainActivity)getActivity()).hide();
            } else {
                Toast.makeText(getActivity(),"Saisie invalide",Toast.LENGTH_SHORT).show();
                ((MainActivity)getActivity()).hide();
            }
        }
    };
}
