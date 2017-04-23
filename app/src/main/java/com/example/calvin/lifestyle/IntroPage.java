package com.example.calvin.lifestyle;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;
import android.widget.Toast;


public class IntroPage extends AppCompatActivity {

    private static final String TAG = "CalvinsInitialApp";
    private NotificationCompat.Builder builder;
    private NotificationManager notificationManager;
    private int notification_id;
    private RemoteViews remoteViews;
    private Context context;

    Button btn;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_page);

        /*
        btn = (Button) findViewById(R.id.notiButton);

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent();
                PendingIntent pIntent = PendingIntent.getActivity(IntroPage.this, 0, intent, 0);
                Notification noti = new Notification.Builder(IntroPage.this)
                        .setTicker("TickerTITLE")
                        .setContentTitle("WATER REMINDER")
                        .setContentText("It's time to drink water!")
                        .setSmallIcon(R.drawable.ic_notifications_black_24dp)
                        .setContentIntent(pIntent).getNotification();
                noti.flags = Notification.FLAG_AUTO_CANCEL;
                NotificationManager  nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                nm.notify(0,noti);

            }
        });
        */

        //context = this;
        //notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        //remoteViews = new RemoteViews(getPackageName(), R.layout.custom_notification);

        /*remoteViews.setImageViewResource(R.id.notif_icon, R.mipmap.ic_launcher);
        remoteViews.setTextViewText(R.id.notif_title, "TEXTT");
        remoteViews.setProgressBar(R.id.progressBar, 100, 50, true);

        notification_id = (int) System.currentTimeMillis();
        Intent button_intent = new Intent("button_clicked");
        button_intent.putExtra("id", notification_id);

        PendingIntent p_button_intent = PendingIntent.getBroadcast(context, 123, button_intent, 0);
        remoteViews.setOnClickPendingIntent(R.id.button, p_button_intent);


        findViewById(R.id.button_show_notif).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

                Intent notification_intent = new Intent(context, IntroPage.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(context,0,notification_intent,0);

                builder = new NotificationCompat.Builder(context);
                builder.setSmallIcon(R.mipmap.ic_launcher)
                        .setAutoCancel(true)
                        .setCustomBigContentView(remoteViews)
                        .setContentIntent(pendingIntent);
                notificationManager.notify(notification_id, builder.build());
            }
        });*/
    }

    //@Override
    public void onWaterClicked(View v){
        if(v.getId() == R.id.BWater){
            Intent i = new Intent(IntroPage.this, Water.class);
            startActivity(i);

        }
    }

    public void onSettingsClicked(View s){
        if(s.getId() == R.id.BSettings){
            Intent a = new Intent(IntroPage.this, SettingsPage.class);
            startActivity(a);

        }
    }

    public void onProductivityClicked(View s){
        if(s.getId() == R.id.BProductivity){
            Intent p = new Intent(IntroPage.this, ProductivityPage.class);
            startActivity(p);

        }
    }
    public void onMotivationClicked(View s){
        if(s.getId() == R.id.BMotivation){
            Intent m = new Intent(IntroPage.this, MotivationPage.class);
            startActivity(m);

        }
    }

}
