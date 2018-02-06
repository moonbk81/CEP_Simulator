package simulator.model;

public class Event extends Profile {
    public static final int EVENT_ID_FIRE_EVENT     = 1;
    public static final int EVENT_ID_WINDOWN_EVENT  = 2;
    public static final int EVENT_ID_MOVE_EVENT     = 3;
    public static final int EVENT_ID_GAS_EVENT      = 4;
    public static final int EVENT_ID_USER_EVENT     = 5;
    public static final int EVENT_ID_EXTERNAL_EVENT = 6;

    private int eventId;
    private boolean eventCondition; // it will be decided by source value
    public Event() {
    }

    public Event(int eventId, boolean eventCondition) {
        this.eventId = eventId;
        this.eventCondition = eventCondition;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public boolean isEventCondition() {
        return eventCondition;
    }

    public void setEventCondition(boolean eventCondition) {
        this.eventCondition = eventCondition;
    }
}