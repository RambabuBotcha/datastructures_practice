package test;

import java.util.Scanner;

public class Array2D {
	public static void main(String[] args) throws Exception{
		Scanner in = new Scanner(System.in);
		long m,k,max_value=0,temp=0;
		int n,a,b;
		n = in.nextInt();
		m = in.nextInt();
		long arr[] = new long[n+1];
		for(int i = 0; i < m; i++){
			a = in.nextInt();
			b = in.nextInt();
			k = in.nextInt();
			arr[a]=arr[a]+k;
			if(b<=n-1) {
				arr[b+1]-=k;
			}
		}
		for(int i=1;i<=n;i++) {
			temp+=arr[i];
			if(temp>max_value) {
				max_value=temp;
			}
		}
		System.out.println(max_value);
		in.close();
	}
}
