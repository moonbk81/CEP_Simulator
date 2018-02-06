package simulator.model;


public class SendTextAlertComponent extends AbstractComponent {
	public SendTextAlertComponent(IComponentAction component) {
		super(component);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return " SendTextAlert " + action.getName();
	}

}
