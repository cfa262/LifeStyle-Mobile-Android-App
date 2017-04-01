package com.example.calvin.lifestyle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Calvin on 3/18/2017.
 */

public class Water extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.water_reminder);

    }

    public void onWaterBackClicked(View s){
        if(s.getId() == R.id.backWaterButton){
            Intent i = new Intent(Water.this, IntroPage.class);
            startActivity(i);

        }
    }
}