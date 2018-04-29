package test;

import java.util.Scanner;

public class Ninja {
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int sw = sc.nextInt();
		Long n = Long.parseLong(s);
		int len = s.length();
		int arr[] = new int[len];
		while(len>0) {
			arr[len-1]=(int) (n%10);
			len--;
			n = n/10;
		}
		int temp=0;
		int max=0;
		for(int j=0;j<s.length() && sw>0;j++) {
			max=j;
			for(int i=j+1;i<s.length();i++) {
				if(arr[max]<arr[i]) {
					max = i;
				}
			}
			if(j!=max) {
			temp = arr[j];
			arr[j]=arr[max];
			arr[max] = temp;
			sw--;
			}
		}
		for(int i:arr)
			System.out.print(i);
		sc.close();
	}
	

}
