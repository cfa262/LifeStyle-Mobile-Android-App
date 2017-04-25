package com.example.calvin.lifestyle;

import android.app.Activity;
import android.app.NotificationManager;
import android.widget.CompoundButton;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.widget.Switch;

import java.util.*;



public class MotivationSettings extends Activity {

    public static ArrayList<String> quotes = new ArrayList<String>();

    //list of motivational quotes
    Switch switchOne   = (Switch) findViewById(R.id.switch1);
    Switch switchTwo   = (Switch) findViewById(R.id.switch10);
    Switch switchThree = (Switch) findViewById(R.id.switch13);
    Switch switchFour  = (Switch) findViewById(R.id.switch14);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.motivation_settings);

        switch1();
        switch2();

    }

    /*//adds quote to current list of quotes
    public void addQuote(View s){
        if(s.getId().equals(R.id.addQuote)){
            EditText input = (EditText)findViewById(R.id.enterNewQuote);
            String newQuote = input.getText().toString();
            Switch
        }
    }*/

    public void switch1(){

        switchOne.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonview, boolean isChecked){
                if(isChecked){
                    quotes.add("The harder you try, the better you are");
                }
                else{
                    quotes.remove("The harder you try, the better you are");
                }
            }
        });
    }

    public void switch2(){
        switchTwo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonview, boolean isChecked) {
                if (isChecked) {
                    quotes.add("Do what you need to do now! Thank yourself later!");
                }
                else{
                    quotes.remove("Do what you need to do now! Thank yourself later!");
                }
            }
        });
    }



}

