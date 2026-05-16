//1c.
//1.Write a Java program to iterate through all elements in a linked list starting at the specified position ( 2nd) using iterator ( hint : Iterator iteratorobj = listobj.listIterator(1))
package program1c;

import java.util.*;
public class p1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String>	ls = new LinkedList<>();
		ls.add("Orange");
		ls.add("Green");
		ls.add("Pink");
		ls.add("Red");
		ls.add("Blue");
		Iterator iterator = ls.listIterator(2);
		while (iterator.hasNext()) {
		System.out.println(iterator.next());
		}
	}

}
