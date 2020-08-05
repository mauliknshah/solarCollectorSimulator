# Solar Collector Simulator

Solar Collector Simulator is a simulation involving 4 components: 1. Solar Collector, 2. Water Pump, 3. Transmission, and 4. Water Tank. The simulator accomodates the thermodynamic principal of the energy and heat conversions, while giving as much information as possible in the observation.

# Files

- `io/runtime/RunSolarSimulation` file shows how to run the simulator with some dummy but practical parameters. 
- `io/simulator/collector/SolarCollectorSimulation` is the integrator class of all the components and runs the actual simulation. It provides `step`, `observe`, and `reset` method, as in the OpenAI Gym simulators.
- `io/simulator/collector/components` contains all the required components as POJO objects with some added functionalities. 

# References
- [Analysis of a Flat-plate Solar Collector, Author: Fabio Struckmann](https://www.lth.se/fileadmin/ht/Kurser/MVK160/Project_08/Fabio.pdf)
- [How can i calculate area of solar collector according to hourly hot water consumption?, ResearchGate](https://www.researchgate.net/post/how_can_i_calculate_area_of_solar_collector_according_to_hourly_hot_water_consumption)
- [Determining Collector Flow Rate, Build it Solar](https://www.builditsolar.com/References/ColFlowRate.htm)
- [Measuring Collector Performance and Efficiency, Build it Solar](https://www.builditsolar.com/References/Measurements/CollectorPerformance.htm#Efficiency)
- [High Performance Flat Plate Solar Thermal Collector Evaluation,  ROCKENBAUGH et all, NREL](https://www.nrel.gov/docs/fy16osti/66215.pdf)
- [Solar hot-water systems, Explin that stuff](https://www.explainthatstuff.com/solar-hot-water-systems.html)
- [Heat and temperature, Khan Academy](https://www.khanacademy.org/science/chemistry/thermodynamics-chemistry/internal-energy-sal/a/heat)
- [Temperature Change and Heat Capacity, Lumen](https://courses.lumenlearning.com/physics/chapter/14-2-temperature-change-and-heat-capacity/)
- [How to Calculate Water Pump Horsepower, WikiHow](https://www.wikihow.com/Calculate-Water-Pump-Horsepower)
