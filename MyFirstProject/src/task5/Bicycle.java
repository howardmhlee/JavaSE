package task5;

public class Bicycle extends Vehicle {	
	
	public Bicycle(String id, String colour){	
		this.id = id;
		this.colour = colour;
		numberOfWheels = 2;
		costPerWheel = 50;
	}
	
	public int FixVehicle(){
		return (costPerWheel * numberOfWheels)+20;
	}

}
