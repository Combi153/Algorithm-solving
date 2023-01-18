package implementation.no1966;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/*
*  자신보다 중요도 한 단계 높은 녀석의 마지막 인덱스 찾기
*  내 앞 중요도 마지막 인덱스 + 1 + A
* */

public class No1966 {

    static int getPaperOrder(int numberOfPapers, int paperIndex, List<Integer> importanceOfPapers) {
        Set<Integer> treeSet = new TreeSet<>(importanceOfPapers);
        List<Integer> importances = new ArrayList<>(treeSet);

        int importanceOfThePaper = importanceOfPapers.get(paperIndex);
        int order = 1;

        if (importances.size() <= 1) { //중요도의 개수가 1이하일 때
            return paperIndex + order;
        } else if(importanceOfThePaper == Collections.max(importances)){ //순서를 찾고자 하는 문서의 중요도가 제일 높은 중요도일 때
            for (int i = 0; i < paperIndex; i++) {
                if (importanceOfPapers.get(i) == importanceOfThePaper) {
                    order += 1;
                }
            }
            return order;

        } else{
            int nextImportance = importances.get(importances.indexOf(importanceOfThePaper) + 1);

            int lastNextImportanceIdx = importanceOfPapers.lastIndexOf(nextImportance);


            // 앞선 중요도의 개수 세기
            for (int i = importances.size() - 1; i > importances.indexOf(importanceOfThePaper); i--) {
                order += Collections.frequency(importanceOfPapers, importances.get(i));
            }

            // 하나 앞선 중요도의 마지먹 인덱스를 기준으로 내 중요도의 개수 세기
            if (lastNextImportanceIdx < paperIndex){
                for (int i = lastNextImportanceIdx + 1; i < paperIndex; i++) {
                    if (importanceOfPapers.get(i) == importanceOfThePaper) {
                        order += 1;
                    }
                }
            } else{
                for (int i = 0; i < paperIndex; i++) {
                    if (importanceOfPapers.get(i) == importanceOfThePaper) {
                        order += 1;
                    }
                }
                for (int i = lastNextImportanceIdx + 1; i < importanceOfPapers.size(); i++) {
                    if (importanceOfPapers.get(i) == importanceOfThePaper) {
                        order += 1;
                    }
                }
            }

            return order;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCaseNum = Integer.parseInt(br.readLine());

        List<Integer> numberOfPapersAndPaperIndex;
        List<Integer> importanceOfPapers;

        for (int i = 0; i < testCaseNum; i++) {

            numberOfPapersAndPaperIndex = Arrays.stream(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray()).boxed().collect(Collectors.toList());
            importanceOfPapers = Arrays.stream(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray()).boxed().collect(Collectors.toList());

            System.out.println(getPaperOrder(numberOfPapersAndPaperIndex.get(0), numberOfPapersAndPaperIndex.get(1), importanceOfPapers));
        }
    }
}
