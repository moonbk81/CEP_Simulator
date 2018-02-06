package simulator.model;


public abstract class AbstractComponent implements IComponentAction {
	protected  IComponentAction action;
	public AbstractComponent(IComponentAction action) {
		this.action = action;
	}
	
	public abstract String getName();
}
