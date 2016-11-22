package task11;
import java.util.*;

public class Library {
	
	ArrayList<Item> items = new ArrayList<Item>();
	ArrayList<Person> people = new ArrayList<Person>();
	
	public static void main(String[] args) {
		Library library = new Library();
		
		Item item = new Book("BK1", "Book", "Science Fiction");
		library.addItem(item);
		
		item = new Magazine("MZ1", "Mag");
		library.addItem(item);
		
		item = new Journal("JN1", "Jou");
		library.addItem(item);
		
		library.addItem("BK1");
		
		Person person = new Person("Howard");
		library.registerPerson(person);
		person = new Person("Tom");
		library.registerPerson(person);
		person = new Person("Alex");
		library.registerPerson(person);
		person = new Person("Alex");
		library.registerPerson(person);
		
		//System.out.println(library.items.get(0).uniqueID);
		System.out.println();
		library.checkItem("BK1");
		System.out.println();
		//library.checkOut("BK1", "HOW1");
		System.out.println();
		library.checkItem("BK1");
		
		//library.checkOut("BK1", "ALE1");
		
		System.out.println();
		library.whoBorrowed("BK1");
		library.whoBorrowed("MZ1");
		
		

		
	}
	
	public void checkOut(String id, String pers){
		Person found = null;
		for(Person pe:people){
			if(pe.uniqueID.equals(pers)){
				//can borrow
				found = pe;
			}
		}
		if(found==null){
			System.out.println(pers + " is not a member.");
			return;
		} else {
			for(Item thing:items){
				if(thing.uniqueID.equals(id)){
					if(thing.available > 0){
						thing.available--;
						found.borrowItem(thing);
						System.out.println(found.name + " (" + found.uniqueID+") checked out " + id);
						return;
					} else {
						System.out.println("Check Out Failed: ID" + thing.uniqueID + " " + thing.title + " Copies: " + thing.available);
						return;
					}
				}
			}
			System.out.println("Check Out Failed: ID" + id + " not found.");
		}
		
	}
	
	public void checkIn(String id, Person pers){
		for(Item thing:items){
			if(thing.uniqueID.equals(id)){
				if(thing.copies < thing.available+1){
					System.out.println("Check In Failed: ID" + id + " does not belong to the Library.");
					return;
				} else {
					thing.available++;
					pers.borrowed.remove(thing);
					System.out.println("Check In Success: ID" + thing.uniqueID + " " + thing.title + " Copies: " + thing.available);
					return;
				}
			}
		}
		System.out.println("Check In Failed: ID" + id + " not found.");		
	}
	
	public void addItem(Item item){
		for(Item thing:items){
			if(thing.uniqueID.equals(item.uniqueID)){
				addItem(thing.uniqueID);
				return;
			}
		}
		
		items.add(item);
		item.copies++;
		item.available++;
	}
	
	public void addItem(String id){
		for(Item thing:items){
			if(thing.uniqueID.equals(id)){
				thing.copies++;
				thing.available++;
				return;
			}
		}
		System.out.println("Item ID"+id+ " does not already exist in the library.");
	}
	
	public void removeItem(String id){
		for(Item thing:items){
			if(thing.uniqueID.equals(id)){
				if(thing.copies>0){
					if(thing.available==thing.copies){
						thing.available--;
					}
					thing.copies--;
					System.out.println("Remove Item Success: ID" + thing.uniqueID + " " + thing.title + " Remaining Copies: " + thing.copies);
					return;
				} else {
					System.out.println("Remove Item Failed: Not enough copies to remove.");
					return;
				}
			}
		}
		System.out.println("Remove Item Failed: ID"+id+" not found.");
	}
	
	public void updateItem(){}
	
	public void registerPerson(Person person){
		if(people.contains(person)){
			System.out.println(person.name +" already registered.");
		} else {
			int digit = 1;
			int alpha = 3;
			if(person.name.length()<alpha){
				alpha = person.name.length();
			}
			for(Person pers:people){
				if(person.name.substring(0,alpha).toUpperCase().equals(pers.uniqueID.substring(0, alpha))){
				 digit++;
				}
			}
			person.uniqueID = person.name.substring(0, alpha).toUpperCase() + digit;
			people.add(person);
			System.out.println(person.name + " registered as " + person.uniqueID);
		}
	}
	
	public void deletePerson(String id){
		for(Person pers:people){
			if(pers.uniqueID.equals(id)){
				System.out.println(pers.name + " | " + pers.uniqueID + " is removed from the system.");
				people.remove(pers);
				return;
			}
		}
		System.out.println(id + " not found.");
	}
	
	public void updatePerson(String id){}
	
	public void printMembers(){
		for(Person p:people){
			System.out.println("uID: "+p.uniqueID+" | name: "+p.name);
		}
	}
	
	public void printItems(){
		for(Item i:items){
			System.out.println("uID: "+i.uniqueID+"  | title: "+i.title);
		}
	}
	
	public void checkItem(String id){
		for(Item i:items){
			if(i.uniqueID.equals(id)){
				i.printInfo();
				System.out.println("Copies owned: "+i.copies);
				System.out.println("Copies available: "+i.available);
			}
		}
	}
	
	public void whoBorrowed(String id){
		System.out.println("People that borrowed "+id+":");
		for(Person p:people){
			for(Item i:p.borrowed){
				if(id.equals(i.uniqueID)){
					System.out.println(p.name+" | "+p.uniqueID);
					//return;
				}
			}
		}
		System.out.println();
	}
	
	public void findBookByGenre(String genre){}
}
