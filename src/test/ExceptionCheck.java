package test;

import java.util.Scanner;

public class ExceptionCheck {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int i,j,k;
		for(i=1;i<=n;i++) {
			for(j=1;j<=n-i;j++)
				System.out.print(" ");
			for(k=1;k<=i;k++)
				System.out.print("#");
			System.out.println();	
		}
		sc.close();	
	}
}