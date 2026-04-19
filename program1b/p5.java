package program1b;

import java.util.*;
public class p5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> ls = new ArrayList<>();
		ls.add("Orange");
		ls.add("Green");
		ls.add("Pink");
		ls.add("Red");
		ls.add("Blue");
		String Str="Green";
		System.out.println(ls);
		System.out.println("Removing the nth Element:"+ls.remove(Str));
		System.out.println(ls);
	}

}