package test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import test.Order.OT;
import test.Order.Side;

class TC implements Comparator {
	@Override
	public int compare(Object o1, Object o2) {
		Order s1=(Order)o1;  
		Order s2=(Order)o2;  
		  
		if(s1.tsp==s2.tsp)  
		return 0;  
		else if(s1.tsp>s2.tsp)  
		return 1;  
		else  
		return -1;  
	}
	
}

public class Rough {
	public static void run(String queries[]) throws Exception{
		List<Order> orders = new ArrayList<Order>();
		int len = queries.length;
		for(int i=0;i<len;i++) {
			String cmd[] = queries[i].split(",");
			Order ord = new Order(cmd);
			orders.add(ord);
			}
		Map<OT, Map<Side, Map<String, List<Order>>>> map = orders.stream().collect(Collectors.groupingBy(Order::getOt,Collectors.groupingBy(Order::getSide,Collectors.groupingBy(Order::getSbl))));
		OT otm = OT.valueOf("M");
		OT otl = OT.valueOf("L");
		OT oti = OT.valueOf("I");
		Side side = Side.valueOf("B");
		Order topBuyer;
		int size1 = 0,size2=0,size3=0;
		try {
		size1 = map.get(otm).get(side).get("A").size();
		}catch(Exception ex){
			size1 =0;
		}
		if(size1!=0) {
			List<Order> list1 = map.get(otm).get(side).get("A");
		    topBuyer = list1.get(0);
		} else{
			try {
			List<Order> list1 = map.get(otl).get(side).get("A");
			size2=list1.size();
			List<Order> list2 = map.get(oti).get(side).get("A");
			if(list2.size()!=0) {
				list1.addAll(list2);
			}
			list1.sort(new TC());
			topBuyer = list1.get(0);
			System.out.println(topBuyer);
			}catch(Exception ex) {
				System.out.println(ex.getStackTrace());
			}
		}
		return;
	}
	
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		int queriesSize = Integer.parseInt(scan.nextLine().trim());

		String[] queries = new String[queriesSize];

		for (int queriesItr = 0; queriesItr < queriesSize; queriesItr++) {
			String queriesItem = scan.nextLine();
			queries[queriesItr] = queriesItem;
		}
		run(queries);
//		for(String s:output) {
//			System.out.println(s);
//		}
		scan.close();
	}
	
}
