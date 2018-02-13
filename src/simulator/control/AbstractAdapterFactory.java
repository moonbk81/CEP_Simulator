package simulator.control;

import simulator.model.Adapter;

public abstract class AbstractAdapterFactory {
    protected int eventType;
    abstract public Adapter createAdapter(int type);
}
