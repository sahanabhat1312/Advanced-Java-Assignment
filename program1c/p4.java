package program1c;

import java.util.*;

public class p4{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<String> ls = new LinkedList<>();
		ls.add("Orange");
		ls.add("Green");
		ls.add("Pink");
		ls.add("Red");
		ls.add("Blue");
		for(int i=0;i<ls.size();i++) {
			System.out.println("index: "+i+" value: "+ls.get(i));
		}
	}

}