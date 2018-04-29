package test;

import java.util.Scanner;

public class Optimized {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			int n = sc.nextInt();
			int arr[] = new int[n];
			if(n==1) {
				System.out.println(sc.nextInt());
				continue;
			}
			for(int i=0;i<n;i++)
				arr[i] = sc.nextInt();
			int mid=0,negcount=0,poscount=1;
			if(n%2==0) 
				mid = arr[n/2]+arr[n/2-1];
			else
				mid = arr[n/2];
			for(int i=0;i<n;i++) {
				if(arr[i]==0) {
					System.out.print(arr[i]+" ");
					System.out.print(mid);
				} else if(arr[i]<0) {
					if(negcount!=0)
						System.out.print(arr[i]);
					else {
						negcount++;
						continue;
					}
				} else if(arr[i]>0) {
					if(poscount==0) {
						System.out.print(arr[i]);
						poscount++;
					}
					else {
						poscount--;
						continue;
					}
				}
				if(i<n-1)
					System.out.print(" ");
			}
			System.out.println("");
			t--;
		}
		sc.close();
	}
}
