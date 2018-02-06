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
}