package entity;

import java.util.LinkedList;
import java.util.Queue;

public class RequestQueue {
    private int size;
    private boolean isFree = true;
    private Queue<Request> requests = new LinkedList<>();

    public Queue<Request> getRequests() {
        return requests;
    }

    RequestQueue(int size) {
        this.size = size;
    }

    public void storeRequest(Request request) {

    }

    public boolean requestQueueIsFree() {
        isFree = requests.size() < size;
        return isFree;
    }

    public void addRequest(Request request) {
        if (isFree) {
            requests.add(request);
        }
        if (requests.size() >= size) {
            isFree = false;
        }
    }
}
