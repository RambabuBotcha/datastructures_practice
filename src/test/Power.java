package test;

import java.util.Scanner;

public class Power {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0) {
			int n = sc.nextInt();
			int arr[] = new int[n];
			for(int i=0;i<n;i++) {
				arr[i] = sc.nextInt();
			}
	/***		
			int temp=Math.abs(arr[0]-arr[1]),temp2=0;
			for(int i=1;i<n-1;i++) {
				temp2 = Math.abs(arr[i]-arr[i+1]);
				if(temp<temp2) {
					temp = temp2;
				}
			}
	****/			
		
			int max=arr[0],min=arr[0];
			for(int i=1;i<n;i++) {
				if(max<arr[i]) {
					max=arr[i];
				}
				if(min>arr[i]) {
					min=arr[i];
				}	
			}
			System.out.println(Math.abs(max-min));
			t--;
		}		
		sc.close();
	}
}
