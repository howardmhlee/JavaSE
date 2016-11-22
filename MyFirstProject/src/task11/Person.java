package task11;
import java.util.*;

public class Person {
	
	String name;
	String uniqueID;
	ArrayList<Item> borrowed = new ArrayList<Item>();
	
	public Person(String name){
		this.name = name;
	}
	
	public void borrowItem(Item item){
		borrowed.add(item);
	}
	
	public void returnItem(Item item){
		borrowed.remove(item);
	}

}
