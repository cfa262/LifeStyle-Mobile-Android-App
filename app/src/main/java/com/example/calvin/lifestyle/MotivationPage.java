package com.example.calvin.lifestyle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.*;



public class MotivationPage extends Activity {

    TextView quoteGoesHere;
    public ArrayList<String> quotesFromSettings = MotivationSettings.quotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.motivation_page);
        String text = randomize();
        quoteGoesHere.setText(text);
    }


    public String randomize(){
        Random rand = new Random();
        int randomIndex = rand.nextInt(MotivationSettings.quotes.size() + 1);
        return quotesFromSettings.get(randomIndex);
    }
    //goes back to Settings page
    public void onMotivationBackClicked(View s){
        if(s.getId() == R.id.backMotivationButton){
            Intent i = new Intent(MotivationPage.this, IntroPage.class);
            startActivity(i);

        }
    }

    //goes to the Motivation Settings page
    public void onMotivationSettingsClicked(View s){
        if(s.getId() == R.id.motivationSettingsButton){
            Intent i = new Intent(MotivationPage.this, IntroPage.class);
            startActivity(i);
        }
    }
}