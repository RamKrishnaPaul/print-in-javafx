package com.test;

public class FProgramme {
	public static void fact(int fValue)
	{
		int f = 1;
		for(int i = 1; i <= fValue; i++)
		{
			f = f*i;
		}
		System.out.println(f);
	}
	public static void main(String[] args) {
		FProgramme.fact(5);
		fab.fibo(10);
	}
}
class fab
{
	public static void fibo(int n)
	{
		int n1 = 0, n2 = 1, n3 = 1;
		System.out.print(n1 +" "+ n2);
		for(int i=1; i<=n-2; i++)
		{
			n3 = n1 + n2;
			n1 = n2;
			n2 = n3;
			System.out.print(" "+n3);
		}
	}
}
