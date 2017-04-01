package com.example.calvin.lifestyle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class IntroPage extends AppCompatActivity {
    private static final String TAG = "CalvinsInitialApp";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_page);
    }

    //@Override
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
