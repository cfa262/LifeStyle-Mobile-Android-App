package com.example.calvin.lifestyle;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.Calendar;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;


public class WaterSettingsPageTest extends Activity {

    @Rule
    public ActivityTestRule<WaterSettingsPage> activityTestRule = new ActivityTestRule<>(WaterSettingsPage.class);

    private WaterSettingsPage waterSettingsActivity = null;

    @Before
    public void setUp() throws Exception {
        waterSettingsActivity = activityTestRule.getActivity();
    }

    @Test
    public void testSettingsActivityLaunch(){
        //checks if the activity has launched correctly

        View view = waterSettingsActivity.findViewById(R.id.reminderSwitch);
        assertNotNull(view);
    }
    @After
    public void tearDown() throws Exception {
        waterSettingsActivity = null;

    }

    @Test
    public void reminderSwitchTest() {

        onView(withId(R.id.reminderSwitch))
                .perform(click())
                .check(matches(isEnabled()));
    }

    @Test
    public void eightSwitchTest() {

        onView(withId(R.id.switch11))
                .perform(click())
                .check(matches(isEnabled()));


    }
    @Test
    public void eightthirtySwitchTest(){
        onView(withId(R.id.switch15))
                .perform(click())
                .check(matches(isEnabled()));

    }
    @Test
    public void nineSwitchTest(){
        onView(withId(R.id.switch16))
                .perform(click())
                .check(matches(isEnabled()));

    }


}