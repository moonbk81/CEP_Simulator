import simulator.control.SimulatorProxy;
import simulator.model.*;
import simulator.view.SimulatorCmdUI;

import static simulator.model.Source.*;

public class Simulator {
	public static void main(String[] args) {

		SimulatorProxy proxy = new SimulatorProxy();
        SimulatorCmdUI ui = new SimulatorCmdUI(proxy);
        ui.start();
		/*
		proxy.signOn();
		// log in

		if (proxy.logIn("lovejane", "12345")) {

			System.out.println("Success to log in");
			System.out.println("Register system profile");
			////////////////
			proxy.registerProfile(new SystemProfile("moon", 1, 4, 8192, 1));
			proxy.registerProfile(new SystemProfile("chaewon", 2, 4, 4096, 1));
			////////////////
			////////////////
			System.out.println("Register event source profile");
			Source sourceFire = new Source(10, 1, 5, 4, 4, SourceEnum.SOURCE_TYPE_FIRE_ALARM);
			proxy.registerProfile(sourceFire);

			Adapter adapterFire = new Adapter(0, 10, 256);
			proxy.registerProfile(adapterFire);
			System.out.println("Register component profile");
			/////////////////
			/// Assume user input below component's combination as component A for Event A
			IComponentAction componentActionA = new SendTextAlertComponent(
												new MakeEmergencyCallComponent(
												new SingleComponent())); 
			System.out.println("component action name: " + componentActionA.getName());
			IComponentAction componentActionB = new SendTextAlertComponent(
												new MakeEmergencyCallComponent(
												new AlarmAlertComponent(
												new SingleComponent()))); 
			System.out.println("component action name: " + componentActionB.getName());
			
			Component componentA = new Component(20, 10, 10, 5000, componentActionA);
			Component componentB = new Component(20, 20, 10, 4000, componentActionB);
			proxy.registerProfile(componentA);
			proxy.registerProfile(componentB);
			////////////////
			System.out.println("Register service profile");
			/////////////////
			Service serviceA = new Service();
			serviceA.setEventId(100);
			serviceA.addComponent(componentA);
			proxy.registerProfile(serviceA);
			
			proxy.chooseAd();
			proxy.chooseSystemProfile();
			proxy.startSimulation();
		} else {

		}
		*/
	}
}
