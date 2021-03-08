package com.example.ktoma.bmi;

import org.junit.Test;

import static org.junit.Assert.*;

public class ExampleUnitTest {

    @Test
    public void for_valid_mass_and_height_should_return_correct_value() {
        bmiForKg bmiCounter = new bmiForKg(60, 1.70);
        double bmi = bmiCounter.count();
        assertEquals(20.761, bmi, 0.01);
    }

    @Test (expected = IllegalArgumentException.class)
    public void zero_mass_and_height_for_kg() {
        bmiForKg bmiCounter = new bmiForKg(0, 0);
        double bmi = bmiCounter.count();
    }

    @Test (expected = IllegalArgumentException.class)
    public void zero_mass_for_kg() {
        bmiForKg bmiCounter = new bmiForKg(0, 1.70);
        double bmi = bmiCounter.count();
    }

    @Test (expected = IllegalArgumentException.class)
    public void zero_height_for_lbs() {
        bmiForFeetsAndPounds bmiCounter = new bmiForFeetsAndPounds(70, 0);
        double bmi = bmiCounter.count();
    }

    @Test (expected = IllegalArgumentException.class)
    public void zero_mass_and_height_for_lbs() {
        bmiForFeetsAndPounds bmiCounter = new bmiForFeetsAndPounds(0, 0);
        double bmi = bmiCounter.count();
    }

    @Test (expected = IllegalArgumentException.class)
    public void zero_mass_for_lbs() {
        bmiForFeetsAndPounds bmiCounter = new bmiForFeetsAndPounds(0, 1.70);
        double bmi = bmiCounter.count();
    }

    @Test (expected = IllegalArgumentException.class)
    public void zero_height_for_kg() {
        bmiForKg bmiCounter = new bmiForKg(70, 0);
        double bmi = bmiCounter.count();
    }

    @Test
    public void for_valid_mass_and_height_in_inches_should_return_correct_value() {
        bmiForFeetsAndPounds bmiCounter = new bmiForFeetsAndPounds(132, 60);
        double bmi = bmiCounter.count();
        assertEquals(25.574, bmi, 0.01);
    }

}