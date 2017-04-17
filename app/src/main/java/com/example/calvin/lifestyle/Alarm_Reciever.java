package com.example.calvin.lifestyle;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Calvin on 4/15/2017.
 */

public class Alarm_Reciever extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.e("We are in the reciever", "It works!");
    }
}

//enter in manifest
//<receiver android:name=".Alarm_Reciever"/>