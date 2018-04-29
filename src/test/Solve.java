package test;

import java.util.Scanner;

public class Solve {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			int n = sc.nextInt();
			int arr[] = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			if(n==1) {
				System.out.println(arr[0]);
				t--;
				continue;
			}
			int mid = 0;
			if (n % 2 == 0)
				mid = arr[n / 2] + arr[(n / 2) - 1];
			else
				mid = arr[n / 2];
			int negcount = 0;
			int poscount = 2;
			for (int i = 0; i < n; i++) {
				if (arr[i] == 0) {
					System.out.print(arr[i] + " ");
					System.out.print(mid);
				} else if (arr[i] < 0) {
					if (negcount == 0) {
						negcount++;
						continue;
					} else {
						System.out.print(arr[i]);
					}
				} else {
					if (poscount == 1) {
						poscount++;
						continue;
					} else {
						System.out.print(arr[i]);
						poscount++;
					}
				}
				if (i < n - 1)
					System.out.print(" ");
			}
			System.out.println("");
			t--;
		}
		sc.close();
	}
}
