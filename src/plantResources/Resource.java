package plantResources;


abstract class Resource {
	
	protected int value;

	Resource() {
		value = 0;
	}
	
	Resource(int value) {
		if (value < 0) {
			throw new NegativeResourceException("negative resource initialization");
		}
		this.value = value;
	}
	
	public void setValue(int value) {
		if (value < 0) {
			throw new NegativeResourceException("negative resource initialization");
		}
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	public void decValue() {
		if (value - 1 < 0) {
			throw new NegativeResourceException("negative resource decrement");
		}
		value --;
	}
	
	public void incValue() {
		value++;
	}
	
	public void incValue(int increment) {
		if (value + increment < 0) {
			throw new NegativeResourceException("negative resource increment");
		}
		value += increment;
	}
	
	public void decValue(int decrement) {
		if (value - decrement < 0) {
			throw new NegativeResourceException("negative resource decrement");
		}

		value -= decrement;
	}
	
	public void multiply(int multiplier) {
		if (multiplier < 0) {
			throw new NegativeResourceException("negative resource multiplier");
		}
		value*= multiplier;
	}
	
}
