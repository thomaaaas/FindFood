package com.example.tnormant.findfood;

import android.net.Uri;
import android.os.Bundle;

import android.os.Debug;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class NewRestaurantFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


    // TODO: Rename and change types of parameters
    private EditText nameRestaurant;
    private EditText latitude;
    private EditText longitude;
    private Button buttonRestaurant;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_new_restaurant, container, true);

        nameRestaurant = (EditText) rootView.findViewById(R.id.nameRestaurant);
        latitude = (EditText) rootView.findViewById(R.id.latitude);
        longitude = (EditText) rootView.findViewById(R.id.longitude);
        buttonRestaurant = (Button) rootView.findViewById(R.id.buttonRestaurant);


        return rootView;


        //return super.onCreateView(inflater, container, savedInstanceState);
    }

    private View.OnClickListener buttonRestaurantListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            System.out.println("j'ai cliqué");
        }

    };

}
