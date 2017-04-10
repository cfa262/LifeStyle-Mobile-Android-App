package com.example.calvin.lifestyle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Calvin on 4/10/2017.
 */

public class WaterSettings extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.water_settings);

    }

    public void onWaterSettingsBackClicked(View s) {
        if (s.getId() == R.id.waterSettingsBackButton) {
            Intent i = new Intent(WaterSettings.this, SettingsPage.class);
            startActivity(i);

        }
    }


}
