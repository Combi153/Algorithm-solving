package date1004_implementation.no1966;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/*
*  자신보다 중요도 한 단계 높은 녀석의 마지막 인덱스 찾기
*  내 앞 중요도 마지막 인덱스 + 1 + A
* */

public class No1966_2 {

    static int getPaperOrder(int numberOfPapers, int thePaperIdx, List<Integer> papers) {
        Set<Integer> treeSet = new TreeSet<>(papers);
        List<Integer> importances = new ArrayList<>(treeSet); //오름차순
        int thePaperImportance = papers.get(thePaperIdx);
        int lastImportanceIdx = numberOfPapers - 1;
        int order = 0;

        for (int i = importances.size() - 1; i > -1; i--) {
            if (thePaperImportance == importances.get(i)){
                for (int j = lastImportanceIdx + 1; j < numberOfPapers; j++) {
                    if (papers.get(j) == importances.get(i)) {
                        order++;
                        if (j == thePaperIdx) {
                            return order;
                        }
                    }
                }

                for (int j = 0; j < lastImportanceIdx; j++) {
                    if (papers.get(j) == importances.get(i)){
                        order++;
                        if (j == thePaperIdx) {
                            return order;
                        }
                    }
                }

                return ++order;
            } else{
                order += Collections.frequency(papers, importances.get(i));
                boolean temp = true;
                for (int j = lastImportanceIdx; j > -1; j--) {
                    if (importances.get(i) == papers.get(j)) {
                        lastImportanceIdx = j;
                        temp = false;
                        break;
                    }
                }
                if (temp){
                    for (int j = numberOfPapers - 1; j > lastImportanceIdx + 1; j--){
                        if (importances.get(i) == papers.get(j)) {
                            lastImportanceIdx = j;
                            break;
                        }
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCaseNum = Integer.parseInt(br.readLine());

        List<Integer> numberOfPapersAndPaperIndex;
        List<Integer> papers;

        for (int i = 0; i < testCaseNum; i++) {

            numberOfPapersAndPaperIndex = Arrays.stream(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray()).boxed().collect(Collectors.toList());
            papers = Arrays.stream(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray()).boxed().collect(Collectors.toList());

            System.out.println(getPaperOrder(numberOfPapersAndPaperIndex.get(0), numberOfPapersAndPaperIndex.get(1), papers));
        }
    }
}
