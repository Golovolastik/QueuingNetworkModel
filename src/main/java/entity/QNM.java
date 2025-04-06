package entity;

import stats.StatCollector;
import utils.ModelParameters;

import java.util.Queue;

public class QNM {
    private RequestGenerator requestGenerator;
    private RequestQueue requestQueue;
    private RequestHandler[] requestHandlers;
    private ModelParameters modelParameters;
    private StatCollector statCollector;

    private static int tactId = 1;
    private int requestId = 1;

    public QNM(ModelParameters parameters) {
        this.modelParameters = parameters;
        initModel();
    }

    public void runModel() {
        int timeToNextRequest = modelParameters.getRequestFrequency();
        for (int i=1; i<=modelParameters.getSimulationTime(); i++) {

            tactId = i;
            processRequests();



            moveFromQueue();



            timeToNextRequest = handleRequestGeneration(timeToNextRequest);


            statCollector.increaseQueueSize(requestQueue.getRequests().size());
        }
        statCollector.setNumberOfTacts(tactId);
        statCollector.printStatistics();
    }

    private void processRequests() {
        for (RequestHandler requestHandler : requestHandlers) {
            if (requestHandler.getCurrentRequest() != null) {
                if (requestHandler.processRequest()){
                    statCollector.increaseProcessedRequestCount();
                }
            }
        }
    }

    private void moveFromQueue() {
        Queue<Request> queue = requestQueue.getRequests();
        for (RequestHandler requestHandler : requestHandlers) {
            if (queue.isEmpty()) {
                return;
            }
            if (requestHandler.getCurrentRequest() == null) {
                requestHandler.setCurrentRequest(queue.poll());
            }
        }
    }

    private int handleRequestGeneration(int timeToNextRequest) {
        if (timeToNextRequest == 0 && requestQueue.requestQueueIsFree()) {
            Request request =  requestGenerator.generateRequest(requestId++, tactId);
            for (RequestHandler requestHandler : requestHandlers) {
                if (requestHandler.getCurrentRequest() == null) {
                    requestHandler.setCurrentRequest(request);
                    timeToNextRequest = modelParameters.getRequestFrequency() - 1;
                    return timeToNextRequest;
                }
            }
            requestQueue.addRequest(request);
            timeToNextRequest = modelParameters.getRequestFrequency() - 1;
            return timeToNextRequest;
        } else if (timeToNextRequest == 0 && !requestQueue.requestQueueIsFree()) {
            statCollector.addBlockedTact();
            return timeToNextRequest;
        } else if (timeToNextRequest > 0) {
            --timeToNextRequest;
        }
        return timeToNextRequest;
    }


    private void initModel() {
        this.requestGenerator = new RequestGenerator();
        this.requestQueue = new RequestQueue(modelParameters.getQueueSize());
        this.requestHandlers = initHandlers();
        this.statCollector = new StatCollector();
    }

    private RequestHandler[] initHandlers() {
        requestHandlers = new RequestHandler[modelParameters.getNumberOfHandlers()];
        for (int i=0; i<modelParameters.getNumberOfHandlers(); i++) {
            requestHandlers[i] = new RequestHandler(modelParameters.getProbability()[i]);
            requestHandlers[i].setHandlerId(i+1);
        }
        return requestHandlers;
    }

    public static int getTactId() {
        return tactId;
    }
}
