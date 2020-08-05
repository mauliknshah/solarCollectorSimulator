package io.simulation;

public interface SimulationInterface {
    public void step();
    public String observe();
    public void reset();
}
