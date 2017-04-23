package com.example.calvin.lifestyle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;



public class MotivationSettings extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.motivation_settings);

    }

    public void onMotiSettingsBackClicked(View s){
        if(s.getId() == R.id.motivationSettingsBackButton){
            Intent i = new Intent(MotivationSettings.this, SettingsPage.class);
            startActivity(i);

        }
    }


}