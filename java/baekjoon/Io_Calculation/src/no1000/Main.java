package no1000;

import java.util.Scanner;

public class Main {

	int a;
	int b;
	Scanner sc = new Scanner(System.in);
	
	public Main() {}
	
	public void getAB() {
		a = sc.nextInt();
		b = sc.nextInt();
	}
	
	public static void main(String[] args) {
		
		Main ab1 = new Main();
		ab1.getAB();
		System.out.println(ab1.a + ab1.b);
	}
}
