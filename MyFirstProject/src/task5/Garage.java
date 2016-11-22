package task5;
import java.util.*;
public class Garage {
	List<Vehicle> vehicles = new ArrayList<Vehicle>();
	
	public static void main(String[] args) {
		Garage garage = new Garage();
		garage.AddVehicle(new Car("CR2","Orange"));
	}
	
	public Garage(){
		Vehicle one = new Car("CR1","Red");
		Vehicle two = new Bicycle("BC1","Blue");
		Vehicle three = new Bus("BS1","Yellow");
		Vehicle four = new Bicycle("BC2", "Pink");

		AddVehicle(one);
		AddVehicle(two);
		AddVehicle(three);
		AddVehicle(four);
		
		//RemoveVehicleByType("Car");
		for(Vehicle vc : vehicles){
			System.out.println(vc.id +": " + vc.colour);
		}
	}

	public void FixVehicles(){
		int total = 0;
		for(Vehicle vc : vehicles){
			total += vc.FixVehicle();
		}
		System.out.println("£"+total);
	}
	
	public void AddVehicle(Vehicle vc){
		vehicles.add(vc);
	}
	
	public void RemoveVehicleByID(String id){
		for(Vehicle vc : vehicles){
			if(vc.id.equals(id)){
				vehicles.remove(vc);
			}
		}
	}
	
	public void RemoveVehicleByType(String type){
		List<Vehicle> remove = new ArrayList<Vehicle>();
		switch (type){
		case "Bicycle":
			for(Vehicle vc : vehicles){
				if(vc instanceof Bicycle){
					remove.add(vc);		
				}
			}
			break;
		case "Bus":
			for(Vehicle vc : vehicles){
				if(vc instanceof Bus){
					remove.add(vc);
				}
			}
			break;
		case "Car":
			for(Vehicle vc : vehicles){
				if(vc instanceof Car){
					remove.add(vc);
				}
			}
			break;
		}	
		vehicles.removeAll(remove);
	}
	
	public void EmptyGarage(){
		vehicles.clear();
	}
}

