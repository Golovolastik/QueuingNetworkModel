package entity;

public class Request {
    private int id;
    private int createTact;
    private int lifeTime = 1;

    Request(int id, int createTact) {
        this.id = id;
        this.createTact = createTact;
    }

    public int getId() {
        return id;
    }
    public int getCreateTact() {
        return createTact;
    }
    public int getLifeTime() {
        return lifeTime;
    }
}
