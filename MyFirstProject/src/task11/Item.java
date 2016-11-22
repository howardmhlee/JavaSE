package task11;

public abstract class Item {
	
	String title;
	String uniqueID;
	int pages;
	int copies; //Maximum copies at the library
	int available; //Existing copies at the library
	
	public Item (String uniqueID, String title){
		this.uniqueID = uniqueID;
		this.title = title;
	}
	
	public void printInfo(){
		System.out.println("uID: "+uniqueID+" title: "+title);
	}
	
	public void updatePages(int pages){
		this.pages = pages;
	}
	
	public void updateTitle(String title){
		this.title = title;
	}
}
