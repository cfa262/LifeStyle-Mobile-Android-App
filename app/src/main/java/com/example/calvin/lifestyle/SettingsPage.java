package com.example.calvin.lifestyle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;



public class SettingsPage extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_page);

    }
    public void onWaterSettingsClicked(View w){
        if(w.getId() == R.id.WaterReminderSettingsButton){
            Intent ws = new Intent(SettingsPage.this, WaterSettings.class);
            startActivity(ws);
        }
    }
    public void onMotivationSettingsClicked(View s){
        if(s.getId() == R.id.MotivationSettingsButton){
            Intent ms = new Intent(SettingsPage.this, MotivationSettings.class);
            startActivity(ms);
        }
    }
    public void onProductivitySettingsClicked(View s){
        if(s.getId() == R.id.ProductivitySettingsButton){
            Intent ps = new Intent(SettingsPage.this, ProductivitySettings.class);
            startActivity(ps);
        }
    }

    public void onSettingsBackClicked(View s){
        if(s.getId() == R.id.backSettingsButton){
            Intent bs = new Intent(SettingsPage.this, IntroPage.class);
            startActivity(bs);

        }
    }

}