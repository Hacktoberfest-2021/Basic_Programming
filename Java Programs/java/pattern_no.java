package com.subarrypack;

import java.util.Scanner;

public class pattern_no {
    public static void main(String[] args) {
        System.out.println("enter a no");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=1;i<=n;i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print(i);
            }

            System.out.println();
        }
    }
}
