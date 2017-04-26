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



public class Water extends Activity {

    MyDatabase myDatabase;
    //WaterLimit myLimit;
    int waterAmount;
    int currentWaterAmount;
    float tempWaterAmount;
    TextView waterTextView;
    EditText editWaterText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.water_reminder);
        editWaterText = (EditText)findViewById(R.id.waterNumberText);
        waterTextView = (TextView) findViewById(R.id.currentWaterText);
        //myLimit = new WaterLimit();

        myDatabase = new MyDatabase(this, null, null, 1);
        printDatabase();

    }

    //Add a product to the database
    public void printDatabase(){
        String dbString = myDatabase.waterToString();
        currentWaterAmount = Integer.parseInt(dbString);
        //String dbString = myDatabase.databaseToString();
        waterTextView.setText(dbString);
        editWaterText.setText("");

    }
    //adds current intake of water
    public void addWaterClicked(View s){

        if(s.getId() == R.id.floatingActionButton){
            //EditText num = (EditText)findViewById(R.id.waterNumberText);
            String waterText = editWaterText.getText().toString();
            if(waterText.equals(""))
                waterText = "0";
            waterAmount = Integer.parseInt(waterText);
            this.currentWaterAmount += waterAmount;
            waterTextView.setText(Integer.toString(currentWaterAmount));

            //WaterProduct product = new WaterProduct(editWaterText.getText().toString());
            WaterProduct product = new WaterProduct(waterTextView.getText().toString());
            myDatabase.addProduct(product);
            printDatabase();

            System.out.print(currentWaterAmount);
            Log.d("ActionButton", "CurrentWaterAmount = " + currentWaterAmount);

        }
    }

    //subtracts water
    public void onClickSubtract(View s){
        if(s.getId() == R.id.subtractWater){
            //EditText num = (EditText)findViewById(R.id.waterNumberText);
            //String waterText = num.getText().toString();
            String waterText = editWaterText.getText().toString();
            if(waterText.equals(""))
                waterText = "0";
            waterAmount = Integer.parseInt(waterText);
            this.currentWaterAmount -= waterAmount;
            if(this.currentWaterAmount < 0)
                currentWaterAmount = 0;
            waterTextView.setText(Integer.toString(currentWaterAmount));

            WaterProduct product = new WaterProduct(waterTextView.getText().toString());
            myDatabase.addProduct(product);
            //String inputText = editWaterText.getText().toString();
            //myDatabase.deleteProduct(inputText);
            printDatabase();

            System.out.print(currentWaterAmount);
            Log.d("SubtractButton", "CurrentWaterAmount = " + currentWaterAmount);
        }
    }
    public void onWaterSettingsClick(View s){
        if(s.getId() == R.id.waterSetButton){
            Intent i = new Intent(Water.this, WaterSettingsPage.class);
            startActivity(i);
        }
    }
}