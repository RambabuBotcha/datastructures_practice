package test;

import java.util.Scanner;

public class Elevator {

	public static void main(String []args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0){
			int n = sc.nextInt();
			int p = sc.nextInt();
			int w = sc.nextInt();
			int wait[] = new int[n-1];
			for(int i=0;i<n-1;i++) {
				wait[i] = sc.nextInt();
			}
			int lift_p=0,lift_w=0;
			boolean overload = false;
			int cur_wait;
			for(int i=0;i<n-1;i++) {
				System.out.println("itr"+i);
				cur_wait=wait[i];
				int tar[] = new int[cur_wait];
				int wgt[] = new int[cur_wait];
				for(int j=0;j<cur_wait;j++) {
					tar[j]=sc.nextInt();
				}
				for(int j=0;j<cur_wait;j++) {
					wgt[j]=sc.nextInt();
					if((lift_p+1)<=p && (lift_w+wgt[j])<=w) {
						lift_p++;
						lift_w+=wgt[j];
					}else {
						overload = true;
						break;
					}
				}
				if(overload==true) {
					System.out.println(i+1);
					break;}
				System.out.println(lift_p+" "+lift_w);
				if(i>=0) {
					for(int j=0;j<wait[i];j++) {
						if(tar[j]==(i+2)) {
							lift_p--;
							lift_w-=wgt[j];
						}
					}
				}
				System.out.println(lift_p+" "+lift_w);
			}
			if(overload==false)
				System.out.println(n);
			t--;
		}
		sc.close();
	}

}
