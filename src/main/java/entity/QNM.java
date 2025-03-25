package entity;

import utils.ModelParameters;

public class QNM {
    private RequestGenerator requestGenerator;
    private RequestQueue requestQueue;
    private RequestHandler[] requestHandlers;
    private ModelParameters modelParameters;

    private int tactId = 1;
    private int requestId = 1;

    QNM(ModelParameters parameters) {
        this.modelParameters = parameters;
        initModel();
    }

    public void runModel() {
        for (int i=1; i<=modelParameters.getSimulationTime(); i++) {

        }
    }

    private void handleTact(int tactId) {
        if (tactId % 2 == 1) {
            if (requestQueue.requestQueueIsFree()) {
                Request request = requestGenerator.generateRequest(requestId, tactId);
                System.out.println("Request #" + request.getId());
            } else {
                tactId++;
            }
        }
        for (RequestHandler requestHandler : requestHandlers) {
            if (!requestHandler.isBusy()) {
                requestHandler.processRequest();
            }
        }
        this.tactId = tactId;
    }

    private void initModel() {
        requestGenerator = new RequestGenerator(modelParameters.getRequestFrequency());
        requestQueue = new RequestQueue(modelParameters.getQueueSize());
        requestHandlers = initHandlers();
    }

    private RequestHandler[] initHandlers() {
        requestHandlers = new RequestHandler[modelParameters.getNumberOfHandlers()];
        for (int i=0; i<modelParameters.getNumberOfHandlers(); i++) {
            requestHandlers[i] = new RequestHandler(modelParameters.getProbability()[i]);
        }
        return requestHandlers;
    }

    private void checkHandlers() {
        for (int i=0; i<modelParameters.getNumberOfHandlers(); i++) {
            if (!requestHandlers[i].isBusy()) {

            }
        }
    }
}
