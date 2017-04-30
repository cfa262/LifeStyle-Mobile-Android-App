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

                if(isChecked){
                    Switch eightAm = (Switch) findViewById(R.id.switch11);
                    Switch eightthirtySwitch = (Switch) findViewById(R.id.switch15);
                    Switch nineSwitch = (Switch) findViewById(R.id.switch16);
                    Switch ninethirtySwitch = (Switch) findViewById(R.id.switch17);
                    Switch tenSwitch = (Switch) findViewById(R.id.switch18);

                    eightAm.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                        @Override
                        public void onCheckedChanged(CompoundButton buttonview, boolean isChecked) {
                            if(isChecked){
                                eightAmSwitch();
                            }
                        }

                    });
                    eightthirtySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                        @Override
                        public void onCheckedChanged(CompoundButton buttonview, boolean isChecked) {
                            if(isChecked){
                                eightthirtySwitchOn();
                            }
                        }

                    });
                    nineSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                        @Override
                        public void onCheckedChanged(CompoundButton buttonview, boolean isChecked) {
                            if(isChecked){
                                nineSwitchOn();
                            }
                        }

                    });
                    ninethirtySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                        @Override
                        public void onCheckedChanged(CompoundButton buttonview, boolean isChecked) {
                            if(isChecked){
                                ninethirtySwitchOn();
                            }
                        }

                    });
                    tenSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                        @Override
                        public void onCheckedChanged(CompoundButton buttonview, boolean isChecked) {
                            if(isChecked){
                                tenSwitchOn();
                            }
                        }

                    });
                }


            }


        });
    }
    private void eightAmSwitch(){
        Calendar calendar = Calendar.getInstance();
        //int hours = calendar.get(Calendar.HOUR_OF_DAY);
        //int minutes = calendar.get(Calendar.MINUTE);

        //calendar.set(Calendar.HOUR_OF_DAY, Calendar.get(Calendar.HOUR_OF_DAY));
        calendar.set(Calendar.HOUR_OF_DAY, 8);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Intent intent = new Intent(WaterSettingsPage.this, NotificationReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(WaterSettingsPage.this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
    }
    private void eightthirtySwitchOn(){
        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.HOUR_OF_DAY, 8);
        calendar.set(Calendar.MINUTE, 30);
        calendar.set(Calendar.SECOND, 0);
        Intent intent = new Intent(WaterSettingsPage.this, NotificationReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(WaterSettingsPage.this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
    }
    private void nineSwitchOn(){
        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.HOUR_OF_DAY, 9);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Intent intent = new Intent(WaterSettingsPage.this, NotificationReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(WaterSettingsPage.this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
    }
    private void ninethirtySwitchOn(){
        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.HOUR_OF_DAY, 9);
        calendar.set(Calendar.MINUTE, 30);
        calendar.set(Calendar.SECOND, 0);
        Intent intent = new Intent(WaterSettingsPage.this, NotificationReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(WaterSettingsPage.this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
    }
    private void tenSwitchOn(){
        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.HOUR_OF_DAY, 10);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Intent intent = new Intent(WaterSettingsPage.this, NotificationReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(WaterSettingsPage.this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
    }
}
