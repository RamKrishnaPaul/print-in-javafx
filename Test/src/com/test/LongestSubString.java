package com.test;

import java.util.LinkedHashMap;

public class LongestSubString {
	public static void longestSubString(String str)
	{
		char[] strChar = str.toCharArray();
        String longestSubStr = "";
        int longestsubStrLength = 0;
		LinkedHashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		for(int i=0; i< strChar.length; i++)
		{
			char ch = strChar[i];
			if(!map.containsKey(ch))
			{
                  map.put(ch, i);
			}
			else
			{
				i = map.get(ch);
				map.clear();
			}
		}
		if(map.size() > longestsubStrLength)
		{
			longestsubStrLength = map.size();
			longestSubStr = map.keySet().toString();
		}
		System.out.println("Longest String is: " + longestSubStr);
		System.out.println("Longest String length is: " + longestsubStrLength);
	}

	public static void main(String[] args) {
		LongestSubString.longestSubString("javaconceptoftheday");
	}
}
