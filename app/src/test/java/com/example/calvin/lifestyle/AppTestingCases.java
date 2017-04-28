package com.example.calvin.lifestyle;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import org.junit.Test;

import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class AppTestingCases extends Activity {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void water_addition() throws Exception{
        //test if water count is adding correctly
        assertEquals(10, 2);

    }
    @Test
    public void water_subtraction() throws Exception{
        //test if water count is subtracting correctly
        assertEquals(5, 1);
    }

    @Test
    public void water_notification() throws Exception{
        //test if water reminder notification is working

    }

    @Test
    public void motivation_notification() throws Exception{
        //test if motivation notification is working

    }

    @Test
    public void productivity_notification() throws Exception{
        //test if productivity notification is working
        Switch proswitch = (Switch) findViewById(R.id.proswitch);
        String indicator= "OFF";

        proswitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonview, boolean isChecked) {

                if (isChecked) {
                    indicator="ON";
                    Toast.makeText(getApplicationContext(), indicator, Toast.LENGTH_LONG).show();

                    assertEquals(indicator, "ON");

                    Calendar calendar = Calendar.getInstance();
                    calendar.set(Calendar.HOUR_OF_DAY, 16);
                    calendar.set(Calendar.MINUTE, 41);
                    calendar.set(Calendar.SECOND, 0);
                    Intent intent = new Intent(ProductivitySettings.this, NotificationProductivity.class);
                    PendingIntent pendingIntent = PendingIntent.getBroadcast(ProductivitySettings.this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                    AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                    alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);

                } else {
                    Toast.makeText(getApplicationContext(), indicator, Toast.LENGTH_LONG).show();
                    assertEquals(indicator, "OFF");
                }
            }
        });

    }

    @Test
    public void is_data_displayed() throws Exception{
        //test if data is being displayed
        UsageStatsManager lUsageStatsManager = (UsageStatsManager) getSystemService(Context.USAGE_STATS_SERVICE);
        List<UsageStats> lUsageStatsList = lUsageStatsManager.queryUsageStats(UsageStatsManager.INTERVAL_DAILY, System.currentTimeMillis()- TimeUnit.DAYS.toMillis(1),System.currentTimeMillis()+ TimeUnit.DAYS.toMillis(1));

        assertNotEquals(lUsageStatsList,0);
    }

    @Test
    public void usage_time_is_correct() throws Exception{
        //test if the time of the application is correct

        UsageStatsManager lUsageStatsManager = (UsageStatsManager) getSystemService(Context.USAGE_STATS_SERVICE);
        List<UsageStats> lUsageStatsList = lUsageStatsManager.queryUsageStats(UsageStatsManager.INTERVAL_DAILY, System.currentTimeMillis()- TimeUnit.DAYS.toMillis(1),System.currentTimeMillis()+ TimeUnit.DAYS.toMillis(1));

        for (UsageStats lUsageStats:lUsageStatsList) {
            long time=TimeUnit.MILLISECONDS.toMinutes((lUsageStats.getTotalTimeInForeground()));
            assertNotEquals(time,0);
            }

        }

    @Test
    public void set_time_limit_notification_settings() throws Exception{
        //test if time limit is being set
        MyDatabase usage;

        int waterAmount;
        int currentWaterAmount = 0;
        TextView waterTextView;
        EditText editWaterText;

        String waterText = editWaterText.getText().toString();
        waterAmount = Integer.parseInt(waterText);
        waterTextView.setText(Integer.toString(waterAmount));
        WaterProduct product = new WaterProduct(waterTextView.getText().toString());
        usage.addProduct(product);

        assertNotEquals(currentWaterAmount,0);
}