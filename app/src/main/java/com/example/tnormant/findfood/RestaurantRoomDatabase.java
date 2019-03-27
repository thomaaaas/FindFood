package com.example.tnormant.findfood;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

@Database(entities = {Restaurant.class}, version = 1)
public abstract class RestaurantRoomDatabase extends RoomDatabase {
    public abstract RestaurantDao restaurantDao();
    private static volatile RestaurantRoomDatabase INSTANCE;

    static RestaurantRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (RestaurantRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            RestaurantRoomDatabase.class, "restaurant_database")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback(){

                @Override
                public void onOpen (@NonNull SupportSQLiteDatabase db){
                    super.onOpen(db);
                    new PopulateDbAsync(INSTANCE).execute();
                }
            };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final RestaurantDao mDao;

        PopulateDbAsync(RestaurantRoomDatabase db) {
            mDao = db.restaurantDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            mDao.deleteAll();
            Restaurant restaurant = new Restaurant(1,47.64644268068093,6.854897167177228,"Eat-Side");
            mDao.insert(restaurant);
            restaurant = new Restaurant(2,47.63652099774848,6.857539415359497,"Flam's");
            mDao.insert(restaurant);
            restaurant = new Restaurant(3,47.62738220139595,6.8578290939331055,"KFC");
            mDao.insert(restaurant);
            restaurant = new Restaurant(4,47.627767234357584,6.858063787221909,"Quick");
            mDao.insert(restaurant);
            return null;
        }
    }
}
