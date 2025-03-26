package utils;

public class ModelParameters {
    private int simulationTime;
    private int requestFrequency;
    private int numberOfHandlers;
    private byte[] probability;
    private int queueSize;

    public ModelParameters(int requestFrequency, int numberOfHandlers, int queueSize, byte[] probability, int simulationTime) {
        if (numberOfHandlers != probability.length) {
            throw new IllegalArgumentException("Number of handlers does not match probability array");
        }
        if (simulationTime <= 0) {
            throw new IllegalArgumentException("Simulation time must be greater than zero");
        }
        this.requestFrequency = requestFrequency;
        this.numberOfHandlers = numberOfHandlers;
        this.queueSize = queueSize;
        this.probability = probability;
        this.simulationTime = simulationTime;
    }

    public int getRequestFrequency() {
        return requestFrequency;
    }

    public int getNumberOfHandlers() {
        return numberOfHandlers;
    }


    public int getQueueSize() {
        return queueSize;
    }

    public byte[] getProbability() {
        return probability;
    }

    public int getSimulationTime() {
        return simulationTime;
    }
}

