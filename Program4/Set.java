package Program4;

public class Set {
	LinkedNode head;
	int count;
	
	// Constructor
	public Set() {
		head = null;
		count = 0;
	}
	
	//-----------------------------------------------------------------
	//  STEP 1:
	//	Implements Add operation
	//-----------------------------------------------------------------
	public void add (int x) {
		if (!exists(x)) {
			LinkedNode node = new LinkedNode(x);
			
			if (head == null) {
				head = node;
				count++;
			} else {
				node.next = head;
				head = node;
				count++;
			}
		}
	}
		
	//-----------------------------------------------------------------
	//  STEP 2:
	//	Implements Delete operation
	//-----------------------------------------------------------------
	public void delete(int x) {
		if (exists(x)) {
			if (head.x == x) {
				head = head.next;
				count--;
			} else {
				LinkedNode current = head;
				
				while (current.next != null) {
					if (current.next.x == x) {
						if (current.next.next == null) {
							current.next = null;
							count--;
						} else {
							current.next = current.next.next;
							count--;
						}
					} else {
						current = current.next;
					}
				}
			}
		}
	}
	
	
	//-----------------------------------------------------------------
	//  STEP 3:
	//	Implements Exists operation
	//-----------------------------------------------------------------
	public boolean exists(int x) {
		LinkedNode current = head;
		boolean doesExist = false;
		
		while (current != null) {
			if (current.x == x) {
				doesExist = true;
				break;
				
			} else {
				current = current.next;
			}
		}
		return doesExist;
	}
	
	//-----------------------------------------------------------------
	//  STEP 4:
	//	Implements toString operation
	//-----------------------------------------------------------------
	public String toString() {
		LinkedNode current = head; 
		String elements = "";
		while (current != null) {
			elements += current.x + " ";
			current = current.next;
		}
		return elements;
	}
	
}
