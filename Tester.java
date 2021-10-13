public class Tester {

	private static CDoublyLinkedList list0;
	private static CDoublyLinkedList list2;
	private static CDoublyLinkedList list3;
	
	private static void init() {
		list0 = new CDoublyLinkedList();
		list2 = new CDoublyLinkedList();
		list3 = new CDoublyLinkedList();
		list2.addFirst("6:Tony");
		list2.addFirst("5:Tom");
		list2.addFirst("4:Tim");
		list2.addFirst("3:Abby");
		list2.addFirst("2:Morning");
		list2.addFirst("1:Good");
		list0.addFirst(null);
		list0.addFirst("bad");
		list0.addFirst("apple");
		list0.addFirst(null);
	}
	public static void drawLine() {
		System.out.println("-----------------------------");
	}
	
	public static void testAddFirst() { //passed test
		init();
		drawLine();
		System.out.println(list0);
		System.out.println(list2);
		System.out.println(list3);
		drawLine();
	}
	
	public static void testAddLast() { //
		System.out.println("------------------testAddLast()----");
		init();
		list3.addLast("A");
		System.out.println(list3);
		list3.addLast("B");
		System.out.println(list3);
		list3.addLast(null);
		System.out.println(list3);
		list3.addLast("C");
		System.out.println(list3);
		drawLine();
	}
	

	public static void testRemoveStartingAtBack() { 
		init();
		System.out.println("---------------Test removeStartingAtBack---");
		list0.addFirst("apple");
		System.out.println(list0.removeStartingAtBack("notexist")); //false
		System.out.println(list0.removeStartingAtBack("apple")); //true
		System.out.println(list0); //apple, null, bad, null
		System.out.println(list0.removeStartingAtBack(null)); //true
		System.out.println(list0); //apple, null, bad
		list2.removeStartingAtBack("1:Good");
		System.out.println(list2);

		drawLine();
	}
	

	public static void testLastIndexOf() { 
		init();
		System.out.println("------------Test lastIndexOf()-----");
		System.out.println(list3.lastIndexOf("notexist")); //-1
		System.out.println(list0.lastIndexOf(null)); //3
		System.out.println(list2.lastIndexOf(null)); //-1
		System.out.println(list2.lastIndexOf("notexist"));//-1
		System.out.println(list2.lastIndexOf("1:Good"));//0
		System.out.println(list2.lastIndexOf("6:Tony"));//5
		list3.addFirst("B3");
		list3.addFirst("B3");
		list3.addFirst("B3");
		System.out.println(list3.lastIndexOf("B3"));//2
		drawLine();
	}
	
	public static void testSubList() {  
		init();
		list3.addFirst("D");
		list3.addFirst("M");
		list3.addFirst("A");
		list3.addFirst("B");
		list3.addFirst("G");
		list3.addFirst("B");
		list3.addFirst("B");
		list3.addFirst("F");
		System.out.println("--------testSubListOfSmallerValues()----------");
		System.out.println(list3.subListOfSmallerValues("A")); //none
		System.out.println(list3.subListOfSmallerValues("C")); //BBBA
		System.out.println(list3.subListOfSmallerValues("G")); //FBBBAD
		System.out.println(list3.subListOfSmallerValues("Q")); //FBBGBAMD
		drawLine();
	}
	
	public static void testRetainAll() {
		init();
		System.out.println("---------testRetainAll()---------");
		list3.retainAll(list0);
		System.out.println(list3);
		list3.addFirst("C");
		list3.addFirst("C");
		list3.addFirst("6:Tony");
		list3.addFirst("6:Tony");
		list3.retainAll(list2);
		System.out.println(list3);
		init();
		list3.addFirst(null);
		list3.addFirst("bad");
		list3.addFirst(null);
		list3.addFirst("B");
		list3.addFirst("A");
		list3.retainAll(list0);
		System.out.println(list3);
		drawLine();
	}
	
	public static void testSort() {
		init();
		System.out.println("---------test insertionSort()---------");
		list3.insertionSort();
		System.out.println(list3); //none
		list3.addFirst("D");
		System.out.println(list3); //D
		list3.addFirst("F");
		list3.addFirst("E");
		list3.addFirst("G");
		list3.addFirst("E");
		list3.insertionSort();
		System.out.println(list3); //DEEFG
		drawLine();
	}
	
	public static void main(String argv[]) {

		testAddLast(); 
		testSubList(); 
		testLastIndexOf(); 
		testRetainAll(); 
		testRemoveStartingAtBack(); 
		testSort(); 
		
	}//end of main
}

class CDoublyLinkedList {

	private class Node {
		private Object data;   //Assume data implemented Comparable
		private Node next, prev;
		private Node(Object data, Node pref, Node next)
		{
			this.data = data;
			this.prev = pref;
			this.next = next;
		}
	}

	private Node head;
	private int size;

	public CDoublyLinkedList() {
		this.head = new Node(null, null, null );
		this.head.next = this.head;
		this.head.prev=this.head;
		this.size = 0;
	}

	public boolean isEmpty() {
		return this.head == this.head.next;
	} 
	
	// Add Object data to start of this LinkedList
	// Please DO NOT change this addFirst() method.
	// You must keep and include this provided addFirst() method
	//      in your source code.
	public void addFirst(Object data) {
		Node nn = new Node(data, this.head, this.head.next);
		this.head.next.prev = nn;
		this.head.next = nn;
		this.size ++;
	}

	// write a method void addLast(Object data) that will insert 
	// the piece of data at the end of the current list.
	// Note: this list is allowed to store null data element in its list node.
	public void addLast(Object data) {

	}
	
	// Write the subListOfSmallerValues method.  
	// It should return a CDoublyLinkedList object 
	//     containing data that is smaller than the value passed to the method.
        // If a null data element in this list is encountered, you can skip it.
        // You need to use the CompareTo() method to determine which object is smaller.
        // If list A contains {9, 11, 14, 6, 4, 7} and you call  A.subListOfSmallerValues(10),
        // the method call returns a list that contains data in A that is smaller than 10, the passed-in argument.
        // That is, the returned list contains { 9, 6, 4, 7}.
	public CDoublyLinkedList subListOfSmallerValues(Comparable data) {
	
		return null; //change this as needed.
	}
	
	// This method should remove the first occurrence of the data from the list, 
        //      starting at the *BACK* of the list. 
        // It scans the list from back to the front by following the prev links. 
	// The method should return true if successful, false otherwise. 
	// Note that list node may contain null data element. Please handle this edge case.
	public boolean removeStartingAtBack(Object dataToRemove) {
	
		return false;//change this as needed.
	}
	
	// Returns the index of the last occurrence of the specified element in this list, 
	//     or -1 if this list does not contain the element. 
	// More formally, returns the highest index i 
	//     such that (o==null ? get(i)==null : o.equals(get(i))), 
	//     or -1 if there is no such index.
	// Note: a list node may store a null data element. Please handle this edge case.
	public int lastIndexOf(Object o) {

		return -1; //change this as needed.
	}
	
	
	// Removes from this list all of its elements that 
	//    are NOT contained in the specified linkedlist other.
	// If any element has been removed from this list,
	//    returns true. Otherwise returns false.
	// If other list is null, throws NullPointerException.
        // Helper methods are allowed.
	public boolean retainAll(CDoublyLinkedList other) throws NullPointerException {


	    return false; //change this as needed.
	}
	

        // Write this method to sort this list using insertion sort algorithm, 
        //      as we have learned in the classroom.
	public void insertionSort() {
		
	}
	
	@Override
	public String toString() {
		String result = "{";
	    for (Node node = this.head.next; node != this.head; node = node.next) {
	    		if(node.next != this.head)
	    			result += node.data + "->"; 
	    		else
	    			result += node.data;
	    }
	    return result + "}";
	  }
}
