package test;

import java.util.Arrays;
import java.util.Scanner;

public class Happy {
	public static void main(String []args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0) {
			int n = sc.nextInt();
			int arr[] = new int[n];
			long sum=0,temp1,sum1=0,temp2=0;
			int	f=0,r=n-1,temp;
			for(int i=0;i<n;i++) {
				temp=sc.nextInt();
				if(temp>=0) {
					arr[f]=temp;
					sum = sum+temp;
					f++;
				} else {
					arr[r]=temp;
					sum1 = sum1+temp;
					r--;
				}
			}
			temp1 = sum*(f);
			System.out.println(temp1);
			System.out.println(sum1);
			Arrays.sort(arr, f,n);
			for(int i=f;i<n;i++) {
				temp2=(sum+arr[f])*(f+1);
				if(temp1>temp2) {
					break;
				} else {
					temp1 = temp2;
					sum1=sum1-arr[f];
				}
			}
			System.out.println(temp1-sum1);
			t--;
		}
		sc.close();
	}
}
