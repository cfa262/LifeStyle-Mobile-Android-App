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
        @Override
        switchOne.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonview, boolean isChecked){
                if(isChecked){
                    quotes.add("The harder you try, the better you are");
                }
                else(!isChecked){
                    quotes.remove("The harder you try, the better you are");
                }
            }
        }
    }

    public void switch2(){
        switchTwo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonview, boolean isChecked) {
                if (isChecked) {
                    quotes.add("Do what you need to do now! Thank yourself later!");
                }
                else(!isChecked){
                    quotes.remove("Do what you need to do now! Thank yourself later!");
                }
            }
        }
    }

    //goes back to the movitation page page
    public void onMotiSettingsBackClicked(View s){
        if(s.getId() == R.id.motivationSettingsBackButton){
            Intent i = new Intent(MotivationSettings.this, MotivationPage.class);
            startActivity(i);

        }
    }


}

public class NotificationReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        Intent intent1 = new Intent(context,WaterSettings.class);
        intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        //if we want ring on notifcation then uncomment below line//
//        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        PendingIntent pendingIntent = PendingIntent.getActivity(context,100,intent1,PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                //.setSmallIcon(R.drawable.applogo)
                .setSmallIcon(R.drawable.ic_notifications_black_24dp)
                .setContentIntent(pendingIntent)
                .setContentText("It's time to drink water!")
                .setContentTitle("LIFESTYLE")
//                setSound(alarmSound).
                .setAutoCancel(true);
        notificationManager.notify(100,builder.build());

    }
}
