package simulator.model;

/**
 * 
 */
public class ArchitectureDescription {
	private SourceProfile sourceProfile;
	private AdapterProfile adapterProfile;
	private EventProfile eventProfile;
	private ServiceProfile serviceProfile;
	private ComponentProfile component;
	private int AD_ID;
	

	/**
     * Default constructor
     */
    public ArchitectureDescription() {
    }

	public ArchitectureDescription(SourceProfile sourceProfile, AdapterProfile adapterProfile, EventProfile eventProfile,
								   ServiceProfile serviceProfile, ComponentProfile component) {
		super();
		this.sourceProfile = sourceProfile;
		this.adapterProfile = adapterProfile;
		this.eventProfile = eventProfile;
		this.serviceProfile = serviceProfile;
		this.component = component;
	}

	public SourceProfile getSourceProfile() {
		return sourceProfile;
	}

	public void setSourceProfile(SourceProfile sourceProfile) {
		this.sourceProfile = sourceProfile;
	}

	public AdapterProfile getAdapterProfile() {
		return adapterProfile;
	}

	public void setAdapterProfile(AdapterProfile adapterProfile) {
		this.adapterProfile = adapterProfile;
	}

	public EventProfile getEventProfile() {
		return eventProfile;
	}

	public void setEventProfile(EventProfile eventProfile) {
		this.eventProfile = eventProfile;
	}

	public ServiceProfile getServiceProfile() {
		return serviceProfile;
	}

	public void setServiceProfile(ServiceProfile serviceProfile) {
		this.serviceProfile = serviceProfile;
	}

	public ComponentProfile getComponent() {
		return component;
	}

	public void setComponent(ComponentProfile component) {
		this.component = component;
	}
}