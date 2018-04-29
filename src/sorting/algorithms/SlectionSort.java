package sorting.algorithms;

import java.util.Scanner;

public class SlectionSort {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Size of the input list:");
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int k=0;k<n;k++)
			arr[k]=sc.nextInt();
		int min=0,temp;
		for(int itr=0; itr<n-1;itr++) {
			min = itr;
			for(int i=itr+1;i<n;i++) {
				if(arr[itr]>arr[i]) {
					min = i;
				}
			}
			//swap
			temp = arr[itr];
			arr[itr] = arr[min];
			arr[min] = temp;
		}
		for(int i:arr)
			System.out.print(i+" ");
		sc.close();
	}
}
