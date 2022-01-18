package com.petify_v2.view;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.petify_v2.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(AndroidJUnit4.class)

public class RegisterActivityTest {


    @Rule
    public ActivityScenarioRule<RegisterActivity> activityRule
            = new ActivityScenarioRule<>(RegisterActivity.class);


    @Test
    public void test_Register() {
        onView(withId(R.id.usernameregister)).perform(typeText("anastasia"));

        onView(withId(R.id.passwordregister)).perform(typeText("password"));

        onView(withId(R.id.emailregister)).perform(typeText("email"));

        onView(withId(R.id.btnOnRegisterForm)).perform(click());
    }

}