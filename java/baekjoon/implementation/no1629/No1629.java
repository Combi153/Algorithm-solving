package date1004_implementation.no1629;

import java.util.Scanner;

public class No1629 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int num = ((a % c) * b ) % c;
        System.out.println(num);
        //씨발
        /*
        int remainder = ((int)Math.pow(a, b)) % c;
        System.out.println((int)Math.pow(a,b));
        System.out.println(remainder);
         */

        //String num = String.valueOf(a * b);
        //int num2 = Integer.parseInt(num.substring(num.length()-2));
        //System.out.println(num2);
    }
}
