package com.test;

public class Multi2DArray {
	public static void main(String[] args) {

		int arr1[][] = {{1,2,3},{4,5,6}};
		int arr2[][] = {{7,8,9},{10,11,12}};
		int arr3[][] = new int[3][3];
		int sum = 0;

		for(int i=0; i<arr1.length; i++)
		{
			for(int j=0; j<=arr2.length; j++)
			{
				for(int k=0; k<=arr2.length; k++)
				{
					sum = sum + (arr1[i][k] * arr2[k][j]);
				}
				arr3[i][j] = sum;
				sum = 0;
			}
			System.out.println(" ");
		}
	}
}
