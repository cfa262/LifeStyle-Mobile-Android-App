package com.example.calvin.lifestyle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Calvin on 3/18/2017.
 */

public class ProductivityPage extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.productivity_page);
    }

    public void onProductivityBackClicked(View s){
        if(s.getId() == R.id.backProductivityButton){
            Intent i = new Intent(ProductivityPage.this, IntroPage.class);
            startActivity(i);

        }
    }
}