package com.test;

public class RString {
	public static void main(String[] args) {
// =================== reverse word ================
		String name = "manoj";
		char[] nameChar = name.toCharArray();
		String reverse = "";
		int length = nameChar.length-1;
		for(int i=length; i>=0; i--)
		{
			reverse = reverse + name.charAt(i);
		}
		System.out.println(reverse);

//====================reverse sentence ==============
		String name1 = "manoj is bad boy";
		String[] splitWords = name1.split(" ");
		String revWords = "";
		for(int i=splitWords.length-1; i>=0; i--)
		{
          revWords = revWords + splitWords[i] + " ";
		}
		System.out.println(revWords);
	}
}
