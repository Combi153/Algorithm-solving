package no10773;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] stack = new int[n];
        int pointer = 0;
        int cnt = 0;
        int total = 0;
        int value;

        while (cnt < n) {

            value = sc.nextInt();
            cnt++;
            if (value != 0) {
                stack[pointer] = value;
                pointer++;
            } else{
                pointer--;
                stack[pointer] = 0;
            }
        }

        for (int i = 0; i < stack.length; i++) {

            if (stack[i] == 0){
                break;
            } else{
                total += stack[i];
            }
        }
        System.out.println(total);

    }
}