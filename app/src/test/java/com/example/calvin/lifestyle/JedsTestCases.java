package com.example.calvin.lifestyle;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

@RunWith(AndroidJUnit4.class)


/**
 * Created by Jed on 4/29/2017.
 */

public class JedsTestCases {

    @Rule
    public ActivityTestRule<MotivationPage> mActivityRule = new ActivityTestRule<>(MotivationPage.class);

    @Test
    public void youGotThisTextView() throws Exception{

        //checks to see if the TextView reads "You got this!
        //when it's initially opened
        onView(withId(R.id.quoteGoesHere))
                .check(matches("You got this!"));
    }

    @Test
    public void goToMotivationPage() throws Exception{

        //checks to see if button with ID motivationSettingsButton
        //is clickable and goes to MotivationSettings

        onView(withId(R.id.motivationSettingsButton))
                .perform(click())
                .check(matches(instanceof(MotivationSettings)));
    }

    @Test
    public void switchOn() throws Exception{
        onView(withId(R.id.motivationSettingsButton))
                .perform(click());

        //checks to see if switch1 is enabled.
        onView(withId(R.id.switch1))
                .perform(click())
                .check(matches(isEnable()));

        onView(withId(R.id.backButton))
                .perform(click())
                .check(matches(instanceof(MotivationPage)));

        onView(withId(R.id.quoteGoesHere))
                .check(matches("The harder you try, the better you are"));
    }
}
