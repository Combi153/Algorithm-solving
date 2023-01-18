package implementation.no2108;

import java.util.*;

public class No2108 {
    public static void main(String[] args) {
        HashMap<Integer, Integer> cntHash = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int key;
        int value;
        double summation = 0;
        int middle = (n + 1) / 2;
        int median = 0;
        int cnt = 0;

        //TreeMap 으로 입력
        for (int i = 0; i < n; i++) {
            value = 1;
            key = sc.nextInt();
            summation += key;
            if (cntHash.containsKey(key)) {
                value += cntHash.get(key);
                cntHash.replace(key, value);
            } else{
                cntHash.put(key, value);
            }
        }

        Object[] mapKey = cntHash.keySet().toArray();
        Arrays.sort(mapKey);

        for (int i = 0; i < n; i++) {
            cnt += cntHash.get(mapKey[i]);
            if (cnt > middle) {
                median = (int) mapKey[i - 1];
                break;
            }
        }

/*
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<Map.Entry<Integer, Integer>>(cntHash.entrySet());

        Collections.sort(entryList, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Entry<Integer, Integer> obj1, Entry<Integer, Integer> obj2) {
               return obj1.getValue().compareTo(obj2.getValue());
           }
        });
*/
        System.out.println(cntHash);
        System.out.println(Arrays.toString(mapKey));
        //산술평균
        System.out.println("산술평균 : " + Math.round(summation / n));
        //중앙값
        System.out.println("중앙값 : " + median);
        //최빈값

        //범위
        System.out.println("범위 : " + ((int)mapKey[n - 1] - (int)mapKey[0]));
    }
}
