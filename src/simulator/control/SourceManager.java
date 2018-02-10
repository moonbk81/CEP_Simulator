package simulator.control;
import java.util.*;

import simulator.control.interfaces.ISourceManager;
import simulator.model.SourceProfile;
import simulator.model.SourceProfile.SourceEnum;

public class SourceManager implements ISourceManager {
	private ArrayList<SourceProfile> sourceProfiles;
    private SimulatorProxy proxy;
	
	public SourceManager(SimulatorProxy si) {
		sourceProfiles = new ArrayList<>();
		this.proxy = si;
	}
	
	public void registerProfile(SourceProfile profile) {
		if (sourceProfiles != null) {
			sourceProfiles.add(profile);
		}
	}
	public void deleteProfile(int index) {
		if (sourceProfiles != null && !sourceProfiles.isEmpty()) {
			sourceProfiles.remove(index);
		}
	}
	public void modifyProfile(int index, SourceProfile profile) {
		if (sourceProfiles != null && !sourceProfiles.isEmpty()) {
			sourceProfiles.set(index, profile);
		}
	}
	public SourceProfile retrieveProfile(int index) {
		SourceProfile sourceProfile = null;
		if (sourceProfiles != null && !sourceProfiles.isEmpty()) {
			sourceProfile = sourceProfiles.get(index);
		}
		return sourceProfile;
	}

	@Override
	public void registerProfile(int rangeFreq, int regularity, int priority, int valueRange, int valueAvgFreq, int valueType) {
		SourceEnum convertedSourceType = SourceProfile.convertIntegerToSourceEnum(valueType);
		SourceProfile sourceProfile = new SourceProfile(rangeFreq, regularity, priority, valueRange, valueAvgFreq, convertedSourceType);
		registerProfile(sourceProfile);
	}

	@Override
	public List<SourceProfile> getSourceProfiles() {
		return sourceProfiles;
	}

	class GenerateEventSourceRunnable implements Runnable {
        private SourceProfile profile;

        public GenerateEventSourceRunnable(SourceProfile profile) {
            this.profile = profile;
        }

        @Override
        public void run() {
            try {
                // generate source after frequency
                Thread.sleep(getProfile().getRangeFrequency());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public SourceProfile getProfile() {
            return profile;
        }
    }
}