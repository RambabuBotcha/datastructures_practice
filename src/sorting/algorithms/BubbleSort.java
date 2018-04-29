package sorting.algorithms;

import java.util.Scanner;

/*
	Bubble sort algorithm
	@author Ram
 */
public class BubbleSort {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Size of the input list:");
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int k=0;k<n;k++)
			arr[k]=sc.nextInt();
		for(int itr=n-1; itr>0;itr--) {
			for(int i=0;i<=itr-1;i++) {
				if(arr[i]>arr[i+1]) {
					//swap
					int temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
				}
			}
		}
		for(int i:arr)
			System.out.print(i+" ");
		sc.close();
	}
}
