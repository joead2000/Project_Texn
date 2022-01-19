package com.petify_v2.view;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;


import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;



import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.petify_v2.R;
@RunWith(AndroidJUnit4.class)

public class youtubeSearchFailedTest {


    @Rule
    public ActivityScenarioRule<LoginActivity> activityRule
            = new ActivityScenarioRule<>(LoginActivity.class);

    @Test
    public void youtubeSearchFailedTest()
    {
        onView(withId(R.id.btnskip)).perform(click());
        onView(withId(R.id.openYoutubeFormbtn)).perform(click());
        onView(withId(R.id.videoTitle)).perform(typeText("       "), closeSoftKeyboard());
        onView(withId(R.id.searchButton)).perform(click());


    }

}