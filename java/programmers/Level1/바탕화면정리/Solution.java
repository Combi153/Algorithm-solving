package programmers.Level1.바탕화면정리;

public class Solution {
    public int[] solution(String[] wallpaper) {
        int lux = wallpaper[0].length();
        int luy = wallpaper.length;
        int rdx = -1;
        int rdy = -1;
        String file = "#";

        for (int i = 0; i < wallpaper.length; i++) {
            String m = wallpaper[i];

            int fx = m.indexOf(file);
            int fy = m.lastIndexOf(file);

            if (fx == -1) {
                continue;
            }

            if (fx < lux) {
                lux = fx;
            }

            if (fy + 1 > rdx) {
                rdx = fy + 1;
            }

            if (i < luy) {
                luy = i;
            }

            if (i + 1 > rdy) {
                rdy = i + 1;
            }
        }

        return new int[]{luy, lux, rdy, rdx};
    }
}
