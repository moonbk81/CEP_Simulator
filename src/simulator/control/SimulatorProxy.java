package simulator.control;
import simulator.control.interfaces.*;
import simulator.model.*;

import java.util.List;

import static simulator.model.Event.EVENT_ID_FIRE_EVENT;
import static simulator.model.Event.EVENT_ID_USER_EVENT;
import static simulator.model.Event.EVENT_ID_WINDOWN_EVENT;
import static simulator.model.Source.SourceEnum.SOURCE_TYPE_FIRE_ALARM;
import static simulator.model.Source.SourceEnum.SOURCE_TYPE_USER;
import static simulator.model.Source.SourceEnum.SOURCE_TYPE_WINDOW_ALARM;


public class SimulatorProxy {
	IAdministrationManager adminManager = null;
	ISystemManager systemManager = null;
	IUserManager userManager = null;
	ISourceManager sourceManager = null;
	IAdapterManager adapterManager = null;
	IEventManager eventManager = null;
	IServiceManager serviceManager = null;
	IComponentManager componentManager = null;
	ISimulationManager simulationManager = null;
	IExecutionManager executionManager = null;
	IQualityManager qualityManager = null;

	public SimulatorProxy() {
		initSimulator(this);
	}

	private void initSimulator(SimulatorProxy si) {
		adminManager = new AdministrationManager(si);
		systemManager = new SystemManager(si);
		userManager = new UserManager(si);
		sourceManager = new SourceManager(si);
		adapterManager = new AdapterManager(si);
		eventManager = new EventManager(si);
		serviceManager = new ServiceManager(si);
		componentManager = new ComponentManager(si);
		simulationManager = new SimulationManager(si);
		executionManager = new ExecutionManager(si);
		qualityManager = new QualityManager(si);
		System.out.println("initSimulator");
	}
	
	public ISimulationManager getSimulationManager() {
		return simulationManager;
	}

	public IExecutionManager getExecutionManager() {
		return executionManager;
	}

	public IQualityManager getQualityManager() {
		return qualityManager;
	}

	public IAdministrationManager getAdminManager() {
		return adminManager;
	}


	public ISystemManager getSystemManager() {
		return systemManager;
	}


	public IUserManager getUserManager() {
		return userManager;
	}


	public ISourceManager getSourceManager() {
		return sourceManager;
	}


	public IAdapterManager getAdapterManager() {
		return adapterManager;
	}


	public IEventManager getEventManager() {
		return eventManager;
	}


	public IServiceManager getServiceManager() {
		return serviceManager;
	}


	public IComponentManager getComponentManager() {
		return componentManager;
	}

	public void signOn(String id, String name, String email, String number, String pwd) {
		adminManager.signOn(id, name, email, number, pwd);
	}

	public boolean logIn(String id, String pwd) {
		return adminManager.logIn(id, pwd);
	}

	public void logOut() {
		adminManager.logOut();
	}

	public void chooseAd() {
		// TODO Auto-generated method stub
		
	}

	public void chooseSystemProfile() {
		// TODO Auto-generated method stub
		
	}

	public void startSimulation() {
		// TODO Auto-generated method stub
		
	}

	public void registerSystemProfile(String name, int id, int core, int maxCapa) {
		systemManager.registerProfile(name, id, core, maxCapa);
	}

	public void registerSourceProfile(int rangeFreq, int regularity, int priority, int valueRange, int valueAvgFreq, int valueType) {
		sourceManager.registerProfile(rangeFreq, regularity, priority, valueRange, valueAvgFreq, valueType);
	}

    public void generateSampleData() {
        UserProfile profile = new UserProfile("moonbk81", "bongki", "bongki81@gmail.com", "010-7260-8683", "1234");
        userManager.registerProfile(profile);
        profile = new UserProfile("mooncw12", "chaewon", "chaewon12@gmail.com", "010-5166-4725", "1234");
        userManager.registerProfile(profile);

        // generate system profile
        SystemProfile sysProfile = new SystemProfile("Fire Alarm System", 1, 4, 8192, 1);
        systemManager.registerProfile(sysProfile);
        sysProfile = new SystemProfile("Window Alarm System", 2, 4, 4096, 1);
        systemManager.registerProfile(sysProfile);
        sysProfile = new SystemProfile("User Alarm System", 3, 4, 4096, 1);
        systemManager.registerProfile(sysProfile);

        // generate source profiles
        Source srcProfile = new Source(10, 1, 5, 30, 10, SOURCE_TYPE_FIRE_ALARM);
        sourceManager.registerProfile(srcProfile);
        srcProfile = new Source(20, 1, 5, 100, 10, SOURCE_TYPE_WINDOW_ALARM);
        sourceManager.registerProfile(srcProfile);
        srcProfile = new Source(15, 0, 9, 100, 10, SOURCE_TYPE_USER);
        sourceManager.registerProfile(srcProfile);

        // generate adapter profiles
        Adapter adapterProfile = new Adapter(SOURCE_TYPE_FIRE_ALARM, 150, 256);
        adapterManager.registerProfile(adapterProfile);
        adapterProfile = new Adapter(SOURCE_TYPE_WINDOW_ALARM, 120, 128);
        adapterManager.registerProfile(adapterProfile);
        adapterProfile = new Adapter(SOURCE_TYPE_USER, 180, 512);
        adapterManager.registerProfile(adapterProfile);

        // generate event profiles
        Event eventProfile = new Event(EVENT_ID_FIRE_EVENT, false);
        eventManager.registerProfile(eventProfile);
        eventProfile = new Event(EVENT_ID_WINDOWN_EVENT, false);
        eventManager.registerProfile(eventProfile);
        eventProfile = new Event(EVENT_ID_USER_EVENT, false);
        eventManager.registerProfile(eventProfile);

        // generate component profiles
        IComponentAction componentAction = new SendTextAlertComponent(
                new MakeEmergencyCallComponent(
                        new SingleComponent()));

        Component component = new Component(120, 10, 10, 200, componentAction);
        componentManager.registerProfile(component);

        componentAction = new SendTextAlertComponent(
                new MakeEmergencyCallComponent(
                        new AlarmAlertComponent(
                                new SingleComponent())));
        component = new Component(100, 20, 10, 180, componentAction);
        componentManager.registerProfile(component);

        componentAction = new AlarmAlertComponent(
                new SingleComponent());
        component = new Component(50, 10, 15, 150, componentAction);
        componentManager.registerProfile(component);

        // generate service profiles
        Service service = new Service();
        service.setEventId(EVENT_ID_FIRE_EVENT);
        service.addComponent(componentManager.retrieveProfile(0));
        service.addComponent(componentManager.retrieveProfile(2));
        serviceManager.registerProfile(service);

        service = new Service();
        service.setEventId(EVENT_ID_WINDOWN_EVENT);
        service.addComponent(componentManager.retrieveProfile(1));
        service.addComponent(componentManager.retrieveProfile(2));
		serviceManager.registerProfile(service);

        service = new Service();
        service.setEventId(EVENT_ID_USER_EVENT);
        service.addComponent(componentManager.retrieveProfile(0));
        service.addComponent(componentManager.retrieveProfile(1));
        service.addComponent(componentManager.retrieveProfile(2));
		serviceManager.registerProfile(service);
    }
}