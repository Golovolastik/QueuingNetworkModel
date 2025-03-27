package stats;

public class StatCollector {
    private int numberOfTacts = 0;
    private int processedRequestCount = 0;
    private int queueSize = 0;
    private int blockedTacts = 0;

    public StatCollector() {

    }

    public void increaseQueueSize(int queueSize) {
        this.queueSize += queueSize;
    }

    public void printStatistics() {
        System.out.println("P_отк - вероятность отказа  = 0");
        System.out.println("Р_бл - вероятность блокировки = " + calculateBlockingProbability());
        System.out.println("L_оч - средняя длина очереди = " + calculateMeanQueueSize());
        System.out.println("Q - относительная пропускная способность = 1;");
        System.out.println("A - абсолютная пропускная способность = " + calculateAbsoluteThroughput());
    }

    public void setNumberOfTacts(int numberOfTacts) {
        this.numberOfTacts = numberOfTacts;
    }

    public void addBlockedTact() {
        this.blockedTacts++;
    }

    public void increaseProcessedRequestCount() {
        this.processedRequestCount++;
    }

    private double calculateBlockingProbability() {
        return (double) blockedTacts / (double) numberOfTacts;
    }

    private double calculateMeanQueueSize() {
        return (double) queueSize / (double) numberOfTacts;
    }

    private double calculateAbsoluteThroughput() {
        return (double) processedRequestCount / (double) numberOfTacts;
    }
}
