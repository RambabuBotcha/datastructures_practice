package test;

import java.util.HashMap;
import java.util.Scanner;

public class Game {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0) {
			String s = sc.next();
			HashMap<Character,Integer> map = new HashMap<Character,Integer>();          
			for(int i = 0; i < s.length(); i++){
				char c = s.charAt(i);
				Integer val = map.get(c);
				if(val != null){
					map.put(c, new Integer(val + 1));
				}else{
					map.put(c,1);
				}
			}
			if(map.size()%2==0)
				System.out.println("Player2");
			else
				System.out.println("Player1");		
			t--;
		}
		sc.close();

	}
}
