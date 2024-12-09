package com.example.batterylistener;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView batteryStatusText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        batteryStatusText = findViewById(R.id.batteryStatusText);

        // Register BatteryChanged Intent dynamically
        IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        Intent batteryStatus = registerReceiver(null, ifilter);

        if (batteryStatus != null) {
            // Extract battery level and scale
            int level = batteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
            int scale = batteryStatus.getIntExtra(BatteryManager.EXTRA_SCALE, -1);

            // Calculate battery percentage
            float batteryPct = (level / (float) scale) * 100;

            // Update UI
            batteryStatusText.setText("Battery Level: " + (int) batteryPct + "%");
        } else {
            batteryStatusText.setText("Unable to get battery status.");
        }
    }
}
