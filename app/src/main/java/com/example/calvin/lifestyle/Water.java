package com.example.calvin.lifestyle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import static com.example.calvin.lifestyle.R.id.currentWaterText;

/**
 * Created by Calvin on 3/18/2017.
 */

public class Water extends Activity {

    int waterAmount;
    int currentWaterAmount = 0;
    float tempWaterAmount;
    TextView waterText;
    EditText editWaterText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.water_reminder);
        editWaterText = (EditText)findViewById(R.id.currentWaterText);
        //waterText = (TextView)findViewById(R.id.myTextTitle);
        //String t = (TextView) findViewById(R.id.currentWaterText);
        //int tempWaterAmount = (TextView) findViewById(currentWaterText);
    }

    public void onWaterBackClicked(View s){
        if(s.getId() == R.id.backWaterButton){
            Intent i = new Intent(Water.this, IntroPage.class);
            startActivity(i);
        }
    }

    //adds current intake of water
    public void addWaterClicked(View s){
        if(s.getId() == R.id.floatingActionButton){
            EditText num = (EditText)findViewById(R.id.waterNumberText);
            String waterText = num.getText().toString();
            waterAmount = Integer.parseInt(waterText);
            this.currentWaterAmount += waterAmount;
            editWaterText.setText(Integer.toString(currentWaterAmount));
            System.out.print(currentWaterAmount);
            Log.d("ActionButton", "CurrentWaterAmount = "+currentWaterAmount);

        }
    }
    /*
    public void waterEnteredClicked(View s){
        if(s.getId() == R.id.enterWaterButton){
            //this.currentWaterAmount += R.id.waterNumberText;

            EditText num = (EditText)findViewById(R.id.waterNumberText);
            String waterText = num.getText().toString();
            waterAmount = Integer.parseInt(waterText);
            this.currentWaterAmount += waterAmount;
            System.out.print(currentWaterAmount);
            Log.d("EnterButton", "CurrentWaterAmount = "+currentWaterAmount);

        }
    }
    */


}