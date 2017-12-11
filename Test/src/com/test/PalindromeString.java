package com.test;

public class PalindromeString {
 public static void main(String[] args) {
	String name = "dfafd";
	String rev = "";
	char[] nameChar =  name.toCharArray();
	for(int i=nameChar.length-1; i>=0; i--)
	{
		rev  = rev + name.charAt(i);
	}
	System.out.println(rev);
	if(name.equalsIgnoreCase(rev))
	{
		System.out.println("is palindrome");
	}
	else
	{
		System.out.println("Not a palindrome");
	}
}
}
