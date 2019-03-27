package com.example.tnormant.findfood;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class RestaurantRepository {

    private RestaurantDao mRestaurantDao;
    private LiveData<List<Restaurant>> mAllRestaurant;

    RestaurantRepository(Application application) {
        RestaurantRoomDatabase db = RestaurantRoomDatabase.getDatabase(application);
        mRestaurantDao = db.restaurantDao();
        mAllRestaurant = mRestaurantDao.getAllRestaurant();
    }

    LiveData<List<Restaurant>> getAllRestaurant() {
        return mAllRestaurant;
    }


    public void insert (Restaurant restaurant) {
        new insertAsyncTask(mRestaurantDao).execute(restaurant);
    }

    private static class insertAsyncTask extends AsyncTask<Restaurant, Void, Void> {

        private RestaurantDao mAsyncTaskDao;

        insertAsyncTask(RestaurantDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Restaurant... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
