package com.test;


import java.util.LinkedHashSet;

public class RemoveDupChar {	
	public static void removeduplicateChar(String str)
	{
		LinkedHashSet<Character> set = new LinkedHashSet<>();
		char[] c = str.toCharArray();
		for (int i = 0; i < c.length; i++) {
			set.add(c[i]);
		}
		System.out.println(set);
	}
	public static void main(String[] args) {
       String str = "missing";
       RemoveDupChar.removeduplicateChar(str);
	}
}
