package io.simulation.collector.components;

public class Transmission{
    double transmissionFrictionInM;

    public Transmission(double transmissionFrictionInM){
        this.transmissionFrictionInM = transmissionFrictionInM;
    }

    public double getTransmissionFrictionInM() {
        return transmissionFrictionInM;
    }
}
