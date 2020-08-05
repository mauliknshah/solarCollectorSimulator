package io.simulation.collector.components;

public class Transmission{
    double transmissionLoss;
    double transmissionFrictionInM;
    double volumeFromPumpToTank;

    public Transmission(double transmissionLoss, double transmissionFrictionInM, double volumeFromPumpToTank){
        this.transmissionLoss = transmissionLoss;
        this.transmissionFrictionInM = transmissionFrictionInM;
        this.volumeFromPumpToTank = volumeFromPumpToTank;
    }

    double heatTransmissionLossPerStep(double flowPerSecond){
        return (this.volumeFromPumpToTank/flowPerSecond) * this.transmissionLoss;
    }

}
