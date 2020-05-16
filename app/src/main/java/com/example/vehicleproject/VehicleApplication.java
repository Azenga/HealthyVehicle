package com.example.vehicleproject;

import android.app.Application;

public class VehicleApplication extends Application {

    private static VehicleApplication _instance;

    @Override
    public void onCreate() {
        super.onCreate();

        _instance = this;
    }

    public static VehicleApplication getInstance() {
        return _instance;
    }
}
