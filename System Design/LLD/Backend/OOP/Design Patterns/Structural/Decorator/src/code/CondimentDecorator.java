package code;

// We have inherited the Beverage class just for the purpose of type-matching.
public abstract class CondimentDecorator extends Beverage {
	
	Beverage beverage;
	public abstract String getDescription(); // not the one present in Beverage abstract class.

}
