package io.simulation.collector.components;

public class WaterPump {
    static final double GPM_TO_LPS = 0.0630902;
    static final double METER_TO_FOOT = 3.28084;
    static final double FLOW_CONSTANT = 3960;

    private double powerHP;
    private double pumpEfficiency;

    public WaterPump(double powerHP, double pumpEfficiency){
        this.powerHP = powerHP;
        this.pumpEfficiency = pumpEfficiency;
    }

    double getPowerHP() {
        return powerHP;
    }

    void setPowerHP(double powerHP) {
        this.powerHP = powerHP;
    }

    public double pumpFlowLPerSecond(double verticalDistance, double frictionLoss){
        return  FLOW_CONSTANT * this.pumpEfficiency * this.powerHP * GPM_TO_LPS / (meterToFoot(verticalDistance + frictionLoss) + 0.1);
    }

    private double meterToFoot(double meterValue){
        return METER_TO_FOOT*meterValue;
    }
}

