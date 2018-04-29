package test;
import java.util.Scanner;

public class TestClass {
	public static void main(String args[]) {
Scanner sc = new Scanner(System.in);
int t = sc.nextInt();
for(int i=0;i<t;i++) {
	int profit = 0, share=0,invest=0;
	int n = sc.nextInt();
	int arr[] = new int[n];
	for(int j=0;j<n;j++) {
		arr[j] = sc.nextInt();
	}
	
for(int m=0;m<n;m++) {
	int count = 0,h=m;
	while(h<n-1) {
		if(arr[h+1]>arr[m]) {
		  share++;
		  invest = invest+arr[m];
		  count++;
		  break;
		 }
		h++;
		}
	if(count==0 && share!=0) {
		profit = profit+share*arr[m];
		share=0;
	} else if(share!=0 && m==n-1) {
		profit = profit+share*arr[m];
	}
}
	System.out.println(profit-invest);	
}
sc.close();
}
}