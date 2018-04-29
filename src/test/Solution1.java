package test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Order1 {
	public Order1(String args[]) {
		this.id=Long.parseLong(args[1]);
		try {

		this.id=Long.parseLong(args[1]);

		this.tsp=Long.parseLong(args[2]);

		this.sbl=args[3].trim();

		this.ot=args[4].trim();

		this.side=args[5].trim();

		this.price=Float.parseFloat(args[6]);

		this.qt=Long.parseLong(args[7]);
		}
		catch(Exception e) {
			this.isValid=false;
		}
		

	}
	public boolean isValid() {
		if( !(ot.equals("M") || ot.equals("L") || ot.equals("I"))) {
			this.isValid=false;
		}
		if(!(side.equals("B") || side.equals("S") )) {
			this.isValid=false;
		}
		if(qt%1>0.0) {
			this.isValid=false;
		}
		return this.isValid;
		
	}
	
	public boolean isValidAmend(Order1 order) {
		return this.id==order.getOrderId() && this.tsp==order.getTimeStamp() && this.sbl.equals(order.getSymbol()) && this.ot.equals(order.getOrderType()) && this.side.equals(order.getSide());
		
	}
	private boolean isValid =true;
	
	public long getOrderId() {
		return id;
	}
	public void setOrderId(long orderId) {
		this.id = orderId;
	}
	public long getTimeStamp() {
		return tsp;
	}
	public void setTimeStamp(long timeStamp) {
		this.tsp = timeStamp;
	}
	public String getSymbol() {
		return sbl;
	}
	public void setSymbol(String symbol) {
		this.sbl = symbol;
	}
	public String getOrderType() {
		return ot;
	}

	public String getSide() {
		return side;
	}

	public float getPrice() {
		return price;
	}

	public long getQuantity() {
		return qt;
	}

	private long id;

	private long tsp;

	private String sbl;

	private String ot;

	private String side;

	private float price;

	private long qt;
}

public class Solution1 {
	static String hypen=" - ";
    static String[] processQueries(String[] queries) {
    	List<Order> obook=new LinkedList<Order>();
    	List<Long> oId=new LinkedList<Long>();
    	Map<Long,Order1> orderIdMap=new HashMap<Long,Order1>();
        long latestTime=0;
        String operation;
        String command[];
        Order1 order;
    	List<String> response = new ArrayList<String>();
    	int len=queries.length;
    	for(int i=0;i<len;i++) {
			 command = queries[i].split(",");
			operation = command[0];
			switch (operation) {
			case "N":
				order=new Order1(command);
				if(order.isValid() && order.getTimeStamp()>=latestTime && !oId.contains(order.getOrderId())) {
					latestTime=order.getTimeStamp();
					obook.addAll((Collection<? extends Order>) order);
					oId.add(order.getOrderId());
					orderIdMap.put(order.getOrderId(), order);
					response.add(order.getOrderId()+" - Accept");
				}
				else {
					response.add(order.getOrderId()+" - Reject - 303 - Invalid order details");
					
				}
				break;
			case "A":
				order=new Order1(command);
				//System.out.println(order);
				if(!oId.contains(order.getOrderId())) {
					response.add(order.getOrderId()+" - AmendReject - 404 - Order does not exist");
				}
				else {
					Order1 o=orderIdMap.get(order.getOrderId());
					if(!o.isValidAmend(order)) {
						response.add(order.getOrderId()+" - AmendReject - 101 - Invalid amendment details");
					}
					else {
						response.add(order.getOrderId()+" - AmendAccept");
						
					}
					
				}
				
				break;
			default:
				response.add(command[1]+" - Reject - 303 - Invalid order details");
			}}
    	
    	
    	String[] responseArray = response.toArray(new String[0]);
    	return responseArray;
    }


    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

        int queriesSize = Integer.parseInt(scan.nextLine().trim());

        String[] queries = new String[queriesSize];

        for (int queriesItr = 0; queriesItr < queriesSize; queriesItr++) {
            String queriesItem = scan.nextLine();
            queries[queriesItr] = queriesItem;

        }

        String[] response = processQueries(queries);

        for (int responseItr = 0; responseItr < response.length; responseItr++) {
            bw.write(response[responseItr]);

            if (responseItr != response.length - 1) {
                bw.write("\n");
            }
        }

        bw.newLine();

        bw.close();
    }
}