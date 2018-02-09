package simulator.control;
import java.util.*;

import simulator.control.interfaces.ISourceManager;
import simulator.model.Source;
import simulator.model.Source.SourceEnum;

public class SourceManager implements ISourceManager {
	private ArrayList<Source> sourceProfiles;
    private SimulatorProxy proxy;
	
	public SourceManager(SimulatorProxy si) {
		sourceProfiles = new ArrayList<>();
		this.proxy = si;
	}
	
	public void registerProfile(Source profile) {
		if (sourceProfiles != null) {
			sourceProfiles.add(profile);
		}
	}
	public void deleteProfile(int index) {
		if (sourceProfiles != null && !sourceProfiles.isEmpty()) {
			sourceProfiles.remove(index);
		}
	}
	public void modifyProfile(int index, Source profile) {
		if (sourceProfiles != null && !sourceProfiles.isEmpty()) {
			sourceProfiles.set(index, profile);
		}
	}
	public Source retrieveProfile(int index) {
		Source source = null;
		if (sourceProfiles != null && !sourceProfiles.isEmpty()) {
			source = sourceProfiles.get(index);
		}
		return source;
	}

	@Override
	public void registerProfile(int rangeFreq, int regularity, int priority, int valueRange, int valueAvgFreq, int valueType) {
		SourceEnum convertedSourceType = Source.convertIntegerToSourceEnum(valueType);
		Source source = new Source(rangeFreq, regularity, priority, valueRange, valueAvgFreq, convertedSourceType);
		registerProfile(source);
	}

	@Override
	public List<Source> getSourceProfiles() {
		return sourceProfiles;
	}

	class GenerateEventSourceRunnable implements Runnable {
        private Source profile;

        public GenerateEventSourceRunnable(Source profile) {
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

        public Source getProfile() {
            return profile;
        }
    }
}