package com.test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

@SuppressWarnings("serial")
class Student implements Serializable
{
	int rollNo;
	String studentName;
	String stream;
	List<String> subject;
	Student()
	{
		super();
	}
	Student(int rollNo, String studentName, String stream, List<String> subject) {
		this.rollNo = rollNo;
		this.studentName = studentName;
		this.stream = stream;
		this.subject = subject;
	}
}
public class StudentSer  {
	public static void main(String[] args) throws IOException {
		Student student = new Student();
    	student.rollNo = 101;
    	student.stream = "Cs";
    	student.studentName = "manoj";
    	List<String> sub = new ArrayList<String>();
    	sub.add("maths");
    	sub.add("Science");
    	sub.add("Physics");
    	student.subject = sub;
		FileOutputStream fout = new FileOutputStream("E://student.txt");
	    ObjectOutputStream out = new ObjectOutputStream(fout);
	    out.writeObject(student);
	    out.flush();
	    out.close();
	    System.out.println("Done");
	}
}

