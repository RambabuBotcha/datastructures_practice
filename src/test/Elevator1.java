package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Body{
	public int tf;
	public int w;
	public Body() {}
	public Body(int tf,int w) {
		this.tf=tf;
		this.w=w;
	}
}
public class Elevator1 {
	public static void main(String []args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0){
			boolean overload = false;	
			int n = sc.nextInt();
			int p = sc.nextInt();
			int w = sc.nextInt();
			int wait[] = new int[n-1];
			List<Body> lift = new ArrayList<Body>();
			for(int i=0;i<n-1;i++) {
				wait[i] = sc.nextInt();
			}
			int cur_wl;
			int lift_wgt=0;
			//int size=0;
			for(int i=0;i<n-1;i++) {
				System.out.println("Iteration"+i);
				if(i>0) {
					//	size = lift.size();
					for(int j=0;j<lift.size();) {
						if(lift.get(j).tf==i+1) {
							lift_wgt-=lift.get(j).w;
							lift.remove(j);
						} else
							j++;
					}
				}
				System.out.println(lift.size()+" "+lift_wgt);
				cur_wl = wait[i];
				List<Body> list = new ArrayList<Body>();
				for(int j=0;j<cur_wl;j++) {
					Body b = new Body();
					b.tf = sc.nextInt();
					list.add(b);
				}
				for(int j=0;j<cur_wl;j++) {
					list.get(j).w = sc.nextInt();
					if((lift.size()+1)<=p && (lift_wgt+list.get(j).w)<=w) {
						lift.add(list.get(j));
						lift_wgt+=list.get(j).w;
					}else {
						overload = true;
						break;
					}
				}
				if(overload==true) {
					System.out.println(i+1);
					break;}
				System.out.println(lift.size()+" "+lift_wgt);
			}
			if(overload==false)
				System.out.println(n);
			t--;
		}
		sc.close();
	}	
}
