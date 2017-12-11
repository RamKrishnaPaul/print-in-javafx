package com.test;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileExample {
	public static void main(String[] args) throws IOException {
		File file = new File("E:\\manoj.txt");
		if(!file.exists())
		{
			file.createNewFile();
			System.out.println("File Created");
		}
		else
		{
			System.out.println("File already exists");
		}
		
		FileOutputStream fout = new FileOutputStream(file);
		String str = "maojsdf jdfbjdsfb dfdhf";
		byte[] b = str.getBytes();
		fout.write(b);
		fout.flush();
		fout.close();
		
		FileInputStream fin = new FileInputStream(file);
		int i;  
	    while((i=fin.read())!=-1)  
	    System.out.print((char)i);
	    fin.close();
	}	
}
