package implementation.no2108;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class No2108_2 {
    public static void main(String[] args) throws IOException {
        HashMap<Integer, Integer> cntMap = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int key;
        int cnt = 0;

        double summation = 0;
        int middle = (n + 1) / 2;
        int median = 0;

        for (int i = 0; i < n; i++) {
            key = Integer.parseInt(br.readLine());
            summation += key;
            if (cntMap.containsKey(key)) {
                cntMap.put(key, cntMap.get(key) + 1);
            } else{
                cntMap.put(key, 1);
            }
        }

        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<Map.Entry<Integer, Integer>>(cntMap.entrySet());

        Collections.sort(entryList, new Comparator<Map.Entry<Integer, Integer>>() {

            public int compare(Map.Entry<Integer, Integer> obj1, Map.Entry<Integer, Integer> obj2) {
                return obj1.getValue().compareTo(obj2.getValue());
            }
        });

        int maxModeValue = entryList.get(entryList.size() - 1).getValue();
        List<Integer> maxModeKeyList = new ArrayList<>();
        maxModeKeyList.add(entryList.get(entryList.size() - 1).getKey());

        for (int i = entryList.size() - 2; i > -1; i--){
            if (maxModeValue == entryList.get(i).getValue()){
                maxModeKeyList.add(entryList.get(i).getKey());
            } else{
                break;
            }
        }

        List<Integer> keyList = new ArrayList<>(cntMap.keySet());
        keyList.sort(Comparator.naturalOrder());

        for (int i = 0; i < n; i++) {
            cnt += cntMap.get(keyList.get(i));
            if (cnt >= middle) {
                median = keyList.get(i);
                break;
            }
        }

        //산술평균
        System.out.println(Math.round(summation / n));
        //중앙값
        System.out.println(median);
        //최빈값
        if (maxModeKeyList.size() > 1){
            maxModeKeyList.sort(Comparator.naturalOrder());
            System.out.println(maxModeKeyList.get(1));
        } else{
            System.out.println(maxModeKeyList.get(0));
        }
        //범위
        System.out.println(keyList.get(keyList.size() - 1) - keyList.get(0));
    }
}
