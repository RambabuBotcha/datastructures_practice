package test;

import java.util.Scanner;

public class Stock2 {
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
			int pro = 0, count=-1;
			int n = sc.nextInt();
			int array[] = new int[n];
			for(int j=0;j<n;j++) {
				array[j] = sc.nextInt();
				if(array[j]>0 && count==-1)
					count=j;
			}
			if(count==-1){
			    System.out.println(0);	
			} else {
			int max_pro=0;
			max_pro=pro=array[count];
			for(int m=count+1;m<n;m++) {
	    			if(max_pro<pro)
	    				max_pro=pro;
	    			pro+=array[m];
	    			if(pro<0)
	    				pro=0;
			    }
			if(max_pro<pro)
				max_pro=pro;
			System.out.println(max_pro);	
	        }
		sc.close();
		}
}
