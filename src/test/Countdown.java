package test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Countdown {
	public static <E> void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int time = Integer.parseInt(args[0]);
		Queue<Integer> queue = new LinkedList<Integer>();

		for (int i = time; i >= 0; i--)
			queue.add(i);
		System.out.println(queue.element());
		while (!queue.isEmpty()) {
			System.out.println(queue.poll());
			Thread.sleep(1000);
		}
		Integer i=0;
		if(i instanceof Integer)

			//        Collection<Integer> c = new ArrayList<Integer>();
		//        for(int i=10;i>0;i--)
			//     	   c.add(i);
			//        List <Integer>list = Countdown.heapSort(c);
			//        for(Integer j :list)
			//        	System.out.println(j);
			sc.close();
	}
	static <E> List<E> heapSort(Collection<E> c) {
		Queue<E> queue = new PriorityQueue<E>(c);
		List<E> result = new ArrayList<E>();

		while (!queue.isEmpty())
			result.add(queue.remove());

		return result;
	}
}
