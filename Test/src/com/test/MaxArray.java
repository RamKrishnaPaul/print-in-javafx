package com.test;

public class MaxArray {
  public static void main(String[] args) {
	int[] arr = {5,2,3,10,9,8};
	
    int max = arr[0];
    
    for(int i=1; i<arr.length; i++)
    {
    	if(arr[i] > max)
    	{
             max = arr[i];
    	}
    }
    System.out.println("max: "+ max);
  }
}
