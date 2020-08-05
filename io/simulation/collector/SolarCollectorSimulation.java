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
    private SolarDataGenerator solarDataGenerator;
    private String episodeObservation;


    public SolarCollectorSimulation(double collectorAreaSqM, double collectorEfficiency,
                                    double transmissionFrictionInM,double pumpPowerHP,
                                    double tankVolumeInL, double tankInHeightInM,
                                    double tankOutHeightInM, double tankHeatLossPerSecondInPercent,
                                    double initialAmbientTemp, double initialSolarRadiation,
                                    double fluctuationInWeather){
        this.solarCollector = new SolarCollector(collectorAreaSqM, collectorEfficiency);
        this.transmission = new Transmission(transmissionFrictionInM);
        this.waterPump = new WaterPump(pumpPowerHP);
        this.waterTank = new WaterTank(tankVolumeInL,tankVolumeInL,tankInHeightInM, tankOutHeightInM,
                initialAmbientTemp,0, tankHeatLossPerSecondInPercent);
        this.solarDataGenerator = new SolarDataGenerator(initialAmbientTemp,initialSolarRadiation,fluctuationInWeather);
    }



    @Override
    public void step() {
        resetObservation();
        //Generator generates the next sets of the ambient temperature and solar radiation.
        this.solarDataGenerator.generate();
        addObservation("Solar Radiation:" + this.solarDataGenerator.getSolarRadiation());
        addObservation(" Ambient Temperature:" + this.solarDataGenerator.getAmbientTemperature());

        //Initial Tank heat loss.
        this.waterTank.tankHeatLossAfterStep();
        addObservation("\n Tank Heat Loss at TimeStep:" + this.waterTank.getTankHeatEnergyInJ());


        //Pump pulls the water out from the tank.
        double waterPulledLeter = this.waterPump.pumpFlowLPerSecond(this.waterTank.getTankPumpingHeight(),
                this.transmission.getTransmissionFrictionInM());
        addObservation("\n Water Pulled By Pump:" + waterPulledLeter);
        this.waterTank.tankHeatLossFromWaterOut(waterPulledLeter);
        addObservation("\n Tank Heat after pulling Water:" + this.waterTank.getTankTempK());
        addObservation("\n Tank Water Volume after pulling Water:" + this.waterTank.getWaterVolumeInL());

        //Water Collector heats the water.
        double heatGeneration = this.solarCollector.solarHeatGeneration(this.solarDataGenerator.getSolarRadiation());
        addObservation("\n Solar Collector heat generation:" + heatGeneration);
        double heatTempOutInK = this.solarCollector.heatTemparatureOutInK(this.waterTank.getTankTempK(),
                heatGeneration, waterPulledLeter);
        addObservation("\n Solar Collector Temp out:" + heatTempOutInK);

        //Water goes in the Tank.
        this.waterTank.tankHeatGainFromWaterIn(waterPulledLeter, heatGeneration);
        addObservation("\n Tank Energy after Hot water in:" + this.waterTank.getTankHeatEnergyInJ());
        addObservation("\n Tank Water Volume after Hot water in:" + this.waterTank.getWaterVolumeInL());
        addObservation("\n Tank Temperature  after Hot water in:" + this.waterTank.getTankTempK());
    }

    @Override
    public String observe() {
        return this.episodeObservation;
    }

    @Override
    public void reset() {
        this.solarDataGenerator.reset();
        this.waterTank.reset();
    }

    public void addObservation(String s){
        this.episodeObservation += s;
    }

    private void resetObservation(){
        this.episodeObservation = "<--- New Step--------------- Heat in J, Temperature in K, Water in Liter ---->> \n";
    }
}
