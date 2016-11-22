package task5;

public class Bus extends Vehicle{
	
	public Bus(String id, String colour){
		this.id = id;
		this.colour = colour;
		numberOfWheels = 4;
		costPerWheel = 150;
	}

	public int FixVehicle(){
		return (costPerWheel * numberOfWheels)+60;
	}
}
