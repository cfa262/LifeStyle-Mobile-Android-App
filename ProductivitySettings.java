package com.example.calvin.lifestyle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.lang.reflect.AccessibleObject;

/**
 * Created by Calvin on 4/10/2017.
 */

public class ProductivitySettings extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.productivity_settings);

    }

    public void onProSettingsBackClicked(View s){
        if(s.getId() == R.id.productivitySettingsBackButton){
            Intent i = new Intent(ProductivitySettings.this, SettingsPage.class);
            startActivity(i);

        }
    }

}
