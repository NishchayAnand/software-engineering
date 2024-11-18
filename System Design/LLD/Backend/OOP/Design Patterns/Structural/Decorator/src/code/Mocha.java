package code;

public class Mocha extends CondimentDecorator {
	
	public Mocha(Beverage beverage) { // beverage represents the object that needs to be decorated. 
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ", Mocha";
	}

	@Override
	public double cost() {
		return beverage.cost() + 0.2;
	}

}
