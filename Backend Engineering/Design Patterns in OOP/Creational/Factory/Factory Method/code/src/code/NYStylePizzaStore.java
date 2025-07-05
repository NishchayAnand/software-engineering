package code;

public class NYStylePizzaStore extends PizzaStore {

	@Override
	protected Pizza createPizza() {
		return new NYStyleCheesePizza();
	}

}
