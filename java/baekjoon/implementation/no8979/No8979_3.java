package date1004_implementation.no8979;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Medal{

    int countryNo;
    int goldCnt;
    int silverCnt;
    int bronzeCnt;

    public Medal(int countryNo, int goldCnt, int silverCnt, int bronzeCnt) {
        this.countryNo = countryNo;
        this.goldCnt = goldCnt;
        this.silverCnt = silverCnt;
        this.bronzeCnt = bronzeCnt;
    }

    @Override
    public String toString() {
        return "[" + countryNo + " " + goldCnt + " " + silverCnt + " " + bronzeCnt + "]";
    }

    public int getCountryNo() {
        return countryNo;
    }

    public int getGoldCnt() {
        return goldCnt;
    }

    public int getSilverCnt() {
        return silverCnt;
    }

    public int getBronzeCnt() {
        return bronzeCnt;
    }

    public String getAllCnt(){
        return goldCnt + " " + silverCnt + " " + bronzeCnt;
    }
}

public class No8979_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int countryNo = sc.nextInt();
        int lank = 1;

        List<Medal> medalList = new ArrayList<>();

        for (int i = 0; i < n; i++){
            medalList.add(new Medal(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }
        medalList.sort(Comparator.comparing(Medal::getGoldCnt).thenComparing(Medal::getSilverCnt).thenComparing(Medal::getBronzeCnt).reversed());
        for (int i = 0; i < medalList.size(); i++) {
            if (medalList.get(i).getCountryNo() == (countryNo)){
                for (int j = i - 1; j > -1; j--) {
                    if (!medalList.get(i).getAllCnt().equals(medalList.get(j).getAllCnt())) {
                        lank = j + 2;
                        break;
                    }
                }
                break;
            }
        }
        System.out.println(lank);
        sc.close();
    }
}
