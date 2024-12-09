package com.example.batterylistener;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.widget.Toast;
import android.util.Log;

public class BatteryReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // Get battery status
        int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1); // Current battery level
        int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1); // Max battery level

        // Calculate the battery percentage
        float batteryPercentage = (level / (float) scale) * 100;

        // Log the battery percentage
        Log.d("BatteryReceiver", "Battery Level: " + batteryPercentage + "%");

        // Display the battery percentage in a Toast
        Toast.makeText(context, "Battery Level: " + batteryPercentage + "%", Toast.LENGTH_LONG).show();
    }
}
