package io.runtime;
import io.simulation.collector.SolarCollectorSimulation;
public class RunSolarSimulation {
    public static void main(String[] args){
        SolarCollectorSimulation simulation = new SolarCollectorSimulation(
                4, 0.8,
                4, 1, 0.5,
                25.13, 1.8,
                0.2, 0.005,
                300,300,
                0.005);

        simulation.reset();
        for (int step = 0; step < 3600; step++){
            simulation.step();
            System.out.println(simulation.observe());
        }

    }
}
