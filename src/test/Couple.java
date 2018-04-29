package test;

import java.util.Scanner;

public class Couple {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0) {
			int a = sc.nextInt();
			int b =sc.nextInt();
			System.out.println(primeFactors(a*b/GCF(a,b)));
			int result = primeFactors(a*b/GCF(a,b));
			prime(result);
			t--;
		}
		sc.close();
	}
	public static int GCF(int a, int b) {
		if (b == 0) return a;
		else return (GCF (b, a % b));
	}

	public static int primeFactors(int n)
	{
		int count=0;
		while (n%2==0)
		{
			if(count==0) count++;
			n /= 2;
		}
		int count1;
		for (int i = 3; i <= Math.sqrt(n); i+= 2)
		{
			count1=0;
			while (n%i == 0)
			{
				count1++;
				n /= i;
			}
			if(count1>0) count++;
		}
		if (n > 2) {
			count++;
		}
		return count;
	}

	public static void prime(int num)
	{
		if(num<2) {
			System.out.print("No");
			return;
		}
		int count=0;
		double n =(double)num;
		int con = (int)Math.sqrt(n);
		for(int i=2; i<=con; i++)
		{
			if(num%i == 0)
			{
				count++;
				break;
			}
		}
		if(count == 0)
		{
			System.out.print("Yes");
		}
		else
		{
			System.out.print("No");
		}
	}
}
