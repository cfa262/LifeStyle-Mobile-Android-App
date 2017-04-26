package com.example.calvin.lifestyle;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.os.Build;
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

    public ArrayList<String> quotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.motivation_settings);

        //ArrayList<String> quotes = new ArrayList<String>();

        quotes = new ArrayList<String>();

        //list of motivational quotes
        switch1();
        switch13();
        switch10();
        switch14();
        switch16();
    }

    private void addNotification() {

        Notification.Builder builder =
                new Notification.Builder(MotivationSettings.this)
                        .setTicker("TickerTITLE")
                        .setContentTitle("Motivation")
                        .setContentText("The harder you try, the better you are")
                        .setSmallIcon(R.drawable.ic_notifications_black_24dp);

        Intent notificationIntent = new Intent(this, MotivationSettings.class);
        PendingIntent contentIntent = PendingIntent.getActivity(MotivationSettings.this, 0, notificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);

        //Add as notification
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            manager.notify(0, builder.build());
        }
    }



    public void switch1(){
        Switch switchOne   = (Switch) findViewById(R.id.switch1);
        switchOne.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonview, boolean isChecked){
                if(isChecked){
                    addNotification();
                    quotes.add("The harder you try, the better you are");
                }
                /*else{
                    quotes.remove("The harder you try, the better you are");
                }*/
            }
        });
    }

    public void switch13(){
        Switch switchThirteen   = (Switch) findViewById(R.id.switch13);
        switchThirteen.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonview, boolean isChecked) {

                    if (isChecked) {
                        quotes.add("Do what you need to do now! Thank yourself later!");
                    }

                /*else{
                    quotes.remove("Do what you need to do now! Thank yourself later!");
                }*/
            }

        });
    }

    public void switch10(){
        Switch switchTen   = (Switch) findViewById(R.id.switch10);
        switchTen.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonview, boolean isChecked) {

                if (isChecked) {
                    quotes.add("Let's get moving");
                }

                /*else{
                    quotes.remove("Do what you need to do now! Thank yourself later!");
                }*/
            }

        });
    }

    public void switch14(){
        Switch switchFourteen   = (Switch) findViewById(R.id.switch14);
        switchFourteen.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonview, boolean isChecked) {

                if (isChecked) {
                    quotes.add("Keep it up!");
                }

                /*else{
                    quotes.remove("Do what you need to do now! Thank yourself later!");
                }*/
            }

        });
    }

    public void switch16(){
        Switch switchSixteen   = (Switch) findViewById(R.id.switch16);
        switchSixteen.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonview, boolean isChecked) {

                if (isChecked) {
                    quotes.add("Don't wish for it, work for it");
                }

                /*else{
                    quotes.remove("Do what you need to do now! Thank yourself later!");
                }*/
            }

        });
    }

    public void onMotivationPageClick(View s){
        if(s.getId() == R.id.backButton) {
            Intent passDataIntent = new Intent(this, MotivationPage.class);
            passDataIntent.putExtra("quote1", quotes.get(0));
            passDataIntent.putExtra("quote2", quotes.get(1));
            passDataIntent.putExtra("quote3", quotes.get(2));
            passDataIntent.putExtra("quote4", quotes.get(3));
            passDataIntent.putExtra("quote5", quotes.get(4));
            startActivity(passDataIntent);
        }
    }

}

