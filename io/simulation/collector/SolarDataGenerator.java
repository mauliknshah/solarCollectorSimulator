package io.simulation.collector;

import io.simulation.collector.components.SolarCollector;

public class SolarDataGenerator {
    private double ambientTemperature;
    private double solarRadiation;
    private double fluctuation;

    public SolarDataGenerator(double ambientTemperature,double solarRadiation, double fluctuation){
        this.ambientTemperature = ambientTemperature;
        this.solarRadiation = solarRadiation;
        this.fluctuation = fluctuation;
    }

    public void generate(){
        this.solarRadiation += (-1*solarRadiation*fluctuation) + Math.random() * 2 * solarRadiation * solarRadiation;
        this.ambientTemperature += (-1*ambientTemperature*fluctuation) + Math.random() * 2 * ambientTemperature * solarRadiation;
    }

    public double getAmbientTemperature() {
        return ambientTemperature;
    }

    public double getSolarRadiation() {
        return solarRadiation;
    }

    public double getFluctuation() {
        return fluctuation;
    }
}
