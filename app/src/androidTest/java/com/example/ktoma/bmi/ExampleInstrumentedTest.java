package com.example.ktoma.bmi;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.espresso.Espresso;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {


    @Rule
    public ActivityTestRule<bmiMainActivity> mActivityRule =
            new ActivityTestRule<>(bmiMainActivity.class);

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.ktoma.bmi", appContext.getPackageName());
    }

    @Test
    public void change_text_invalid_numbers_lbs() {
        onView(withId(R.id.mass_field))
                .perform(typeText("0"), closeSoftKeyboard());
        onView(withId(R.id.height_field))
                .perform(typeText("0"), closeSoftKeyboard());
        onView(withId(R.id.count_button)).perform(click());
        onView(withId(R.id.true_false)).check(matches(withText("Hey, wrong data!")));
    }

    @Test
    public void change_text_invalid_numbers_kg() {
        onView(withId(R.id.change_for_feets)).perform(click());
        onView(withId(R.id.mass_field))
                .perform(typeText("0"), closeSoftKeyboard());
        onView(withId(R.id.height_field))
                .perform(typeText("0"), closeSoftKeyboard());
        onView(withId(R.id.count_button)).perform(click());
        onView(withId(R.id.true_false)).check(matches(withText("Hey, wrong data!")));
    }

}
