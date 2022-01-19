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

public class ViewAlbumsActivityTest {


    @Rule
    public ActivityScenarioRule<ViewAlbumsActivity> activityRule
            = new ActivityScenarioRule<>(ViewAlbumsActivity.class);

    @Test
    public void ArtistSearchTest()
    {
        onView(withId(R.id.nameofartist)).perform(typeText("The Weekend"), closeSoftKeyboard());
        onView(withId(R.id.btnfind2)).perform(click());


    }

}