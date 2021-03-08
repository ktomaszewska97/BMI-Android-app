package com.example.ktoma.bmi;

public class bmiForFeetsAndPounds extends countBmi {

    public bmiForFeetsAndPounds(double mass, double height) {

        super(mass, height);

    }

    @Override
    public double count() {

        double newHeight = getHeight()/39.37;
        double newMass = getMass()*0.45;

        if(dataAreValid()) {
            return (newMass/(newHeight*newHeight));
        }
        else {
            throw new IllegalArgumentException("Invalid data");
        }

    }

}
