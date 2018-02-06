package simulator.model;


public class MakeEmergencyCallComponent extends AbstractComponent {
	
	public MakeEmergencyCallComponent(IComponentAction component) {
		super(component);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return " EmergencyCall " + action.getName();
	}

}
