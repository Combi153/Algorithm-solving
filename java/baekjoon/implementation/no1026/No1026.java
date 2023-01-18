package implementation.no1026;

/*
길이가 N인 정수 배열 A와 B가 있다. n, 배열 A, 배열 B가 입력된다.
S = A[0] × B[0] + ... + A[N-1] × B[N-1] 라고 정의할 때
S의 최솟값을 출력하는 프로그램을 작성하라.
 */

import java.util.Arrays;
import java.util.Scanner;

public class No1026 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] aArray = new int[n];
        int[] bArray = new int[n];
        int result = 0;

        // A배열 입력 및 정렬
        for (int i = 0; i < n; i++) {
            aArray[i] = sc.nextInt();
        }
        Arrays.sort(aArray);

        // B 배열 입력 및 정렬
        for (int i = 0; i < n; i++) {
            bArray[i] = sc.nextInt();
        }
        Arrays.sort(bArray);

        // S = A 배열 오름차순 * B 배열 내림차순
        for (int i = 0; i < n; i++) {
            result += aArray[i] * bArray[n - i - 1];
        }
        System.out.println(result);
    }
}
