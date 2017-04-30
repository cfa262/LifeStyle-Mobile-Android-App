package com.example.calvin.lifestyle;

import android.app.Activity;
import android.app.Instrumentation;
import android.support.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;


public class SettingsPageTest {
    @Rule
    public ActivityTestRule<SettingsPage> activityTestRule = new ActivityTestRule<>(SettingsPage.class);

    private SettingsPage settingsActivity = null;

    Instrumentation.ActivityMonitor waterMonitor = getInstrumentation().addMonitor(WaterSettingsPage.class.getName(), null, false);
    Instrumentation.ActivityMonitor motivationMonitor = getInstrumentation().addMonitor(MotivationSettings.class.getName(), null, false);
    Instrumentation.ActivityMonitor productivityMonitor = getInstrumentation().addMonitor(ProductivitySettings.class.getName(), null, false);

    @Before
    public void setUp() throws Exception {

        settingsActivity = activityTestRule.getActivity();


    }

    @After
    public void tearDown() throws Exception {
        settingsActivity = null;
    }

    @Test
    public void goToWaterSettings() throws Exception{

        assertNotNull(settingsActivity.findViewById(R.id.waterSetButton));

        onView(withId(R.id.waterSetButton))
                .perform(click());

        Activity settingsActivity = getInstrumentation().waitForMonitorWithTimeout(waterMonitor, 5000);

        assertNotNull(settingsActivity);

        settingsActivity.finish();

    }
    @Test
    public void goToMotivationSettings() throws Exception{

        assertNotNull(settingsActivity.findViewById(R.id.waterSetButton));

        onView(withId(R.id.waterSetButton))
                .perform(click());

        Activity settingsActivity = getInstrumentation().waitForMonitorWithTimeout(motivationMonitor, 5000);

        assertNotNull(settingsActivity);

        settingsActivity.finish();

    }
    @Test
    public void goToProductivitySettings() throws Exception{

        assertNotNull(settingsActivity.findViewById(R.id.waterSetButton));

        onView(withId(R.id.waterSetButton))
                .perform(click());

        Activity settingsActivity = getInstrumentation().waitForMonitorWithTimeout(productivityMonitor, 5000);

        assertNotNull(settingsActivity);

        settingsActivity.finish();

    }

}