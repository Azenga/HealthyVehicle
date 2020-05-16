package com.example.vehicleproject.utils;

import android.widget.Toast;

import com.example.vehicleproject.VehicleApplication;

public class Helper {

    public static void toast(String message) {
        Toast.makeText(VehicleApplication.getInstance(), message, Toast.LENGTH_SHORT).show();
    }
}
