package io.simulation.collector.components;

public class Transmission{
    double transmissionLoss;
    double transmissionFrictionInM;

    public Transmission(double transmissionLoss, double transmissionFrictionInM){
        this.transmissionLoss = transmissionLoss;
        this.transmissionFrictionInM = transmissionFrictionInM;
    }
}
