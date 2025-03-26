package entity;

import java.util.Random;

public class RequestHandler {

    private int handlerId;
    private Request currentRequest;
    private byte noHandleProbability;

    RequestHandler(byte handleProbability) {
        this.noHandleProbability = handleProbability;
    }

    public void processRequest() {
        if (currentRequest == null) {
            return;
        }
        if (new Random().nextInt(100) > noHandleProbability) {
            System.out.println("Request # " + currentRequest.getId()
                    + " processed in handler # " + handlerId + " at "
                    + QNM.getTactId() + " tact");
            currentRequest = null;
        } else {
            System.out.println("Request # " + currentRequest.getId()
                    + " not processed in handler # "  + handlerId + " at "
                    + QNM.getTactId()+ " tact");
        }
    }

    public Request getCurrentRequest() {
        return currentRequest;
    }

    public void setCurrentRequest(Request currentRequest) {
        this.currentRequest = currentRequest;
    }

    public int getHandlerId() {
        return handlerId;
    }

    public void setHandlerId(int handlerId) {
        this.handlerId = handlerId;
    }

}
