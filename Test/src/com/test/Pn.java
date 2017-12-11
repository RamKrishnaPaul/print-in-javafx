package com.test;

public class Pn {
	public static void main(String[] args) {
     int num = 3;
     int flag = 0;
    
     for(int i=2; i<=num/2; i++)
     {
    	 if(num%2 == 0)
    	 {
    		 System.out.println("num is primary");
    		 flag = 1;
    		 break;
    	 }
     }
     if(flag == 0)
     {
    	 System.out.println("num is not primary");
     }
	}
}
