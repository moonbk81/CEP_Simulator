package simulator.control;

import simulator.control.adapter.Adapter;
import simulator.model.SourceProfile;

public abstract class AbstractAdapterFactory {
    protected int eventType;
    abstract public Adapter createAdapter(SourceProfile.SourceEnum type);
}
