package com.example.calvin.lifestyle;

import android.app.Activity;
import android.app.AlarmManager;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;

import android.widget.CompoundButton;
import android.widget.Switch;


import java.util.Calendar;


public class WaterSettingsPage extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_water);

        activateSwitches();

    }

    private void activateSwitches() {

        Switch reminderSwitch = (Switch) findViewById(R.id.reminderSwitch);
        reminderSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonview, boolean isChecked) {

                Switch eightAm = (Switch) findViewById(R.id.switch11);
                eightAm.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                    @Override
                    public void onCheckedChanged(CompoundButton buttonview, boolean isChecked) {
                        eightAmSwitch();
                    }

                });

            }


        });
    }
    private void eightAmSwitch(){
        Calendar calendar = Calendar.getInstance();
        int hours = calendar.get(Calendar.HOUR_OF_DAY);
        int minutes = calendar.get(Calendar.MINUTE);

        //calendar.set(Calendar.HOUR_OF_DAY, Calendar.get(Calendar.HOUR_OF_DAY));
        calendar.set(Calendar.HOUR_OF_DAY, hours);
        calendar.set(Calendar.MINUTE, minutes+1);
        calendar.set(Calendar.SECOND, 0);
        Intent intent = new Intent(WaterSettingsPage.this, NotificationReceiver.class);
        //Intent intent = new Intent(getApplicationContext(),NotificationReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(WaterSettingsPage.this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        //PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(),0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
    }
}
