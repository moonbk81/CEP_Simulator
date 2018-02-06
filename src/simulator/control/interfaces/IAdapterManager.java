package simulator.control.interfaces;
import simulator.model.Adapter;

import java.util.List;

public interface IAdapterManager {
	void registerProfile(Adapter profile);
	void deleteProfile(int index);
	void modifyProfile(int index, Adapter profile);
	Adapter retrieveProfile(int index);

    List<Adapter> getAdapterProfiles();
}