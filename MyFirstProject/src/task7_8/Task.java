package task7_8;

public class Task {
	
	public static void main(String[] args) {		
		Task task = new Task();
		long startTime = System.nanoTime();
		
		double limit = 3000000.00;
		
		for(float i=2; i < limit; i++){
			task.isPrime(i);
			if(i>=3){
				i++;
			}
		}
		
		long endTime = System.nanoTime();
		
		long duration = (endTime - startTime);
		System.out.println("["+duration+"]");
	}
		
	public boolean isPrime(float number){
		if(number>5){
			if(number%2==0||number%3==0||number%5==0){
				return false;
			}	
		}
		
		for(float i = 2; i < Math.floor(Math.sqrt(number))+1; i++){
			if(number%i==0){
				return false;
			}
			if(i>=3){
				i++;
			}
		}
			
		//System.out.print(number + " ");
		return true;
	}

}
