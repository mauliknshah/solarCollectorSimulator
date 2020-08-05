package io.simulation.collector.components;

public class WaterPump {
    static final double GPM_TO_LPS = 0.0630902;
    double powerHP;

    WaterPump(double powerHP){
        this.powerHP = powerHP;
    }

    double getPowerHP() {
        return powerHP;
    }

    void setPowerHP(double powerHP) {
        this.powerHP = powerHP;
    }

    public double pumpFlowLPerSecond(double verticalDistanceFoot, double frictionLossFoot){
        return  3960 * this.powerHP * GPM_TO_LPS / (verticalDistanceFoot + frictionLossFoot + 0.1);
    }
}
