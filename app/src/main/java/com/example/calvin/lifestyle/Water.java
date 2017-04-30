package com.example.calvin.lifestyle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import static com.example.calvin.lifestyle.R.id.currentWaterText;



public class Water extends Activity {

    MyDatabase myDatabase;
    int waterAmount;
    int currentWaterAmount;
    TextView waterTextView;
    EditText editWaterText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.water_reminder);
        editWaterText = (EditText)findViewById(R.id.waterNumberText);
        waterTextView = (TextView) findViewById(R.id.currentWaterText);
        myDatabase = new MyDatabase(this, null, null, 1);

        printDatabase();

    }
    int getCurrentWaterAmount(){
        return currentWaterAmount;
    }

    //Add a product to the database
    public void printDatabase(){
        String dbString = myDatabase.waterToString();
        currentWaterAmount = Integer.parseInt(dbString);
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
            //if(currentWaterAmount >= waterLimit)
                //Toast.makeText(getApplicationContext(), "CONGRATS! YOU'VE ACCOMPLISHED YOUR GOAL!", Toast.LENGTH_LONG).show();
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