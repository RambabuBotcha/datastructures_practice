package practice;

import java.util.*;
public class HashMapDemo
{
   public static void main(String args[])
   {
       HashMap< String,Integer> hm = 
                            new HashMap< String,Integer>();
       hm.put("a", new Integer(100));
       hm.put("b", new Integer(200));
       hm.put("c", new Integer(300));
       hm.put("d", new Integer(400));
 
       // Returns Set view     
       Set< Map.Entry< String,Integer> > st = hm.entrySet();   
 
       for (Map.Entry< String,Integer> me:st)
       {
           System.out.print(me.getKey()+":");
           System.out.println(me.getValue());
       }
       System.out.println("======================");
       hm.keySet().remove("a");
       for(String k : hm.keySet())
    	   System.out.println(k);
       System.out.println("======================");
       for(Integer k : hm.values())
    	   System.out.println(k);
       for(int i=0;i<10;++i)
    	   System.out.println(i);
       
   }
}
