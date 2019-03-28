package com.example.tnormant.findfood;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

@Entity(tableName = "restaurant_table")
public class Restaurant {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "noRestaurant")
    int noRestaurant;

    @NonNull
    @ColumnInfo(name = "latitude")
    double latitude;

    @NonNull
    @ColumnInfo(name = "longitude")
    double longitude;

    @NonNull
    @ColumnInfo(name = "nom")
    String nom;

    public Restaurant(int noRestaurant, double latitude, double longitude, String nom) {
        this.noRestaurant = noRestaurant;
        this.latitude = latitude;
        this.longitude = longitude;
        this.nom = nom;
    }

    public Restaurant() {

    }

    public int getNoRestaurant() {
        return noRestaurant;
    }

    public void setNoRestaurant(int noRestaurant) {
        this.noRestaurant = noRestaurant;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
