package io.simulation.collector.components;

public class SolarCollector {
    static final double WATER_HEAT_CAPACITY = 4179.6;
    double areaSqM;
    double efficiency;

    public SolarCollector(double areaSqM, double efficiency){
        this.areaSqM = areaSqM;
        this.efficiency = efficiency;
    }

    public double solarHeatGeneration(double solarRadiationWattPerMSq){
        return this.areaSqM * this.efficiency * solarRadiationWattPerMSq;
    }

    public double heatTemparatureOutInK(double solarHeatInJ, double tempInK, double waterVolumeInL){
        return tempInK + (solarHeatInJ / (waterVolumeInL * WATER_HEAT_CAPACITY));
    }
}
