package entity;

import java.util.Random;

public class RequestHandler {

    private int handlerId;
    private Request currentRequest;
    private byte noHandleProbability;

    RequestHandler(byte handleProbability) {
        this.noHandleProbability = handleProbability;
    }

    public boolean processRequest() {
        if (currentRequest == null) {
            return false;
        }
        if (new Random().nextInt(100) >= noHandleProbability) {
//            System.out.println("Request # " + currentRequest.getId()
//                    + " processed in handler # " + handlerId + " at "
//                    + QNM.getTactId() + " tact");
            currentRequest = null;
            return true;
        } else {
//            System.out.println("Request # " + currentRequest.getId()
//                    + " not processed in handler # "  + handlerId + " at "
//                    + QNM.getTactId()+ " tact");
            return false;
        }
    }

    public Request getCurrentRequest() {
        return currentRequest;
    }

    public void setCurrentRequest(Request currentRequest) {
        this.currentRequest = currentRequest;
    }

    public void setHandlerId(int handlerId) {
        this.handlerId = handlerId;
    }

}
