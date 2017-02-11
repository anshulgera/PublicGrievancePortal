package com.example.anshulgera.publicgrievanceportal;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by AnshulGera on 20-11-2016.
 */
public class PublicGrievancePortal extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
