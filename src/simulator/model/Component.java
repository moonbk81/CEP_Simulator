package simulator.model;

import java.util.*;

public class Component extends Profile {
    private int complexity;
    private int complexityRange;
    private int memoryRange;
    private int memoryResource;
    private IComponentAction componentAction;
    
    public Component() {
    }
    // decorator pattern? builder pattern?

	public int getComplexity() {
		return complexity;
	}

	public Component(int complexity, int complexityRange, int memoryRange,
			int memoryResource, IComponentAction componentAction) {
		super();
		this.complexity = complexity;
		this.complexityRange = complexityRange;
		this.memoryRange = memoryRange;
		this.memoryResource = memoryResource;
		this.componentAction = componentAction;
	}
	public void setComplexity(int complexity) {
		this.complexity = complexity;
	}

	public int getComplexityRange() {
		return complexityRange;
	}

	public void setComplexityRange(int complexityRange) {
		this.complexityRange = complexityRange;
	}

	public int getMemoryRange() {
		return memoryRange;
	}

	public void setMemoryRange(int memoryRange) {
		this.memoryRange = memoryRange;
	}

	public int getMemoryResource() {
		return memoryResource;
	}

	public void setMemoryResource(int memoryResource) {
		this.memoryResource = memoryResource;
	}

	public void setComponent(IComponentAction action) {
		this.componentAction = action;
	}
	
	public IComponentAction getComponent() {
		return this.componentAction;
	}

}