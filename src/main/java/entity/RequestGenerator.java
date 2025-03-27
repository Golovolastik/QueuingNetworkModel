package entity;

public class RequestGenerator {

    RequestGenerator() {
    }

    public Request generateRequest(int requestId, int tactId) {
        //System.out.println("Generating request # " + requestId + " at tact # " + tactId);
        return new Request(requestId);

    }
}
