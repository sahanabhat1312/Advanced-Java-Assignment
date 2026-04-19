package program1c;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.*;
public class p2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<String>	ls = new LinkedList<>();
		ls.add("Orange");
		ls.add("Green");
		ls.add("Pink");
		ls.add("Red");
		ls.add("Blue");
		Iterator iterator =  ls.descendingIterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
			}
	}

}