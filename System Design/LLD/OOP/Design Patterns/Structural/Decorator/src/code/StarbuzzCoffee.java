package code;

public class StarbuzzCoffee {

	public static void main(String[] args) {
		
		Beverage beverage1 = new Expresso();
		System.out.println(beverage1.getDescription() + " $" + beverage1.cost());
		
		// Decorating Expresso with Mocha
		beverage1 = new Mocha(beverage1);
		System.out.println(beverage1.getDescription() + " $" + beverage1.cost());
		
		Beverage beverage2 = new HouseBlend();
		System.out.println(beverage2.getDescription() + " $" + beverage2.cost());
		
		// Decorating HouseBlend with Mocha
		beverage2 = new Mocha(beverage2);
		System.out.println(beverage2.getDescription() + " $" + beverage2.cost());
		
		

	}

}
