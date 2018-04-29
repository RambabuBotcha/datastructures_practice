package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	static Long ltsp=(long) 0;
	static String[] processQueries(String[] queries) {
		List<Order> list = new ArrayList<Order>();
		int len = queries.length;
		String[] output= new String[len];
		for(int i=0;i<len;i++) {
			String cmd[] = queries[i].split(",");
			String in = cmd[0];
			switch (in) {
			case "N":
				if(Solution.ltsp<=Long.parseLong(cmd[2])) {
					output[i]=Solution.createOrder(list, cmd);
				} else {
					output[i]=cmd[1]+" - Reject - 303 - Invalid order details"; 
				}
				break;
			case "A":
				if(Solution.ltsp<=Long.parseLong(cmd[2])) {
					output[i]=Solution.amendOrder(list, cmd); 
				} else {
					output[i]=cmd[1]+" - AmendReject - 101 - Invalid amendment details"; 
				}   
				break;
			case "X":
				if(Solution.ltsp<=Long.parseLong(cmd[2])) {
					output[i]=Solution.cancelOrder(list, cmd); 
				} else {
					output[i]=cmd[1]+" - Cancel - 101 - Invalid amendment details"; 
				}
				break;
			case "M":
				output[i]="Match";     
				// System.out.println("Match");
				break;
			case "Q":
				output[i]="Query";     
				// System.out.println("Query");
				break;
			default:
				output[i]=cmd[1]+" - Reject - 303 - Invalid order details";     
				// System.out.println(cmd[1]+" - Reject - 303 - Invalid order details");
			}

		}
		return output;
	}
	//-----------------------------CREATE-----------------------------------
	static String createOrder(List<Order> list,String[] cmd) { 	
		String out;
		try {
			Order order = new Order(cmd);
			boolean hit = false;
			for(Order o:list) {
				if(o.check(order)) {
					hit=true;
					break;
				}
			}
			if(hit==false) {
				list.add(order);
				out=order.getId()+" - Accept";
				Solution.ltsp=order.getTsp();
			} else {
				out = cmd[1]+" - Reject - 303 - Invalid order details";
			}
		}
		catch (Exception e)
		{
			out = cmd[1]+" - Reject - 303 - Invalid order details";
		}  
		return out;
	}
	//---------------------------------AMEND-------------------------------------------
	static String amendOrder(List<Order> list, String[] cmd) {
		String out=cmd[1]+" - AmendReject - 404 - Order does not exist";
		Order order = new Order(cmd);
		for(Order o:list) {
			if(o.check(order)) {
				if(o.validate(order)) {
					if(o.getPrice()!=order.getPrice()) {
						o.setPrice(order.getPrice());
						o.setTsp(order.getTsp());
					}
					if(o.getQt()!=order.getQt()) {
						o.setQt(order.getQt());
					}
					Solution.ltsp=order.getTsp();
					out = cmd[1]+" - AmendAccept";
					break;
				} else {
					out = cmd[1]+" - AmendReject - 101 - Invalid amendment details";
					break;
				}
			}
		}
		return out;
            
        }
	
	
	//------------------------------CANCEL----------------------------------------------------
	static String cancelOrder(List<Order> list, String[] cmd) {
		String out=cmd[1]+" – CancelReject - 404 - Order does not exist";
		Long id = Long.parseLong(cmd[1]);
		Long tsp = Long.parseLong(cmd[2]);
		for(Order o : list) {
			if(o.getId()==id) {
				list.remove(o);
				out =cmd[1]+" - CancelAccept";
				Solution.ltsp=tsp;
				break;
			}
		}
		return out;
	}
	
	//------------------------------MATCH----------------------------------------------------
	/**********
	 * 
	 * 		//s1: Group all orders by symbol
		
		//s2: iterate every grouped object for top buyers getTopBuyer
		// then send buyer and group from getMatchingSeller 
	 * 
	 * @param list
	 * @return
	 */
	
	static String macthOrders(List<Order> list) {
		return "";
	}
	
	static String getTopBuyer(List<Order> list, String[] cmd) {
		
		return "";
	}
	
	static String getMatchingSeller(List<Order> list, String[] cmd) {
	
	
	return "";
	}

	
	//------------------------------QUERY----------------------------------------------------
	static String queryFromMatchBook(List<Order> list, String[] cmd) {
		String out=cmd[1]+" – CancelReject - 404 - Order does not exist";
		Long id = Long.parseLong(cmd[1]);
		Long tsp = Long.parseLong(cmd[2]);
		for(Order o : list) {
			if(o.getId()==id) {
				list.remove(o);
				out =cmd[1]+" - CancelAccept";
				Solution.ltsp=tsp;
				break;
			}
		}
		return out;
	}
		
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		int queriesSize = Integer.parseInt(scan.nextLine().trim());

		String[] queries = new String[queriesSize];

		for (int queriesItr = 0; queriesItr < queriesSize; queriesItr++) {
			String queriesItem = scan.nextLine();
			queries[queriesItr] = queriesItem;
		}
		String output[] = processQueries(queries);
		for(String s:output) {
			System.out.println(s);
		}
		scan.close();
	}
}