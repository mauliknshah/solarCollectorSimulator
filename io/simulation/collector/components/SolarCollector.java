package io.simulation.collector.components;

public class SolarCollector {
    double areaSqM;
    double efficiency;

    SolarCollector(double areaSqM, double efficiency){
        this.areaSqM = areaSqM;
        this.efficiency = efficiency;
    }

    public double getAreaSqM() {
        return areaSqM;
    }

    public void setAreaSqM(double areaSqM) {
        this.areaSqM = areaSqM;
    }

    public double getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(double efficiency) {
        this.efficiency = efficiency;
    }

    public double solarHeatGeneration(double solarRadiationWattPerMSq){
        return this.areaSqM * this.efficiency * solarRadiationWattPerMSq;
    }
}
