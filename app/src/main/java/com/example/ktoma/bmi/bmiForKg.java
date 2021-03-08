package com.example.ktoma.bmi;

public class bmiForKg extends countBmi {

    public bmiForKg(double mass, double height) {

        super(mass, height);

    }

    @Override
    public double count() {
        if(dataAreValid()) {
            return (getMass()/(getHeight()*getHeight()));
        }
        else {
            throw new IllegalArgumentException("Invalid data");
        }
    }
}
