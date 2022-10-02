package no1924;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int month = sc.nextInt();
        int day = sc.nextInt();
        String[] daysOfWeek = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

        HashMap<Integer, Integer> calender = new HashMap<Integer, Integer>();

        calender.put(1,31);
        calender.put(2,28);
        calender.put(3,31);
        calender.put(4,30);
        calender.put(5,31);
        calender.put(6,30);
        calender.put(7,31);
        calender.put(8,31);
        calender.put(9,30);
        calender.put(10,31);
        calender.put(11,30);
        calender.put(12,31);

        for (int i = month - 1; i > 0; i--) {
            day += calender.get(i);
        }
        System.out.println(daysOfWeek[day % 7]);
    }
}