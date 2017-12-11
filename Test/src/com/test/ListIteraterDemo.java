package com.test;

import java.util.ArrayList;
import java.util.ListIterator;

public class ListIteraterDemo {
 public static void main(String[] args) {
	 ArrayList<String> list = new ArrayList<String>();
	 list.add("manoj");
	 list.add("ram");
	 list.add("ravi");
	 list.add("vimal");
	 list.add("nag");
	 
	 ListIterator<String> itr = list.listIterator();
	 while(itr.hasNext())
	 {
        System.out.println(itr.next()); 
	 }
	 System.out.println("=================");
	 while(itr.hasPrevious())
	 {
		 System.out.println(itr.previous());
	 }
}
}
