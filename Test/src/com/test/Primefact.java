package com.test;

public class Primefact {
    public static void main(String[] args) {
		int num = 14;
		int i = 2;
		while(num>1)
		{
			if(num%i==0)
			{
				System.out.print(i +" ");
				num = num/2;
			}
			else
			{
				i++;
			}
		}
	}
}
