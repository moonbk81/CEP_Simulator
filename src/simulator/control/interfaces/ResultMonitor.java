package simulator.control.interfaces;

public class ResultMonitor implements IMonitor {
    private int eventId;
    private int complexity;
    private int consumption;

    @Override
    public void update(int eventId, int complexity, int consumption) {
        this.eventId = eventId;
        this.complexity = complexity;
        this.consumption = consumption;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public int getComplexity() {
        return complexity;
    }

    public void setComplexity(int complexity) {
        this.complexity = complexity;
    }

    public int getConsumption() {
        return consumption;
    }

    public void setConsumption(int consumption) {
        this.consumption = consumption;
    }
}
