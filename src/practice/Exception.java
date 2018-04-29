package practice;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Exception {
	public static void main(String []args) {
		PrintWriter out = null;
		try {
	        System.out.println("Entered try statement");
	        out = new PrintWriter(new FileWriter("OutFile.txt"));
		}catch(IndexOutOfBoundsException | IOException e){
			System.out.println(e);
		}
	}
}
