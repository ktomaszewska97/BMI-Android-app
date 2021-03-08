package com.example.ktoma.bmi;

public abstract class countBmi {

    private double mass;
    private double height;

    countBmi(double mass, double height) {
        this.mass = mass;
        this.height = height;
    }

    abstract public double count();

    protected boolean dataAreValid() {

        return mass>0 && height>0;
    }

    public double getMass() {

        return mass;
    }

    public double getHeight() {

        return height;
    }

    public void setHeight(double height) {

        this.height = height;
    }

    public void setMass(double mass) {

        this.mass = mass;

    }
}
