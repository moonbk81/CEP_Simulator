package simulator.model;

public class Source extends Profile {
	public static enum SourceEnum {
        SOURCE_TYPE_FIRE_ALARM,
		SOURCE_TYPE_WINDOW_ALARM,
		SOURCE_TYPE_MOVE_ALARM,
		SOURCE_TYPE_GAS_ALARM,
        SOURCE_TYPE_USER,
        SOURCE_TYPE_EXTERNAL,
		SOURCE_TYPE_UNKNOWN
    }
	private int rangeFrequency;
	private int regularityOfFrequency;
	private int priority;
	private int valueAvgFreq;
	private int valueRange;
	private SourceEnum valueType;
	
    public Source() {
    }

	public Source(int rangeFrequency, int regularityOfFrequency,
			int priority, int valueAvgFreq, int valueRange,
			SourceEnum valueType) {
		super();
		this.rangeFrequency = rangeFrequency;
		this.regularityOfFrequency = regularityOfFrequency;
		this.priority = priority;
		this.valueAvgFreq = valueAvgFreq;
		this.valueRange = valueRange;
		this.valueType = valueType;
	}

	public int getRangeFrequency() {
		return rangeFrequency;
	}

	public void setRangeFrequency(int rangeFrequency) {
		this.rangeFrequency = rangeFrequency;
	}


	public int getRegularityOfFrequency() {
		return regularityOfFrequency;
	}

	public void setRegularityOfFrequency(int regularityOfFrequency) {
		this.regularityOfFrequency = regularityOfFrequency;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getValueAvgFreq() {
		return valueAvgFreq;
	}

	public void setValueAvgFreq(int valueAvgFreq) {
		this.valueAvgFreq = valueAvgFreq;
	}

	public int getValueRange() {
		return valueRange;
	}

	public void setValueRange(int valueRange) {
		this.valueRange = valueRange;
	}

	public SourceEnum getValueType() {
		return valueType;
	}

	public void setValueType(SourceEnum valueType) {
		this.valueType = valueType;
	}

	public static SourceEnum convertIntegerToSourceEnum(int type) {
    	switch (type) {
			case 0:
				return SourceEnum.SOURCE_TYPE_FIRE_ALARM;
			case 1:
				return SourceEnum.SOURCE_TYPE_WINDOW_ALARM;
			case 2:
				return SourceEnum.SOURCE_TYPE_MOVE_ALARM;
			case 3:
				return SourceEnum.SOURCE_TYPE_GAS_ALARM;
			case 4:
				return SourceEnum.SOURCE_TYPE_USER;
			case 5:
				return SourceEnum.SOURCE_TYPE_EXTERNAL;
			default:
				return SourceEnum.SOURCE_TYPE_UNKNOWN;
		}
	}
}