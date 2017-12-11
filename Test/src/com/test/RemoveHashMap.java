package com.test;




import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


public class RemoveHashMap {
	public static void main(String[] args) {

		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "manoj");
		map.put(2, "ram");
		map.put(3, "ravi");
		map.put(4, "manoj");
		map.put(5, "manoj");
		System.out.println("map int"+map);
		map=invert(invert(map));
		System.out.println("Map with Unique value:"+map);
		//public static Map<Integer, String> invert(Map<Integer, String> map){

	}

	private static <K, V>  Map<V, K> invert(Map<K, V> map) {
		Map<V, K> map1 = new HashMap<V, K>();

		for(Entry<K, V> m : map.entrySet()){
			map1.put(m.getValue(), m.getKey());
		}
		return map1;
	}

}
