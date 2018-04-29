package test;

import java.util.Scanner;

public class Rank {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		int n,x,y;
		while(t>0) {
			n=sc.nextInt();
			x=sc.nextInt();
			y=sc.nextInt();
			System.out.println(n-Math.max(n-y,x+1)+1);
			t--;
		}
		sc.close();
	}
	
}
