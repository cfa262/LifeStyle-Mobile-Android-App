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

    int waterAmount;
    int currentWaterAmount = 0;
    float tempWaterAmount;
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

        //User user = new User();

        //waterText = (TextView)findViewById(R.id.myTextTitle);
        //String t = (TextView) findViewById(R.id.currentWaterText);
        //int tempWaterAmount = (TextView) findViewById(currentWaterText);
    }

    //Add a product to the database
    public void printDatabase(){
        String dbString = myDatabase.waterToString();
        //String dbString = myDatabase.databaseToString();
        waterTextView.setText(dbString);
        editWaterText.setText("");

    }
    //adds current intake of water
    public void addWaterClicked(View s){

        if(s.getId() == R.id.floatingActionButton){
            //EditText num = (EditText)findViewById(R.id.waterNumberText);
            String waterText = editWaterText.getText().toString();
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

    public void onWaterBackClicked(View s){
        if(s.getId() == R.id.backWaterButton){
            Intent i = new Intent(Water.this, IntroPage.class);
            startActivity(i);
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