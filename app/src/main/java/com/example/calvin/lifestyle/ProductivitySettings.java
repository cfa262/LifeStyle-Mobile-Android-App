package com.example.calvin.lifestyle;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class ProductivitySettings extends Activity {

    MyDatabase usage;

    int waterAmount;
    int currentWaterAmount = 0;
    TextView waterTextView;
    EditText editWaterText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.productivity_settings);
        editWaterText = (EditText)findViewById(R.id.waterNumberText);
        waterTextView = (TextView) findViewById(R.id.currentWaterText);

        usage = new MyDatabase(this, null, null, 1);
        printDatabase();
        Switch proswitch = (Switch) findViewById(R.id.proswitch);


        proswitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonview, boolean isChecked) {

                if (isChecked) {
                    Toast.makeText(getApplicationContext(), "ON", Toast.LENGTH_LONG).show();

                    Calendar calendar = Calendar.getInstance();
                    calendar.set(Calendar.HOUR_OF_DAY, 16);
                    calendar.set(Calendar.MINUTE, 41);
                    calendar.set(Calendar.SECOND, 0);
                    Intent intent = new Intent(ProductivitySettings.this, NotificationProductivity.class);
                    PendingIntent pendingIntent = PendingIntent.getBroadcast(ProductivitySettings.this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                    AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                    alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);

                } else {
                    Toast.makeText(getApplicationContext(), "OFF", Toast.LENGTH_LONG).show();
                }
            }
        });
    }


    //Add a product to the database
    public void printDatabase(){
        String dbString = usage.waterToString();
        waterTextView.setText(dbString);
        editWaterText.setText("");

    }
    //adds current intake of water
    public void addWaterClicked(View s){

        if(s.getId() == R.id.floatingActionButton){
            String waterText = editWaterText.getText().toString();
            waterAmount = Integer.parseInt(waterText);
            this.currentWaterAmount += waterAmount;
            waterTextView.setText(Integer.toString(currentWaterAmount));

            WaterProduct product = new WaterProduct(waterTextView.getText().toString());
            usage.addProduct(product);
            printDatabase();

            System.out.print(currentWaterAmount);
            Log.d("ActionButton", "CurrentWaterAmount = " + currentWaterAmount);

        }
    }

    public void onProSettingsBackClicked(View s) {
        if (s.getId() == R.id.productivitySettingsBackButton) {
            Intent i = new Intent(ProductivitySettings.this, SettingsPage.class);
            startActivity(i);
        }
    }

}