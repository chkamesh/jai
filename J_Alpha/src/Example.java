// Java progrm to demonstrate working of priority queue in Java 
import java.util.*; 

class Example 
{ 
	public static void main(String args[]) 
	{ 
		// Creating empty priority queue 
		PriorityQueue<String> pQueue = 
						new PriorityQueue<String>(); 

		// Adding items to the pQueue using add() 
		pQueue.add("C"); 
		pQueue.add("C++"); 
		pQueue.add("Java"); 
		pQueue.add("Python"); 
		pQueue.add("orange");
		pQueue.add("fig");
		pQueue.add("watermelon");
		pQueue.add("lemon");
		// Printing the most priority element 
		System.out.println("Head value using peek function:"
										+ pQueue.peek()); 

		// Printing all elements 
		System.out.println("The queue elements:"); 
		Iterator itr = pQueue.iterator(); 
		while (itr.hasNext()) 
			System.out.println(itr.next()); 
		while (itr.hasNext()) 
			System.out.println(itr.next()); 

		// Removing the top priority element (or head) and 
		// printing the modified pQueue using poll() 
		pQueue.remove("Java"); 
		System.out.println("aaAfter removing an element" + 
						"with poll function:"); 
		Iterator<String> itr2 = pQueue.iterator(); 
		while (itr2.hasNext()) 
			System.out.println(itr2.next()); 

		// Removing Java using remove() 
		pQueue.remove("Python"); 
		System.out.println("after removing Java with" + 
						" remove function:"); 
		Iterator<String> itr3 = pQueue.iterator(); 
		while (itr3.hasNext()) 
			System.out.println(itr3.next()); 

		// Check if an element is present using contains() 
		boolean b = pQueue.contains("C"); 
		System.out.println ( "Priority queue contains C " + 
							"or not?: " + b); 

		// Getting objects from the queue using toArray() 
		// in an array and print the array 
		Object[] arr = pQueue.toArray(); 
		System.out.println ( "Value in array: "); 
		for (int i = 0; i<arr.length; i++) 
		System.out.println ( "Value: " + arr[i].toString()) ; 
		TreeSet<StringBuffer> ts=new TreeSet<>(new Comparator<StringBuffer>() {

			@Override
			public int compare(StringBuffer o1, StringBuffer o2) {
				
				return o1.toString().compareTo(o2.toString());
			}
		});
		ts.add(new StringBuffer("A")); 
        ts.add(new StringBuffer("Z")); 
        ts.add(new StringBuffer("L")); 
        ts.add(new StringBuffer("B")); 
        ts.add(new StringBuffer("O")); 
        System.out.println(ts); 
	} 
} 
