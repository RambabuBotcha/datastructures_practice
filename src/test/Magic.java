package test;

import java.util.Scanner;

public class Magic {
	public static void main(String args[] ) throws Exception {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t != 0) {
			int num = sc.nextInt();
			if(num==1) {
				System.out.println(num);
				continue;
			}
			double n =(double)num;
			int con =(int)Math.sqrt(n);
			int sum =1,temp=0;
			for(int i=2;i<=con;i++) {
				if(num%i==0) {
					if(i%2==1)
						sum = sum+i;
					temp = num/i;
					if(temp%2==1 && temp>i)
						sum = sum+temp;
				}
			}
			if(num%2==1) {
				sum = sum+num;
			}
			System.out.println(sum);
			t--;
		}
		sc.close();
	}
}
//3 1 10.0 10