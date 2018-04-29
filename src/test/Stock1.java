package test;

import java.util.Scanner;

public class Stock1 {
	public static void main(String args[]) {
	
	Scanner sc = new Scanner(System.in);
	int t = sc.nextInt();
	
	for(int i=0;i<t;i++) {
		int profit = 0, share=0;
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int j=0;j<n;j++) {
			arr[i] = sc.nextInt();
		}
	for(int m=0;m<n;m++) {
		int count = 0,h=0;
		while(h<n-1 && arr[h+1]>arr[m]) { 
			share++;
			count++;
			h++;
			break;
			}
		if(count==0 && share!=0) {
			profit = profit+share*arr[m];
			share=0;
		}
	}
		System.out.println(profit);	
	}
	sc.close();
 }
}