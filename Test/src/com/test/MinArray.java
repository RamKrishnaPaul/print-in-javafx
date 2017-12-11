package com.test;

public class MinArray {
	public static void main(String[] args) {
		int arr[] = {5,10,3,9,8,5,6,1};
		int min = arr[0];
		for(int i=1; i<arr.length; i++)
		{
			if(arr[i] < min)
			{
				min = arr[i];
			}
		}
		System.out.println("min element"+ min);
	}
}
