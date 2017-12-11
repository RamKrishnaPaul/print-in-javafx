package com.test;

public class FactRec {
	
	public static int fact(int num)
	{
		if(num==1)
		{
			return 1;
		}
		else
		{
			return(num*fact(num-1));
		}
	}
    public static void main(String[] args) {
	     int i = fact(5);
	     System.out.println("fact is::"+ i );
	}
}
