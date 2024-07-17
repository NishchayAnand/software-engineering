
public class TurkeyAdapter implements Duck {
	
	Turkey turkey;
	
	public TurkeyAdapter(Turkey turkey) {
		this.turkey = turkey;
	}

	@Override
	public void quack() {
		turkey.gobble();
	}

	// Turkeys fly in short spurs. To map between Duck's fly() method and Turkey's fly() method, we are
	// calling the Turkey's fly() method five times to make up for it. 
	@Override
	public void fly() {
		for(int i=0; i<5; i++) {
			turkey.fly();
		}
	}
	
}
