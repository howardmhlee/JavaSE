package task9_10;

public class Task {

	static String string = "";
	public static void main(String[] args) {
		System.out.println(lcs("Tomato","Toronto"));
		System.out.println(string);
	}
	
	public static int lcs(String first, String second){
		if(first.length()==0||second.length()==0){
			return 0;
		}
		int fl = first.length();
		int sl = second.length();
		
		//if the last letters of both strings are equal, return add 1 to result, move up by one and do this again until it does not matches
		if(first.charAt(fl-1) == second.charAt(sl-1)){
			return 1 + lcs(first.substring(0,fl-1), second.substring(0, sl-1));
			
			
		} else {
			//if the last letters of both don't match, return whichever is bigger as a result of the if statement
			return Math.max(
					lcs(first.substring(0,fl-1), second.substring(0, sl)), //
					lcs(first.substring(0,fl), second.substring(0,sl-1)));
		}
	}
	

}

/*
 *  String 1: Tom
 *  String 2: Torn
 * 	
 1; m != n
 	(Tom v Tor)	(To v Torn)
 		(m!=r)		(o!=n)
 	(To v Tor)(Tom v To)	(To v Tor)(T v Torn)
 	
 	eventually
 	To v To
 	
 	1 + (t v t) 
 	= 2
 	
 * 
 * 
 */
