package com.example.calvin.lifestyle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Calvin on 3/18/2017.
 */

public class SettingsPage extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_page);

    }

    public void onSettingsClicked(View s){
        if(s.getId() == R.id.backWaterButton){
            Intent i = new Intent(SettingsPage.this, IntroPage.class);
            startActivity(i);

        }
    }
}