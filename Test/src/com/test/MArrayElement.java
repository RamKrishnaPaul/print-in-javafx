package com.test;

public class MArrayElement {

	public static int getNum(int arr[], int n)
	{
      int total;
      total = (n+1)*(n+2)/2;
      for(int i=0; i<n; i++)
      {
    	  total -= arr[i];
      }
     return total;
	}
	public static void main(String[] args) {
		int arr[] = {1,2,4,5,6};
		int recNum = getNum(arr, 5);
		System.out.println("Missing element:"+ recNum);
	}
}
