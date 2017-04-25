package com.example.calvin.lifestyle;

import android.app.AppOpsManager;
import android.content.pm.PackageManager;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ProductivityPage extends AppCompatActivity
{

    private static final int MY_PERMISSIONS_REQUEST_PACKAGE_USAGE_STATS = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.productivity_page);
        fillStats();
    }


    private void fillStats()
    {
        if (hasPermission())
        {
            getStats();
        }
        else
        {
            requestPermission();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        Log.d("MainActivity", "resultCode " + resultCode);
        switch (requestCode){
            case MY_PERMISSIONS_REQUEST_PACKAGE_USAGE_STATS:
                fillStats();
                break;
        }
    }

    private void requestPermission()
    {
        Toast.makeText(this, "Need to request permission", Toast.LENGTH_SHORT).show();
        startActivityForResult(new Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS), MY_PERMISSIONS_REQUEST_PACKAGE_USAGE_STATS);
    }

    private boolean hasPermission()
    {
        AppOpsManager appOps = (AppOpsManager)
                getSystemService(Context.APP_OPS_SERVICE);
        int mode = appOps.checkOpNoThrow(AppOpsManager.OPSTR_GET_USAGE_STATS,
                android.os.Process.myUid(), getPackageName());
        return mode == AppOpsManager.MODE_ALLOWED;
    }

    private void getStats()
    {
        UsageStatsManager lUsageStatsManager = (UsageStatsManager) getSystemService(Context.USAGE_STATS_SERVICE);
        List<UsageStats> lUsageStatsList = lUsageStatsManager.queryUsageStats(UsageStatsManager.INTERVAL_DAILY, System.currentTimeMillis()- TimeUnit.DAYS.toMillis(1),System.currentTimeMillis()+ TimeUnit.DAYS.toMillis(1));

        TextView lTextView = (TextView) findViewById(R.id.usage_stats);

        StringBuilder lStringBuilder = new StringBuilder();
        lStringBuilder.append("\r\n\n\n\n");
        PackageManager pm = this.getPackageManager();
        CharSequence most=null;
        long currentMost=0;
        CharSequence least=null;
        long currentLeast=0;
        long total=0;
        int count=0;
        for (UsageStats lUsageStats:lUsageStatsList)
        {
            CharSequence c=null;
            try {
                 c= pm.getApplicationLabel(pm.getApplicationInfo(lUsageStats.getPackageName(), PackageManager.GET_META_DATA));
            }catch(Exception e) {}
            long time=TimeUnit.MILLISECONDS.toMinutes((lUsageStats.getTotalTimeInForeground()));
            if(time==0)
            {
                continue;
            }
            if(count==0)
            {
                currentLeast=time;
                least=c;
                count++;
            }
            if(time>currentMost)
            {
                most=c;
                currentMost=time;
            }
            if(time<currentLeast)
            {
                least=c;
                currentLeast=time;
            }
            total+=time;
            lStringBuilder.append(c);
            lStringBuilder.append(" used : ");
            lStringBuilder.append(TimeUnit.MILLISECONDS.toMinutes((lUsageStats.getTotalTimeInForeground())));
            lStringBuilder.append(" minutes");
            lStringBuilder.append("\r\n");
        }
        lStringBuilder.append("\r\n");
        lStringBuilder.append("Statistics:\n");
        lStringBuilder.append("Most used application: "+most + " "+ currentMost+" minutes\n");
        lStringBuilder.append("Least used application: "+least +" "+ currentLeast+" minutes\n");
        lStringBuilder.append("Total time spent on phone today: "+ total +" minutes\n");
        lTextView.setText(lStringBuilder.toString());
    }
}
