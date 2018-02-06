package simulator.model;


public class AlarmAlertComponent extends AbstractComponent {

	public AlarmAlertComponent(IComponentAction component) {
		super(component);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return " AlarmAlert " + action.getName();
	}
	
	
}
