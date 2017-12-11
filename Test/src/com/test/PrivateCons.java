package com.test;

public class PrivateCons {
	public static void main(String[] args) {
		Call.getInstance();
	}
}
class Call
{
	private Call()
	{
		System.out.println("private cons");
	}
	public static Call getInstance()
	{
		return new Call();

	}
}
