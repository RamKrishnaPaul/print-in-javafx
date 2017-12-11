package com.test;

import java.util.Arrays;

public class Bs {
	public static void sort(int arr[])
	{
		for(int i=0; i<arr.length; i++)
		{
			for(int j=i+1; j<arr.length; j++)
			{
				if(arr[i]>arr[j])
				{
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
//				if(arr[i].compareTo(arr[j]) > 0)
//				{
//					String temp1 = arr[i];
//					arr[i] = arr[j];
//					arr[j] = temp1;
//				}
			}
		}
	}
	public static void main(String[] args) {
		int arr[] = {5,2,6,7,1,4,3,10,9};
//		String[] arr = {"Manoj", "Ajay", "Ram", "Boss", "Dany"};
		System.out.println("intital array:"+ Arrays.toString(arr));

		Bs.sort(arr);
		System.out.println("sorted array"+ Arrays.toString(arr));	
	}
}
