package com.test;

import java.util.Arrays;

public class Anagram {

	public static void anagramTest(String s1, String s2)
	{
	    String recS1 = s1.replaceAll("\\s", "").toLowerCase();
	    String recS2 = s2.replaceAll("\\s", "").toLowerCase();
	    
        if(recS1.length() != recS2.length())
        {
        	 System.out.println("Strings are not anagram");
        }
        
        char[] arr1 = recS1.toCharArray();
        char[] arr2 = recS2.toCharArray();
        
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        
        if(Arrays.equals(arr1, arr2))
        {
        	System.out.println("String is anagram");
        }    
        else
        {
        	System.out.println("String is not anagram");
        }
	}
	public static void main(String[] args) {
        Anagram.anagramTest("keep" , "p eeK");
        
	}
}
