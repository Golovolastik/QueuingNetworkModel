package app;

import entity.QNM;
import utils.ModelParameters;

public class Main {
    public static void main(String[] args) {
        byte[] noHandleProbability = {65, 75};
        ModelParameters parameters = new ModelParameters(2, 2, 2, noHandleProbability, 10);
        QNM qnm = new QNM(parameters);
        qnm.runModel();
    }
}
