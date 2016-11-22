package task5;

public class Car extends Vehicle {	
	
	public Car(String id, String colour){
		this.id = id;
		this.colour = colour;
		numberOfWheels = 4;
		costPerWheel = 100;
	}
	
	public int FixVehicle(){
		return (costPerWheel * numberOfWheels)+40;
	}
}
