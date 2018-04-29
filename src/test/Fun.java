package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Fun {

	public static void main(String[] args) {

		Scanner scan=new Scanner(System.in);
		int test=scan.nextInt();


		for (int i = 0; i < test; i++) {
			int length=scan.nextInt();
			int[] arr=new int[length];
			for (int j = 0; j < length; j++) {
				arr[j]=scan.nextInt();
			}
			if (length % 2 == 0) {
				Op(arr, "EVEN");
			} else {
				Op(arr, "ODD");
			}
			System.out.println();
		}
		scan.close();
	}

	private static void Op(int[] arr, String val) {
		List<Integer> list = new ArrayList<>();
		int forPosint = 1, negIndex = -1, posIndex = 0;
		boolean once = true, twice = true;

		if (val.equals("EVEN")) {
			int sum = arr[(arr.length / 2)] + arr[(arr.length / 2) - 1];
			for (int i = 0; i < arr.length; i++) {
				list.add(arr[i]);

				if (list.get(i) < 0 && once) {
					negIndex=i;
					once = false;
				}

				if (list.get(i) > 0 && forPosint == 0 && twice) {
					posIndex=i;
					twice = false;
				} else if (list.get(i) > 0)
					forPosint--;

				if (arr[i] == 0) {
					list.add(sum);
				}

			}
		} else if (val.equals("ODD")) {

			int mid = arr[(arr.length / 2)];
			for (int i = 0; i < arr.length; i++) {
				list.add(arr[i]);

				if (list.get(i) < 0 && once) {
					negIndex=i;
					once = false;
				}
				if (list.get(i) > 0 && forPosint == 0 && twice) {
					posIndex=i;
					twice = false;
				} else if (list.get(i) > 0)
					forPosint--;

				if (arr[i] == 0) {
					list.add(mid);	
				}
			}
		} 

		if(!once) list.remove(negIndex);

		if(!twice) list.remove(posIndex);

		System.out.print(list.toString().replaceAll(",", "").replaceAll("\\[", "").replaceAll("\\]", ""));

	}

}