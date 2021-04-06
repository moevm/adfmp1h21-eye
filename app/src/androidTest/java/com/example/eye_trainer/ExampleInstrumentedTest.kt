package com.example.eye_trainer

import androidx.test.core.app.ActivityScenario
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import kotlinx.android.synthetic.main.activity_enter_name.view.*

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.eye_trainer", appContext.packageName)
    }
    @Test
    fun main_visible(){
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.title)).check(matches(isDisplayed()))
        onView(withId(R.id.game)).check(matches(isDisplayed()))
        onView(withId(R.id.records)).check(matches(isDisplayed()))

    }
    @Test
    fun enter_name_visible(){
        val activityScenario = ActivityScenario.launch(EnterName::class.java)
        onView(withId(R.id.editText)).check(matches(isDisplayed()))
        onView(withId(R.id.submit_name)).check(matches(isDisplayed()))
    }
    @Test
    fun test_nav_Main_to_EnterName(){
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.game)).perform(click())
        onView(withId(R.id.editText)).check(matches(isDisplayed()))
    }
    @Test
    fun test_nav_Main_to_Records(){
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.records)).perform(click())
        onView(withId(R.id.title_record)).check(matches(isDisplayed()))
    }
    @Test
    fun testNav_Main_to_Records(){
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.game)).perform(click())
        onView(withId(R.id.editText)).perform(typeText("Player"))
        onView(withId(R.id.submit_name)).perform(click())
        onView(withId(R.id.answer)).perform(typeText("90\n"))
        onView(withId(R.id.button)).perform(click())
        onView(withId(R.id.answer)).perform(typeText("1.0\n"))
        onView(withId(R.id.button)).perform(click())
        onView(withId(R.id.answer)).perform(typeText("50\n"))
        onView(withId(R.id.button)).perform(click())
        onView(withId(R.id.title_record)).check(matches(withText("Рекорды")))
        //onView(withId(R.id.startAgain)).perform(click())
        //onView(withId(R.id.textView)).check(matches(isDisplayed()))
    }
}