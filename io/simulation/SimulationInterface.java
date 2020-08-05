package io.simulation;

public interface SimulationInterface {
    public void init();
    public void step();
    public ObservationInterface observe();
    public void reset();
}
