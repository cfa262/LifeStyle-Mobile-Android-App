package com.example.calvin.lifestyle;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.*;



public class MotivationPage extends Activity {

    TextView motivation;
    ArrayList<String> otherQuotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.motivation_page);
        otherQuotes = new ArrayList<String>();
        otherQuotes.add("You got this");
        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            String quote1 = bundle.getString("quote1");
            String quote2 = bundle.getString("quote2");
            String quote3 = bundle.getString("quote3");
            String quote4 = bundle.getString("quote4");
            String quote5 = bundle.getString("quote5");
            otherQuotes.add(quote1);
            otherQuotes.add(quote2);
            otherQuotes.add(quote3);
            otherQuotes.add(quote4);
            otherQuotes.add(quote5);
            motivation = (TextView) findViewById(R.id.quoteGoesHere);
            motivation.setText(quote1);
        }
    }


    /*public String randomize(){
        Random rand = new Random();
        if(MotivationSettings.quotes.size() == 0){
            return "Excuses don't burn calories";
        }
        int randomIndex = rand.nextInt(MotivationSettings.quotes.size() + 1);
        return quotesFromSettings.get(randomIndex);
    }*/



        //goes to the Motivation Settings page
    public void onMotivationSettingsClicked(View s){
        if(s.getId() == R.id.motivationSettingsButton){
            Intent i = new Intent(MotivationPage.this, MotivationSettings.class);
            startActivity(i);
        }
    }

    public void onChangeQuoteClicked(View s){
        if(s.getId() == R.id.changeButton){
            motivation = (TextView) findViewById(R.id.quoteGoesHere);
            Random rand = new Random();

            motivation.setText(otherQuotes.get(rand.nextInt(otherQuotes.size())));
        }
    }
}