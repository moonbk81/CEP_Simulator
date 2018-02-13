package simulator.control;

import simulator.model.*;

public class AdatperFactory extends AbstractAdapterFactory {
    public Adapter createAdapter(int type) {
        switch (type) {
            case EventProfile.EVENT_ID_FIRE_EVENT:
                return new FireAdapter();
            case EventProfile.EVENT_ID_WINDOWN_EVENT:
                return new WindowAdapter();
            case EventProfile.EVENT_ID_MOVE_EVENT:
                return new MoveAdapter();
            case EventProfile.EVENT_ID_GAS_EVENT:
                return new GasAdapter();
            case EventProfile.EVENT_ID_USER_EVENT:
                return new UserAdapter();
            case EventProfile.EVENT_ID_EXTERNAL_EVENT:
                return new ExternalAdapter();
            default:
                break;
        }
        return null;
    }
}
