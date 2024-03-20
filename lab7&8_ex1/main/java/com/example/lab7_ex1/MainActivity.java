package com.example.lab7_ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private RECEIVER batteryReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        batteryReceiver = new RECEIVER();
    }

    @Override
    protected void onStart() {
        super.onStart();
        registerBatteryReceiver();
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterBatteryReceiver();
    }

    private void registerBatteryReceiver() {
        IntentFilter filter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(batteryReceiver, filter);
    }

    private void unregisterBatteryReceiver() {
        unregisterReceiver(batteryReceiver);
    }
}