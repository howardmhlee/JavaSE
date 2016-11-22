package task7_8;

import java.util.BitSet;
import java.util.concurrent.TimeUnit;


public class PrimeNumbers {
	
	static long startTime;
	static long endTime;
	static long duration;
	static double max = 1000000000.00;  //count is wrong at billion??
	static int maxsqrt = (int)Math.sqrt(max) + 1;
	//static boolean[] sieve = new boolean[(int) max];
	static BitSet bits = new BitSet((int) max);
	static int count=0;
	
	public PrimeNumbers(){
		startTime = System.nanoTime();
		//sieve[2] = true;
		//sieve[3] = true;
		bits.set(2);
		bits.set(3);
			
		for (int x = 1; x < maxsqrt; x++) {
			for (int y = 1; y < Math.sqrt(max); y++) {
				int k = 4 * x * x + y * y;
				if ((k < max) && ((k % 12 == 1) || (k % 12 == 5))) {
					//sieve[k] = !sieve[k];
					bits.flip(k);
			    }
				k = 3 * x * x + y * y;
			    if ((k < max) && (k % 12 == 7)) {
			    	//sieve[k] = !sieve[k];
			    	bits.flip(k);
			    }
			    if (x > y) {
			    	k = 3 * x * x - y * y;
			    	if ((k < max) && (k % 12 == 11)) {
			    		//sieve[k] = !sieve[k];
			    		bits.flip(k);
			    	}
			    }
			}
		}

		for (int n = 5; n <= maxsqrt; n+=2) {
			//if (sieve[n]) {
			if(bits.get(n)){
				int n2 = n * n;
				for (int k = n2; k < max; k += n2) {
					//sieve[k] = false;
					bits.set(k,false);
				}
			}
		}
		endTime = System.nanoTime();
		duration = (endTime - startTime);
		
		
		
	
	}
		

	public static void main(String[] args) {
		PrimeNumbers pn = new PrimeNumbers();
		/*
		for (int i = 0, j = 0; i < max; i++) {
	        if (sieve[i]) {
	            //System.out.printf("%,8d", i);
	        	System.out.println(i);
	            //if (++j % 10 == 0) {
	           //     System.out.println();
	           // } // end if
	            //if (i % 100 == 0) {
	            //    System.out.println();
	            //} // end if
	        } // end if
	    } // end for
	    
		*/
		/*
		for(int j=0;j<max;j++){
			if(sieve[j]){
				count++;
			}
		}
		
		for(int i=0;i<max;i++){
			if(sieve[i] && i>990000000){
				System.out.println(i);
			}
		}
		*/
		System.out.println(bits.cardinality());
		
		
		
		
		
		
		
		System.out.println();
		System.out.println();
		//System.out.println("count "+ count);
		
		
		
		
		System.out.println("["+TimeUnit.NANOSECONDS.toSeconds(duration)+"]");
	}
}
