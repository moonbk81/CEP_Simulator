package simulator.control.interfaces;
import simulator.model.SourceProfile;

import java.util.List;

public interface ISourceManager {
	void deleteProfile(int index);
	void modifyProfile(int index, SourceProfile profile);
	SourceProfile retrieveProfile(int index);

    void registerProfile(int rangeFreq, int regularity, int priority, int valueRange, int valueAvgFreq, int valueType);

    List<SourceProfile> getSourceProfiles();

    void registerProfile(SourceProfile profile);
}