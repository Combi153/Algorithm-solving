package date1012_greedy_twopointers.no1339_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No1339 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        Map<Character, Integer> wordValues = new HashMap<>();
        String word;
        Character letter;
        int length;
        int order;
        Integer value;

        // 문자의 순서(자릿수)와 빈도를 value로 기록하기
        for (int i = 0; i < count; i++) {
            word = br.readLine();
            length = word.length();
            for (int j = 0; j < length; j++) {
                letter = word.charAt(j);
                order = length - j - 1;
                value = (int)(Math.pow(10, order));
                if (wordValues.containsKey(letter)) {
                    wordValues.put(letter, wordValues.get(letter) + value);
                } else{
                    wordValues.put(letter, value);
                }
            }
        }

        // value 기준 내림차순 정렬
        List<Map.Entry<Character, Integer>> entryList = new ArrayList<>(wordValues.entrySet());

        Collections.sort(entryList, new Comparator<Map.Entry<Character, Integer>>() {
           public int compare(Map.Entry<Character, Integer> obj1, Map.Entry<Character, Integer> obj2) {
               return obj2.getValue().compareTo(obj1.getValue());
           }
        });


        // 숫자 매칭시켜서 곱하기, 합산하기
        int sum = 0;
        int number = 9;

        for (Map.Entry<Character, Integer> entry : entryList) {
            sum += entry.getValue() * number;
            number--;
        }

        System.out.println(sum);
    }
}

