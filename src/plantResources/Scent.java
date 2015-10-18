package plantResources;


public class Scent extends Resource {
	
	public Scent() {
		value = 0;
	}
	
	public Scent(int value) {
		if (value < 0) {
			throw new NegativeResourceException("negative resource initialization");
		}
		this.value = value;
	}
	
	public Scent(Water water, Soil soil, int transferAmount) {	
	//decrement water and soil by transferAmount and set to Scent's value
	//remember: Java passes references by value
		if (water == null)
			throw new NullPointerException("null water argument");
		if (soil == null)
			throw new NullPointerException("null soil argument");
		water.decValue(transferAmount);
		soil.decValue(transferAmount);
		
		incValue(transferAmount);
	}
	
	public void incValue(Water water, Soil soil, int transferAmount) {
		//decrement water and soil by transferAmount and add to Scent's value
		//remember: Java passes references by value
		water.decValue(transferAmount);
		soil.decValue(transferAmount);
		
		incValue(transferAmount);
	}
	
	public int useScent(int amount) { // returns amount for convenience
		if (value - amount < 0) {
			throw new NegativeResourceException("amount exceeds existing resource");
		}
		value -= amount;
		
		return amount;
	}
}
