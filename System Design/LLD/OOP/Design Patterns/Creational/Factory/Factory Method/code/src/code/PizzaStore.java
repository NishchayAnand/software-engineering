package code;

public abstract class PizzaStore {
	
	public Pizza orderPizza() {
		Pizza pizza = createPizza();
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		return pizza;
	}
	
	protected abstract Pizza createPizza();

}
