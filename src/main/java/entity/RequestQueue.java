package entity;

import java.util.ArrayList;

public class RequestQueue {
    private int size;
    private boolean isFree = true;
    private ArrayList<Request> requests;

    RequestQueue(int size) {
        this.size = size;
    }

    public void storeRequest(Request request) {

    }

    public boolean requestHandlerIsBusy(RequestHandler handler) {
        return handler.isBusy();
    }

    public boolean requestQueueIsFree() {
        return isFree;
    }

    public boolean addRequest(Request request) {
        if (isFree) {
            requests.add(request);
            return true;
        }
        return false;
    }
}
