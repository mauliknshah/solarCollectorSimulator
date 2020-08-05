package io.simulation.collector.components;

public class WaterPump {
    static final double GPM_TO_MLPS = 0.0630902 * 1000;
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

    public double pumpFlowMLPerSecond(double verticalDistanceFoot, double frictionLossFoot){
        return  3960 * this.powerHP * GPM_TO_MLPS / (verticalDistanceFoot + frictionLossFoot + 0.1);
    }
}
