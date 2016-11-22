package task6;
import java.util.*;

public class PaintRequirementWizard {
	
	List<Paint> paints = new ArrayList<Paint>();

	public static void main(String[] args) {
		PaintRequirementWizard prw = new PaintRequirementWizard();
		
		prw.newPaint(20, 19.99, 10, "CheapoMax");
		prw.newPaint(15, 17.99, 11, "AverageJoes");
		prw.newPaint(10,25.00, 20, "DuluxourousPaints");
		
		prw.calculateMSQR();
		System.out.println();
		prw.leftOvers(500);
	}
	
	public void calculateMSQR(){
		for(Paint p : paints){
			System.out.println(p.name + ": £" + String.format("%.2f", p.calculate()) + " per msqr");
		}
	}
	
	public void calculate(){
	
	}
	
	public void leftOvers(double room){
		for(Paint p : paints){
			double left = room;
			if(left == 0){
				System.out.println(p.name + "cost = £" + p.cost);
			} else if(left > 0){
				double total;
				double tins;
	
				total = p.cost* Math.ceil((left/(p.cover * p.litre)));
				tins = Math.ceil((left/(p.cover * p.litre)));
				
				System.out.println(p.name + ": cost = £" + total + " ("+tins+" tins)");
				double overallCoverage = tins * (p.cover*p.litre);
				System.out.println("Waste £"+(overallCoverage - room)*(p.cost/(p.litre*p.cover)));
				System.out.println(total - (overallCoverage - room)*(p.cost/(p.litre*p.cover)));
				System.out.println();
				//System.out.println(p.name + " waste : " + overallCoverage - room);
				
			}
		}
	}
	
	public void newPaint(double lt, double ct, double cr, String name){
		Paint paint = new Paint(lt,ct,cr,name);
		paints.add(paint);
	}

}
