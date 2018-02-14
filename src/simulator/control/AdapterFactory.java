package simulator.control;

import simulator.control.adapter.*;
import simulator.model.SourceProfile.SourceEnum;

public class AdapterFactory extends AbstractAdapterFactory {
    public Adapter createAdapter(SourceEnum type) {
        switch (type) {
            case SOURCE_TYPE_FIRE_ALARM:
                return new FireAdapter();
            case SOURCE_TYPE_WINDOW_ALARM:
                return new WindowAdapter();
            case SOURCE_TYPE_MOVE_ALARM:
                return new MoveAdapter();
            case SOURCE_TYPE_GAS_ALARM:
                return new GasAdapter();
            case SOURCE_TYPE_USER:
                return new UserAdapter();
            case SOURCE_TYPE_EXTERNAL:
                return new ExternalAdapter();
            default:
                break;
        }
        return null;
    }
}
