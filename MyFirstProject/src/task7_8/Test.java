package task7_8;

public class Test {
	
	private static final int MAX = 100;
	private static final int SQRT_MAX = (int) Math.sqrt(MAX) + 1;
	private static boolean[] array = new boolean[MAX];
	//--//

	public static void main(String[] args) {
		for (int x = 1; x < SQRT_MAX; x++) {
			  for (int y = 1; y < SQRT_MAX; y++) {
			    int k = 4 * x * x + y * y;
			    if ((k < MAX) && ((k % 12 == 1) || (k % 12 == 5))) {
			      array[k] = !array[k];
			    }
			    k = 3 * x * x + y * y;
			    if ((k < MAX) && (k % 12 == 7)) {
			      array[k] = !array[k];
			    }
			    if (x > y) {
			      k = 3 * x * x - y * y;
			      if ((k < MAX) && (k % 12 == 11)) {
			        array[k] = !array[k];
			      }
			    }
			  }
			}
			array[2] = true;
			array[3] = true;
			for (int n = 5; n <= SQRT_MAX; n++) {
			  if (array[n]) {
			    int n2 = n * n;
			    for (int k = n2; k < MAX; k += n2) {
			      array[k] = false;
			    }
			  }
			} 
			
			for (int i = 0, j = 0; i <= MAX; i++) {
		        if (array[i]) {
		            System.out.printf("%,8d", i);
		            if (++j % 10 == 0) {
		                System.out.println();
		            } // end if
		            if (j % 100 == 0) {
		                System.out.println();
		            } // end if
		        } // end if
		    } // end for
	}

}
