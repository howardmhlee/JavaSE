package task6;

public class Paint {
	
	double litre;
	double cost;
	double cover;
	
	String name;
	
	public Paint(double lt, double ct, double cr, String name){
		
		litre = lt;
		cost = ct;
		cover = cr;
		
		this.name = name;
	}
	
	public double calculate(){		
				
		double overallCover = litre * cover;
		double costPerM2 = overallCover / cost;
		
		return costPerM2;
	}

}
