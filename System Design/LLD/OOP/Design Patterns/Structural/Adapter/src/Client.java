
public class Client {
	
	public static void main(String args[]) {
		
		Turkey turkey = new WildTurkey();
		System.out.println("Turkey says...");
		turkey.gobble();
		
		// wrap the turkey object in a TurkeyAdapter which makes it look like a Duck. 
		Duck turkeyAdapter = new TurkeyAdapter(turkey);
		System.out.println("TurkeyAdapter says...");
		turkeyAdapter.quack();
		
	}

}
