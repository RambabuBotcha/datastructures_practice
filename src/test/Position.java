package test;

import java.util.Scanner;

public class Position {

    public static void main(String[] args) {
	
    Scanner scan= new Scanner(System.in);
    int n=scan.nextInt();
    
    int LB=n- Integer.highestOneBit(n);
    int LO=2*LB+1;
    
    System.out.print(LO);
  }
}
