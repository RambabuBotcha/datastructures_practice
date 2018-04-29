package test;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers	{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int left=1,right=200;
		
		System.out.println(selfDividingNumbers(left,right));
			
	}

	private static List<Integer> selfDividingNumbers(int left, int right) {
		
		List<Integer> list=new ArrayList<>();
		for(int i=left;i<=right;i++) {
						
			/*if(i<10) list.add(i);
			else if(i>10 &&i<100) {
				if(checkSDN(i,2)) list.add(i);
			}
			else if(i>100 &&i<1000) {
				if(checkSDN(i,3)) list.add(i);
			}
			else if(i>1000 &&i<10000) {
				if(checkSDN(i,4)) list.add(i);
			}*/
			
			if(checkSDN(i,0)) list.add(i);
			
		}
		
		return list;
		// TODO Auto-generated method stub
		
	}

	private static boolean checkSDN(int num, int noOfNum) {
		// TODO Auto-generated method stub
		/*int temp=num;
		for (int i = 0; i < noOfNum; i++) {
			int div=temp%10;
			if(div!=0&&num%div==0) temp=temp/10;
			else return false;
		}*/
		
		for(char c:String.valueOf(num).toCharArray()) {
			
			if(c=='0' || num%(c-'0') >0) return false;
		}
		
		return true;
	}

}
