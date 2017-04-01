package com.example.calvin.lifestyle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class IntroPage extends AppCompatActivity {
    private static final String TAG = "CalvinsInitialApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_page);
    }
        //Button btn = (Button) findViewById(R.id.button);
        //Button bWater = (Button) findViewById(R.id.BWater);
        //..happens when the user clicks
        //BWater.setOnClickListener(new View.OnClickListener(){
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

        //});
        /*
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.i(TAG, "This is a magic message!");
                Toast.makeText(getApplicationContext(), "It's magic!", Toast.LENGTH_SHORT).show();
            }
        });
                */

}
