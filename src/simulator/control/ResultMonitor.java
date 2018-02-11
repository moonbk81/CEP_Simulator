package simulator.control;

import simulator.control.interfaces.IMonitor;
import simulator.model.ArchitectureDescription;
import simulator.model.SimulationResult;
import simulator.model.SystemProfile;

public class ResultMonitor implements IMonitor {
    private final int RESULT_LEVEL1         = 1;
    private final int RESULT_LEVEL2         = 2;
    private final int RESULT_LEVEL_ALL      = 3;
    private int level = 0;

    private int eventId;
    private int complexity;
    private int consumption;
    private ArchitectureDescription ad;
    private SystemProfile profile;

    public ResultMonitor() {
        System.out.println("ResultMonitor");
    }

    @Override
    public void update(int eventId, int complexity, int consumption, ArchitectureDescription ad, SystemProfile profile) {
        this.eventId = eventId;
        this.complexity = complexity;
        this.consumption = consumption;
        this.ad = ad;
        this.profile = profile;
        System.out.println("update eventId: " + this.eventId + "complexity: " + this.complexity +
                            "consumption: " + this.consumption);
    }

    @Override
    public SimulationResult consistResultByVisualLevel() {
        ResultBuilder resultBuilder = new ResultBuilder();

        switch (getLevel()) {
            case RESULT_LEVEL1:
                return resultBuilder
                        .setArchitectureDescription(ad)
                        .setSystemProfile(profile)
                        .build();
            case RESULT_LEVEL2:
                return resultBuilder
                        .setTotalComplexity(complexity)
                        .setTotalMemoryConsumption(consumption)
                        .build();
            case RESULT_LEVEL_ALL:
                return resultBuilder
                        .setArchitectureDescription(ad)
                        .setSystemProfile(profile)
                        .setTotalComplexity(complexity)
                        .setTotalMemoryConsumption(consumption)
                        .build();
            default:
                return resultBuilder.build();
        }
    }

    @Override
    public SimulationResult consistResultByUserPreference() {
        return null;
    }

    @Override
    public void setResultLevel(int level) {
        this.level = level;
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

    public ArchitectureDescription getAd() {
        return ad;
    }

    public void setAd(ArchitectureDescription ad) {
        this.ad = ad;
    }

    public SystemProfile getProfile() {
        return profile;
    }

    public void setProfile(SystemProfile profile) {
        this.profile = profile;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
