package com.example.lenovo.complaint_box;

import android.app.Application;
import com.firebase.client.Firebase;

/**
 * Created by Lenovo on 01-06-2016.
 */
public class BoxApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Firebase.setAndroidContext(this);
    }

}
