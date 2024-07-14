package code;

public class SimplePizzaFactory {
	
	public static Pizza createPizza(String name) {
		Pizza pizza = null;
		if(name.equals("NY Style Sauce and Cheese Pizza")) {
			pizza = new NYStyleCheesePizza();
		} else if(name.equals("Chicago Style Deep Dish Cheese Pizza")) {
			pizza = new ChicagoStyleCheesePizza();
		}
		return pizza;
	}

}
