
package com.test;

public class PalindromeInteger {
 public static void main(String[] args) {
	int num = 12345;
	int rmd , rev = 0;
	while(num > 0)
	{
		rmd = num%10;
		rev = rev*10 + rmd;
		num = num/10;
	}
	System.out.println(rev);
 }
}
