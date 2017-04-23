package com.example.calvin.lifestyle;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.Calendar;



public class WaterSettings extends Activity {

    AlarmManager alarm_manager;
    TimePicker alarm_timepicker;
    Button btn;
    TextView update_text;
    Context context;
    PendingIntent pending_intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.water_settings);


        // initiate a Switch
        Switch reminderSwitch = (Switch) findViewById(R.id.switch2);
        Switch percentDone = (Switch) findViewById(R.id.switch11);
        Switch first830 = (Switch) findViewById(R.id.switch3);
        Switch second930 = (Switch) findViewById(R.id.switch4);
        Switch third1000 = (Switch) findViewById(R.id.switch5);
        Switch fourth1100 = (Switch) findViewById(R.id.switch6);
        Switch fifth1200 = (Switch) findViewById(R.id.switch7);
        Switch sixth100 = (Switch) findViewById(R.id.switch8);
        Switch seventh400 = (Switch) findViewById(R.id.switch9);
        Switch testSwitch = (Switch) findViewById(R.id.switch12);



        /*
        Button button = (Button) findViewById(R.id.waterTesterButton);

        button.setOnClickListener(new View.OnClickListener(){
             @Override
             public void onClick(View v){
                 Calendar calendar = Calendar.getInstance();
                 calendar.set(Calendar.HOUR_OF_DAY,1);
                 calendar.set(Calendar.MINUTE,6);
                 calendar.set(Calendar.SECOND, 0);
                 Intent intent = new Intent(getApplicationContext(),NotificationReceiver.class);
                 PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(),0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                 AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
                 alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),alarmManager.INTERVAL_DAY,pendingIntent);
             }
        });
        */


        //will activate and check if the switch is on or not
        reminderSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonview, boolean isChecked) {

                if (isChecked) {
                    Toast.makeText(getApplicationContext(), "ON", Toast.LENGTH_LONG).show();

                    Calendar calendar = Calendar.getInstance();
                    calendar.set(Calendar.HOUR_OF_DAY,22);
                    calendar.set(Calendar.MINUTE,35);
                    calendar.set(Calendar.SECOND,0);
                    Intent intent = new Intent(WaterSettings.this,NotificationReceiver.class);
                    //Intent intent = new Intent(getApplicationContext(),NotificationReceiver.class);
                    PendingIntent pendingIntent = PendingIntent.getBroadcast(WaterSettings.this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                    //PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(),0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                    AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
                    alarmManager.set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),pendingIntent);
                    //alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),alarmManager.INTERVAL_DAY,pendingIntent);

                    //gives a notification to user by calling this method
                    //addNotification();

                } else {
                    Toast.makeText(getApplicationContext(), "OFF", Toast.LENGTH_LONG).show();
                }
            }
        });


        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        //this.context = this;

        //initializes alarm manager
        //alarm_manager = (AlarmManager) getSystemService(ALARM_SERVICE);

        //initializes our text update box
        //update_text = (TextView) findViewById(R.id.update_text);

        //create instance of a calendar
        //final Calendar calendar = Calendar.getInstance();

        //create an intent to the Alarm Receiver class
        //Intent my_intent = new Intent(this.context, Alarm_Reciever.class);
    }

    /*
    //testing method to notify user by time
    private void notifyUserNow(){
        //set up time to be now
        Switch reminderSwitch = (Switch) findViewById(R.id.switch12);
        int hour = 8;
        int minute = 30;
        String hour_string = String.valueOf(hour);
        String minute_string = String.valueOf(minute);
        if(hour > 12){
            hour_string = String.valueOf(hour-12);
        }
        if(minute < 10){
            minute_string = "0" + String.valueOf(minute);
        }
        //setting calendar instance with the hour and minute
        calendar.set(Calendar.HOUR_OF_DAY, alarm_timepicker.getHour());
        calendar.set(Calendar.MINUTE, alarm_timepicker.getMinute());

        pending_intent = PendingIntent.getBroadcast(WaterSettings.this, 0,
                my_intent, PendingIntent.FLAG_UPDATE_CURRENT);
        //set alarm manager
        alarm_manager.set(AlarmManager.RTC_WAKEUP,
                calendar.getTimeInMillis(), pending_intent);
        */

        /*
        //create on slide listener to the class
        alarm_on.setOnClickListener(v) -> (

                //setting calendar instance with the hour and minute
                calendar.set(Calendar.HOUR_OF_DAY, alarm_timepicker.getHour());
                calendar.set(Calendar.MINUTE, alarm_timepicker.getMinute());

                int hour = alarm_timepicker.getHour();
                int minute = alarm_timepicker.getMinute();

                String hour_string = String.valueOf(hour);
                String minute_string = String.valueOf(minute);

                if(hour > 12){
                    hour_string = String.valueOf(hour-12);
                }
                if(minute < 10){
                    minute_string = "0" + String.valueOf(minute);
                }

                //method that changes the update text Textbox
                set_alarm_text("Alarm set to: " + hour_string + ":" + minute_string);

                pending_intent = PendingIntent.getBroadcast(WaterSettings.this, 0,
                        my_intent, PendingIntent.FLAG_UPDATE_CURRENT);


                //set alarm manager
        alarm_manager.set(AlarmManager.RTC_WAKEUP,
                calendar.getTimeInMillis(), pending_intent);
    });

    */

    /*
        btn = (Button) findViewById(R.id.notiButton);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                addNotification();
            }
        });
        */


    private void switchON(){

        /*
        // initiate a Switch
        Switch reminderSwitch = (Switch) findViewById(R.id.switch2);

        reminderSwitch.setOnCheckedChangeListener(new OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonview, boolean isChecked){
                if(isChecked){
                    Toast.makeText(getApplicationContext(), "ON", Toast.LENGTH_LONG.show();

                }else{
                    Toast.makeText(getApplicationContext(), "OFF", Toast.LENGTH_LONG.show();
                }
        }
                                           }
        // check current state of a Switch (true or false).
        Boolean switchState = reminderSwitch.isChecked();
        //if reminder switch is turned on - active
        if(switchState){
            //turn on notifications

        }*/
    }
    private void switchOff(){
        // initiate a Switch
        Switch reminderSwitch = (Switch) findViewById(R.id.switch2);

        // check current state of a Switch (true or false).
        Boolean switchState = reminderSwitch.isChecked();
        //if reminder switch is turned on - active
        if(!switchState){
            //turn off notifications

        }
    }
    private void addNotification(){

        Notification.Builder builder =
                new Notification.Builder(WaterSettings.this)
                .setTicker("TickerTITLE")
                .setContentTitle("WATER REMINDER")
                .setContentText("It's time to drink water!")
                .setSmallIcon(R.drawable.ic_notifications_black_24dp);

        Intent notificationIntent = new Intent(this, WaterSettings.class);
        PendingIntent contentIntent = PendingIntent.getActivity(WaterSettings.this,0, notificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);

        //Add as notification
        NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            manager.notify(0,builder.build());
        }

        // mId allows you to update the notification later on.
        //mNotificationManager.notify(mId, mBuilder.build());


        /*
               @Override
            public void onClick(View v){
                Intent intent = new Intent();
                PendingIntent pIntent = PendingIntent.getActivity(WaterSettings.this, 0, intent, 0);
                Notification builder = new Notification.Builder(WaterSettings.this)
                        .setTicker("TickerTITLE")
                        .setContentTitle("WATER REMINDER")
                        .setContentText("It's time to drink water!")
                        .setSmallIcon(R.drawable.ic_notifications_black_24dp)
                        .setContentIntent(pIntent).getNotification();
                builder.flags = Notification.FLAG_AUTO_CANCEL;
                NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                manager.notify(0,builder);
                //manager.notify(0,builder.build());

         */
    }

    public void onWaterSettingsBackClicked(View s) {
        if (s.getId() == R.id.waterSettingsBackButton) {
            Intent i = new Intent(WaterSettings.this, SettingsPage.class);
            startActivity(i);

        }
    }




}