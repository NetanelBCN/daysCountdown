package dev.netanelbcn.commonmanager;

import android.app.Application;

import dev.netanelbcn.commonmanager.Utilities.SharedPreferencesManager;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SharedPreferencesManager.init(this);
    }
}
