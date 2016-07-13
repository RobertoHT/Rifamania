package edu.galileo.android.rifamania;

import android.app.Application;

import com.facebook.FacebookSdk;

/**
 * Created by praxis on 13/07/16.
 */
public class RifamaniaApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initFacebook();
    }

    private void initFacebook() {
        FacebookSdk.sdkInitialize(this);
    }
}
