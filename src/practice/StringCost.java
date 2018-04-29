package practice;

import java.util.HashMap;
import java.util.Scanner;

public class StringCost {
	
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int t = sc.nextInt();
	HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>(); 
	
	while(t>0) {
		String str = sc.next();
		System.out.println(cost(str));
		
		t--;
	}
	sc.close();
	}
	static int cost(String str) {
		int cost = 0;
		for(int i=0;i<str.length();i++) {
			cost = cost+(int)('a'-str.charAt(i));
		}
		return cost;
	}
}
