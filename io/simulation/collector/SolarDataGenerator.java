package io.simulation.collector;


public class SolarDataGenerator {
    private double initialAmbientTemperature;
    private double initialSolarRadiation;
    private double ambientTemperature;
    private double solarRadiation;
    private double fluctuation;

    public SolarDataGenerator(double ambientTemperature,double solarRadiation, double fluctuation){
        this.initialAmbientTemperature = ambientTemperature;
        this.ambientTemperature = ambientTemperature;
        this.initialSolarRadiation = solarRadiation;
        this.solarRadiation = solarRadiation;
        this.fluctuation = fluctuation;
    }

    public void generate(){
        this.solarRadiation += (-1*solarRadiation*fluctuation) + (Math.random() * 2 * solarRadiation *fluctuation);
        this.ambientTemperature += (-1*ambientTemperature*fluctuation) + (Math.random() * 2 * ambientTemperature *fluctuation);
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
    public void reset(){
        this.ambientTemperature = this.initialAmbientTemperature;
        this.solarRadiation = this.initialSolarRadiation;
    }
}
