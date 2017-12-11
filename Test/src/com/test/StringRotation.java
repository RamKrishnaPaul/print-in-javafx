package com.test;

public class StringRotation {

	public void rotationStr(String s1, String s2)
	{
		if(s1.length() != s2.length())
		{
			System.out.println("String is not rotation");	
		}
		else {
			String s3 = s1+s2;
			if(s3.contains(s2))
			{
				System.out.println(s2 +" :is Rotation String" );
			}
		}
	}
	public static void main(String[] args) {
		StringRotation obj = new StringRotation();
		obj.rotationStr("JavaJ2eeManoj", "j2eeManojJava");
	}
}
