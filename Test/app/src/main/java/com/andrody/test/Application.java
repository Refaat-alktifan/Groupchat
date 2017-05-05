package com.andrody.test;

import com.firebase.client.Firebase;

/**
 * Created by Abboudi_Aliwi on 10/24/2015.
 */
public class Application extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
