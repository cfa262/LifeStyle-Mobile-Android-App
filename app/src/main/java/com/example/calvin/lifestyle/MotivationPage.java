package com.example.calvin.lifestyle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.*;



public class MotivationPage extends Activity {

    private ArrayList<String> quotes = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.motivation_page);

    }

    public void quotes(){
        this.quotes.add("The harder you try, the better you are");
        this.quotes.add("Lets get moving!");
        this.quotes.add("Keep it up!");
        this.quotes.add("You are going to do great!");
        this.quotes.add("No sleep till its done.");
    }

    //adds quote to current list of quotes
    public void addQuote(View s){
        if(s.getID().equals(R.id.addQuote)){
            EditText input = (EditText)findViewById(R.id.waterNumberText);
            String newQuote = input.getText().toString();
            this.quotes.add(newQuote);
        }
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