package entity;

import java.util.Random;

public class RequestHandler {
    private Request currentRequest;
    private boolean isBusy = false;
    private byte noHandleProbability;

    RequestHandler(byte handleProbability) {
        this.noHandleProbability = handleProbability;
    }

    public void processRequest() {
        if (new Random().nextInt(noHandleProbability) < noHandleProbability) {
            isBusy = true;
        } else {
            isBusy = false;
            System.out.println("Request # " + currentRequest.getId() + " processed.");
            currentRequest = null;
        }
    }

    public boolean isBusy() {
        return isBusy;
    }
    private void setBusy() {
        isBusy = true;
    }

    public void setCurrentRequest(Request currentRequest) {
        this.currentRequest = currentRequest;
    }
}
