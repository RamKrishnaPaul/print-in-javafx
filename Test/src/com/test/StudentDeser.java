package com.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class StudentDeser {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileInputStream file;
		file = new FileInputStream("E://student.txt");
		ObjectInputStream in = new ObjectInputStream(file);
		Student st = (Student)in.readObject();
		System.out.println(st.rollNo);
		System.out.println(st.stream);
		System.out.println(st.studentName);
		System.out.println(st.subject.toString());
		file.close();
	}
}
