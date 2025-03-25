package entity;

public class RequestGenerator {
    private int requestFrequency;

    RequestGenerator(int frequency) {
        requestFrequency = frequency;
    }

    public Request generateRequest(int requestId, int tactId) {
        requestId++;
        return new Request(requestId, tactId);

    }
}
