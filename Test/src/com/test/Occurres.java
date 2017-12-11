package com.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Occurres{
  public static void main(String[] args) {
	ArrayList<String> list = new ArrayList<String>();
	list.add("manoj");
	list.add("ram");
	list.add("manoj");
	list.add("manoj");
	list.add("ravi");
	list.add("vimal");
	list.add("ram");
	System.out.println(list);
	HashMap<String, Integer> map = new HashMap<String, Integer>();
	for(String recData : list)
	{
		if(map.containsKey(recData))
		{
			map.put(recData, map.get(recData)+1);
		}
		else
		{
			map.put(recData, 1);
		}
	}
	for(Map.Entry<String, Integer> entry : map.entrySet())
	{
		String name = entry.getKey();
		Integer count = entry.getValue();
		System.out.println(name +" "+ count);
	}
}
}
