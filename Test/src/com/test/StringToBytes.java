package com.test;


public class StringToBytes {
public static void main(String[] args) {
	String str = "manoj";
	byte[] strBytes = str.getBytes();
    System.out.println(strBytes);
    
    String newStr = new String(strBytes);
    System.out.println(newStr);
    
}
}
