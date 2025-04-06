package entity;

public class RequestGenerator {

    RequestGenerator() {
    }

    public Request generateRequest(int requestId, int tactId) {
        return new Request(requestId);

    }
}
