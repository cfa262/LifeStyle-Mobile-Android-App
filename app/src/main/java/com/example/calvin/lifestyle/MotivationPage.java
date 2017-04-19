package com.example.calvin.lifestyle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import java.util.*;

/**
 * Created by Calvin on 3/18/2017.
 */

public class MotivationPage extends Activity {

    ArrayList<String> quotes = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.motivation_page);

    }

    public void addQuote(){
        quotes.add("Add quote here");
    }

    //@Override
    public void onWaterClicked(View v){
        if(v.getId() == R.id.BWater){
            Intent i = new Intent(MotivationPage.this, Water.class);
            startActivity(i);

        }
    }

    public void onSettingsClicked(View s){
        if(s.getId() == R.id.BSettings){
            Intent a = new Intent(MotivationPage.this, SettingsPage.class);
            startActivity(a);

        }
    }

    public void onProductivityClicked(View s){
        if(s.getId() == R.id.BProductivity){
            Intent p = new Intent(MotivationPage.this, ProductivityPage.class);
            startActivity(p);

        }
    }

    //goes back to Settings page
    /*public void onMotivationBackClicked(View s){
        if(s.getId() == R.id.backMotivationButton){
            Intent i = new Intent(MotivationPage.this, IntroPage.class);
            startActivity(i);

        }
    }*/
}