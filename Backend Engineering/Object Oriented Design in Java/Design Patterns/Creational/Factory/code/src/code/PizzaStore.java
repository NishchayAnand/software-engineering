package code;

public class PizzaStore {
	
	public Pizza orderPizza() {
		Pizza pizza = SimplePizzaFactory.createPizza("NY Style Sauce and Cheese Pizza");
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		return pizza;
	}

}
