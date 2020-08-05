package io.simulation.collector.components;
import java.lang.Math;

public class WaterTank {
    static final double WATER_HEAT_CAPACITY = 4182;
    double tankVolumeInL;
    double waterVolumeInL;
    double tankInHeightInM;
    double tankOutHeightInM;
    double tankTempK;
    double tankHeatEnergyInJ;
    double tankHeatLossPerSecondInPercent;
    
    WaterTank ( double tankVolumeInL, double waterVolumeInL, double tankInHeightInM,
                double tankOutHeightInM, double tankTempK, double tankHeatEnergyInJ,
                double tankHeatLossPerSecondInPercent){
        
        if(tankInHeightInM < tankOutHeightInM){
            throw new AssertionError("Tank Input must be higher than the output height.");
        }
            
        this.tankVolumeInL = tankVolumeInL;
        this.waterVolumeInL = waterVolumeInL;
        this.tankInHeightInM = tankInHeightInM;
        this.tankOutHeightInM = tankOutHeightInM;
        this.tankTempK = tankTempK;
        this.tankHeatEnergyInJ = tankHeatEnergyInJ;
        this.tankHeatLossPerSecondInPercent = tankHeatLossPerSecondInPercent;
    }



    public void tankHeatLossAfterStep(){
        double heatLoss = Math.max(0.01 * this.tankHeatLossPerSecondInPercent * this.tankHeatEnergyInJ,0);
        this.tankHeatEnergyInJ -= heatLoss;
        this.tankTempK += (-1*heatLoss)/ this.waterVolumeInL * this.WATER_HEAT_CAPACITY;
    }

    public void tankHeatLossFromWaterOut(double waterVolumeLoss){
        this.tankHeatEnergyInJ -= ((this.tankHeatEnergyInJ/this.waterVolumeInL) * waterVolumeLoss);
        this.waterVolumeInL -= waterVolumeLoss;
    }

    public void tankHeatGainFromWaterIn(double waterVolumeInL, double heatInJ){
        this.tankHeatEnergyInJ += heatInJ;
        this.waterVolumeInL += Math.min(waterVolumeInL, this.tankVolumeInL);
        this.tankTempK += (heatInJ)/ this.waterVolumeInL * this.WATER_HEAT_CAPACITY;
    }



}
