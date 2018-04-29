package test;

import java.util.Scanner;

public class Thief {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0) {
			int n = sc.nextInt();
			long arr[] = new long[n];
			for(int i=0;i<n;i++) {
				arr[i] = sc.nextLong();
			}
			long sum=0,sum1=0,temp=0,temp1=0;
		for(int i=0;i<n;i++) {
			sum=0;
			temp=0;
			temp1=0;
			for(int j=0;j<n;j++) {
				if(arr[j]>=arr[i]) {
					 temp = temp+arr[i];
				} else{
				    if(temp>temp1){
				        temp1=temp;
				    }
				  //  System.out.println(temp);
				    temp=0;
				}
			}
			System.out.println(temp+"  "+temp1);
			if(temp>temp1){
			    sum=temp;
			}else{
			    sum=temp1;
			}
			if(sum>sum1) {
				sum1=sum;
			}
		}
		System.out.println(sum1);
		t--;
		}
		sc.close();
	}
}
