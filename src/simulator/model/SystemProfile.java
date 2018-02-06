package simulator.model;

import java.util.*;

public class SystemProfile {
	private String name;
	private int id;
	private int coreNums;
	private int maxMemoryCapa;
	private int processor;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

    public SystemProfile() {
    	name = "";
    	id = -1;
    }

	public SystemProfile(String name, int id, int coreNums, int maxMemoryCapa, int processor) {
		this.name = name;
		this.id = id;
		this.coreNums = coreNums;
		this.maxMemoryCapa = maxMemoryCapa;
		this.processor = processor;
	}

	public SystemProfile(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}

	public int getCoreNums() {
		return coreNums;
	}

	public void setCoreNums(int coreNums) {
		this.coreNums = coreNums;
	}

	public int getMaxMemoryCapa() {
		return maxMemoryCapa;
	}

	public void setMaxMemoryCapa(int maxMemoryCapa) {
		this.maxMemoryCapa = maxMemoryCapa;
	}
}