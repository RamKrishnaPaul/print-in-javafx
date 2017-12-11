package com.test;

public class SecondMax {
public static void main(String[] args) {
	int arr[] = {5,2,6,3,4,9,1,10,9};
	int max = arr[0];
	int secondMax = arr[0];
	
	for(int i=1; i<arr.length; i++)
	{
		if(arr[i] > max)
		{
			secondMax = max;
			max = arr[i];
		}
		else if(arr[i] > secondMax)
		{
			secondMax = arr[i];
		}
	}
	System.out.println("Max :"+ max);
	System.out.println("Second max:" + secondMax);
}
}
