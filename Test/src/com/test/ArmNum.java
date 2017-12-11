package com.test;

public class ArmNum {
  public static void main(String[] args) {
  int num = 153;
  int rmd, a = 0;
  int armNum = num;
    while(num>0)
    {
    	rmd = num%10;
    	a += (rmd*rmd*rmd);
    	num = num/10;
    }
    if(a == armNum)
    {
    	System.out.println("arm num");
    }
    else
    {
    	System.out.println("no arm num");
    }
}
}
