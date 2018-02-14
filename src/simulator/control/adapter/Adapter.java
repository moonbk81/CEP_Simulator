package simulator.control.adapter;

public abstract class Adapter {
    protected int complexity;
    protected int consumption;

    public Adapter() {}

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

    public void setAdapterData() {
        // Random

    }
}
