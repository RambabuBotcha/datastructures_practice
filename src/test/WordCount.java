package test;

import java.util.HashMap;
import java.util.Scanner;

public class WordCount {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		Integer sl = sc.nextInt();
		Integer pl= sc.nextInt();
		String s = sc.next();
		String p = sc.next();
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();          
		for(int i = 0; i < sl; i++){
			char c = s.charAt(i);
			Integer val = map.get(c);
			if(val != null){
				map.put(c, new Integer(val + 1));
			}else{
				map.put(c,1);
			}
		}
		HashMap<Character,Integer> map1 = new HashMap<Character,Integer>();          
		for(int i = 0; i < pl; i++){
			char c = p.charAt(i);
			Integer val = map1.get(c);
			if(val != null){
				map1.put(c, new Integer(val + 1));
			}else{
				map1.put(c,1);
			}
		}
		int temp, min=0;
		if(map1.get(p.charAt(0))>0) {
			min = map.get(p.charAt(0))/map1.get(p.charAt(0));
		}
		for(int i=1;i<p.length();i++) {
			temp=0;
			if(map1.get(p.charAt(i))>0) {
				temp = map.get(p.charAt(i))/map1.get(p.charAt(i));
			}
			if(min>temp)
				min=temp;
		}
		System.out.println(min);
		sc.close();
	}
}
