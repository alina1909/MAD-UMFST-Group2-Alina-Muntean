package com.example.lab7_ex1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.widget.Toast;

import java.util.Objects;

public class RECEIVER extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (Objects.equals(intent.getAction(), Intent.ACTION_BATTERY_CHANGED)) {
            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
            int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
            float batteryPct = (level / (float) scale) * 100;

            if (batteryPct < 15) {
                Toast.makeText(context, "Battery is low!", Toast.LENGTH_SHORT).show();
            }else if (batteryPct > 50) {
                Toast.makeText(context, "Battery is above 50%!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
