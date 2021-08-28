package Program4;

public class LinkedNode { 
	int x;            
	LinkedNode next;  
	
	// Default constructor
	LinkedNode() {
		next = null;
	}
	
	// Constructor that initializes the data value
	LinkedNode(int x) {
		this.x = x;
	}
	
}