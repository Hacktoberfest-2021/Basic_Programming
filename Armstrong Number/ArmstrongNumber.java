package com.practice.math;

import java.util.Scanner;

public class ArmstrongNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Number: ");
		int n;
		n = sc.nextInt();
		try {
		int num = n;
		int sum = 0;
		while (num != 0) {
			int r = num % 10;
			sum += (r * r * r);
			num = num / 10;
		}
		if (sum == n) {
			System.out.println(n + " is an armstrong number");
		} else {
			System.out.println(n + " is not an armstrong number");
		}
		}
		catch (Exception e) {
			System.out.println("Error while checking armstrong number "+e.getMessage());
		}
		finally {	
			sc.close();
		}
	}
}
