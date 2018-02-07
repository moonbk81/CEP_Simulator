package simulator.model;

import java.util.*;

/**
 * 
 */
public class ArchitectureDescription {
	private Source source;
	private Adapter adapter;
	private Event event;
	private Service service;
	private Component component;
	private int AD_ID;
	

	/**
     * Default constructor
     */
    public ArchitectureDescription() {
    }

	public ArchitectureDescription(Source source, Adapter adapter, Event event,
			Service service, Component component) {
		super();
		this.source = source;
		this.adapter = adapter;
		this.event = event;
		this.service = service;
		this.component = component;
	}

	public Source getSource() {
		return source;
	}

	public void setSource(Source source) {
		this.source = source;
	}

	public Adapter getAdapter() {
		return adapter;
	}

	public void setAdapter(Adapter adapter) {
		this.adapter = adapter;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public Component getComponent() {
		return component;
	}

	public void setComponent(Component component) {
		this.component = component;
	}
}