package com.test;

public class SwapString {
	public static void swap(String s1, String s2)
	{
		s1 = s1+s2;
		s2 = s1.substring(0, s1.length()-s2.length());
		s1 = s1.substring(s2.length());
		
		System.out.println("After swapping");
		System.out.println(s1 +" "+ s2);
	}
	public static void main(String[] args) {
	  System.out.println("Before swapping");
	  String s1 = "Manoj";
	  String s2 = "Janom";
	  System.out.println(s1 +" "+ s2);
      SwapString.swap(s1, s2);
	}
}
