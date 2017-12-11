package com.test;


import java.util.LinkedHashMap;
import java.util.Map;

public class RepeatAndNonRepeat {
	
	public static void repeatedAndNotReapted(String str)
	{
		LinkedHashMap<Character, Integer> map = new LinkedHashMap<>(); // LinkedList cause if we want first char of String as Repeated and non repeated.
		char[] toCharArray = str.toCharArray();
		for(Character recChar : toCharArray)
		{
			if(map.containsKey(recChar))
			{
				map.put(recChar, map.get(recChar)+1);
			}
			else
			{
				map.put(recChar, 1);
			}
		}
		for(Map.Entry<Character, Integer> entry : map.entrySet())
		{
			if(map.get(entry.getKey()) == 1)
			{
				System.out.println("Non repeated Char:"+ entry.getKey());
			}
			else if(map.get(entry.getKey()) > 1)
			{
				System.out.println("Repeated char: " + entry.getKey());
			}
		}
	}
	public static void main(String[] args) {
		String str = "JavaConcept";
        RepeatAndNonRepeat.repeatedAndNotReapted(str);
	}
}
