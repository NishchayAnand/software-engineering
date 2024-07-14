package code;

public class ChicagoStylePizzaStore extends PizzaStore {

	@Override
	protected Pizza createPizza() {
		return new ChicagoStyleCheesePizza();
	}

}
