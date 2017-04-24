package com.example.calvin.lifestyle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;





public class MotivationPage extends Activity {

    TextView motivationalQuote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.motivation_page);

        motivationalQuote = (TextView) findViewById(R.id.quoteGoesHere);
    }



    //goes back to Settings page
    public void onMotivationBackClicked(View s){
        if(s.getId() == R.id.backMotivationButton){
            Intent i = new Intent(MotivationPage.this, IntroPage.class);
            startActivity(i);

        }
    }

    //goes to the Motivation Settings page
    public void onMotivationSettingsClicked(View s){
        if(s.getId() == R.id.motivationSettingsButton){
            Intent i = new Intent(MotivationPage.this, IntroPage.class);
            startActivity(i);
        }
    }
}