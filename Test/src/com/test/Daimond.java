package com.test;

public class Daimond {
 public static void main(String[] args) {
	for(int i=1; i<=5; i++)
	{
		for(int j=1; j<=i; j++)
		{
			System.out.print("*");
		}
		System.out.println(" ");
	}
	
	System.out.println("------------------------");
	
	for(int i=1; i<=5; i++)
	{
		for(int j=1; j<=6-i; j++)
		{
			System.out.print("*");
		}
		System.out.println(" ");
	}
	System.out.println("----------------------");
	
	for(int i=1; i<=5; i++)
	{
		for(int j=1; j<=5-i; j++)
		{
			System.out.print(" ");
		}
		for(int k=1; k<=i; k++)
		{
			System.out.print("*");
		}
		System.out.println(" ");
	}
	System.out.println("---------------------");
	
	for(int i=1; i<=5; i++)
	{
		for(int j=1; j<i; j++)
		{
			System.out.print(" ");
		}
		for(int k=5; k>=i; k--)
		{
			System.out.print("*");
		}
		System.out.println(" ");
	}
 }
}
