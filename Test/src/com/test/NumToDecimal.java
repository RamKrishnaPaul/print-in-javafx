package com.test;

import java.util.ArrayList;

public class NumToDecimal {
	public static void main(String[] args) {
        int num = 8;
        int rmd = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        while(num > 0)
        {
        	rmd = num%2;
            arr.add(rmd);
        	num = num/2;
        }
        for(int i=arr.size()-1; i >=0; i--)
        {
        	System.out.print(arr.get(i) + " ");
        }
	}
}
