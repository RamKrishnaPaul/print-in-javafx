package com.test;

// singleton class also using concept of factory method.
public class FactoryMethod {

	public static final FactoryMethod Instance = new FactoryMethod();

	private FactoryMethod()
	{
		System.out.println("private constructor");
	}
	public static FactoryMethod getInstance()
	{
		return Instance;
	}
	public static void main(String[] args) {
		CallCons.main(args);
	}
}
class CallCons
{
	public static void main(String[] args) {
		FactoryMethod.getInstance();
	}	
}
