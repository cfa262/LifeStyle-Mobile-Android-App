package com.example.calvin.lifestyle;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

@RunWith(AndroidJUnit4.class)
@LargeTest

/**
 * Created by Jed on 4/29/2017.
 */

public class JedsTestCases {

    private String stringToBeShown;

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MotivationPage.class);

    @Before
    public void initValidString(){

    }


}
