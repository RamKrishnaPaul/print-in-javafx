package com.test;

public class ThreadDemo extends Thread {
	public void run()
	{
		System.out.println("run");
	}
	public void function()
	{
		System.out.println("function");
	}
	
	public static void main(String[] args) {
       ThreadDemo t = new ThreadDemo();
       t.start();
       t.function();  
	}
}
