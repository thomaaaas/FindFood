package com.example.tnormant.findfood;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

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
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
