package com.example.calvin.lifestyle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class IntroPage extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_page);

    }

    public void onWaterClicked(View v){
        if(v.getId() == R.id.BWater){
            Intent i = new Intent(IntroPage.this, Water.class);
            startActivity(i);

        }
    }

    public void onSettingsClicked(View s){
        if(s.getId() == R.id.BSettings){
            Intent a = new Intent(IntroPage.this, SettingsPage.class);
            startActivity(a);

        }
    }

    public void onProductivityClicked(View s){
        if(s.getId() == R.id.BProductivity){
            Intent p = new Intent(IntroPage.this, ProductivityPage.class);
            startActivity(p);

        }
    }
    public void onMotivationClicked(View s){
        if(s.getId() == R.id.BMotivation){
            Intent m = new Intent(IntroPage.this, MotivationPage.class);
            startActivity(m);

        }
    }

}
