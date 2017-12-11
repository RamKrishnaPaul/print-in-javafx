package com.test;

public class RevStrRec {
	
	
	public static String reverseString(String str)
	{
		String reverse = "";
		if(str.length() == 1) {
			return str;
		}
		else
		{
			reverse += str.charAt(str.length()-1)+ reverseString(str.substring(0,str.length()-1));
			return reverse;
		}
	}
	public static void main(String[] args) {
       String str = "manoj";
       String rev = RevStrRec.reverseString(str);
       System.out.println(rev);
	}
}
