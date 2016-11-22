package task11;

public class Book extends Item {

	String genre;
	
	public Book(String uniqueID, String title,String genre) {
		super(uniqueID, title);
		this.genre = genre;
	}
	
	public void printInfo(){
		System.out.println("uID: "+uniqueID+" | title: "+title+ " | genre: " + genre);
	}
}
