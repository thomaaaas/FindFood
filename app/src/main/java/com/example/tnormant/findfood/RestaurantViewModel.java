package com.example.tnormant.findfood;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

public class RestaurantViewModel extends AndroidViewModel {

    private RestaurantRepository mRepository;

    private LiveData<List<Restaurant>> mAllRestaurant;

    public RestaurantViewModel (Application application) {
        super(application);
        mRepository = new RestaurantRepository(application);
        mAllRestaurant = mRepository.getAllRestaurant();
    }

    LiveData<List<Restaurant>> getAllRestaurant() { return mAllRestaurant; }

    public void insert(Restaurant restaurant) { mRepository.insert(restaurant); }
}
