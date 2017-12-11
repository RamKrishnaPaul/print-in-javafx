package com.test;

public class PerfNum {
	public static void main(String[] args) {
        int num = 6; 
        int pNum = 0;
        for(int i=1; i<=num/2; i++)
        {
        	if(num%i==0)
        	{
        		pNum = pNum + i;
        	}
        }
        if(num==pNum)
        {
        	System.out.println("perfect no");
        }
        else
        {
        	System.out.println("not a perface no");
        }
	}
}
