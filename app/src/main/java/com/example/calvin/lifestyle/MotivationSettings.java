package com.example.calvin.lifestyle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

import java.util.*;



public class MotivationSettings extends Activity {

    private ArrayList<String> quotes = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.motivation_settings);

        //list of motivational quotes
        Switch switchOne   = (Switch) findViewById(R.id.switch1);
        Switch switchTwo   = (Switch) findViewById(R.id.switch10);
        Switch switchThree = (Switch) findViewById(R.id.switch13);
        Switch switchFour  = (Switch) findViewById(R.id.switch14);



    }

    /*//adds quote to current list of quotes
    public void addQuote(View s){
        if(s.getId().equals(R.id.addQuote)){
            EditText input = (EditText)findViewById(R.id.enterNewQuote);
            String newQuote = input.getText().toString();
            Switch
        }
    }*/

    //goes back to the movitation page page
    public void onMotiSettingsBackClicked(View s){
        if(s.getId() == R.id.motivationSettingsBackButton){
            Intent i = new Intent(MotivationSettings.this, MotivationPage.class);
            startActivity(i);

        }
    }


}