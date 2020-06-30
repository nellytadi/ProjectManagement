package ng.whycode.pma.services;

public class Car {
	Engine e;
	Tire t;
	public Car(Engine e, Tire t) {
		this.e=e;
		this.t=t;
		
		System.out.println("A new car has been created");
	}

}
