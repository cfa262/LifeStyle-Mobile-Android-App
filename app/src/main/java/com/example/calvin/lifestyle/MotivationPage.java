package com.example.calvin.lifestyle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;



public class MotivationPage extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.motivation_page);

    }

    public void onMotivationBackClicked(View s){
        if(s.getId() == R.id.backMotivationButton){
            Intent i = new Intent(MotivationPage.this, IntroPage.class);
            startActivity(i);

        }
    }
}