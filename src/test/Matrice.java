package test;

import java.util.Scanner;

public class Matrice {
	public static void main() {
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	int m = sc.nextInt();
	int a[][] = new int[n][m];
	for(int i=0;i<n;i++)
		for(int j=0;j<m;j++)
			a[i][j]=sc.nextInt();
	
	sc.close();
	}

}
