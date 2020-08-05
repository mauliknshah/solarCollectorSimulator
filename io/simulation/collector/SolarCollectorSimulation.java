package io.simulation.collector;
import io.simulation.collector.components.SolarCollector;
import io.simulation.collector.components.Transmission;
import io.simulation.collector.components.WaterPump;
import io.simulation.collector.components.WaterTank;
import io.simulation.interfaces.SimulationInterface;


public class SolarCollectorSimulation implements SimulationInterface {
    private SolarCollector solarCollector;
    private Transmission transmission;
    private WaterPump waterPump;
    private WaterTank waterTank;


    public SolarCollectorSimulation(double collectorAreaSqM, double collectorEfficiency,
                                    double transmissionLossPerSecond, double transmissionFrictionInM,
                                    double transmissionVolumeFromPumpToTank, double pumpPowerHP,
                                    double tankVolumeInL, double waterVolumeInL, double tankInHeightInM,
                                    double tankOutHeightInM, double tankTempK, double tankHeatEnergyInJ,
                                    double tankHeatLossPerSecondInPercent){
        this.solarCollector = new SolarCollector(collectorAreaSqM, collectorEfficiency);
        this.transmission = new Transmission(transmissionLossPerSecond, transmissionFrictionInM, transmissionVolumeFromPumpToTank);
        this.waterPump = new WaterPump(pumpPowerHP);
        this.waterTank = new WaterTank(tankVolumeInL,waterVolumeInL,tankInHeightInM, tankOutHeightInM,
                tankTempK,tankHeatEnergyInJ, tankHeatLossPerSecondInPercent);
    }



    @Override
    public void step() {

    }

    @Override
    public String observe() {
        return null;
    }

    @Override
    public void reset() {

    }
}
