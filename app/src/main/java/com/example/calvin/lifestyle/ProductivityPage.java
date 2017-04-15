package com.example.calvin.lifestyle;

import android.app.AppOpsManager;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;
import java.util.concurrent.TimeUnit;



public class ProductivityPage extends AppCompatActivity
{

    private static final int MY_PERMISSIONS_REQUEST_PACKAGE_USAGE_STATS = 100;
    int x=0;
    System.out.println(x);

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.productivity_page);
        fillStats();
    }
    public void onProductivityBackClicked(View s)
    {
        if(s.getId() == R.id.backProductivityButton){
            Intent i = new Intent(ProductivityPage.this, IntroPage.class);
            startActivity(i);
        }
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

        for (UsageStats lUsageStats:lUsageStatsList)
        {
            lStringBuilder.append(lUsageStats.getPackageName());
            lStringBuilder.append(" used : ");
            lStringBuilder.append(lUsageStats.getLastTimeUsed());
            lStringBuilder.append("\r\n");
        }

        lTextView.setText(lStringBuilder.toString());
    }

}
