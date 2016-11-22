package task1_4;
import java.util.Scanner;

public class Task {

	public static void main(String[] args) {
		//TaskOne();
		//TaskTwo();
		TaskThree("Hello");
		//TaskFour("Hello");
	}
	
	public static void TaskOne(){
		String star = "";
		for(int i = 0; i < 10; i++){
			System.out.println(star += "*");
		}
	}
	
	public static void TaskTwo(){
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		sc.close();
		String star = "";
		for(int i = 0; i < number; i++){
			System.out.println(star += "*");
		}
	}
	
	public static void TaskThree(String item){
		String reverse = "";
		char[] c = item.toCharArray();
		for(int i = c.length-1; i >= 0; i--){
			reverse += c[i]; 
		}
		System.out.println(reverse);
	}
	
	public static void TaskFour(String item){
		String reverse = "";
		for(int i = item.length()-1; i >= 0; i--){
			reverse += item.charAt(i);
		}
		System.out.println(reverse);
	}
}
