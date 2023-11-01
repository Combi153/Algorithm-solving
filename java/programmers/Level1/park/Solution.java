package programmers.Level1.park;

class Solution {

    public static void main(String[] args) {
        int[] result = solution(new String[]{"OXXO", "XSXO", "XXXX"},
                new String[]{"E 1", "S 1"});

        System.out.println(result[0] + " " + result[1]);
    }

    public static int[] solution(String[] park, String[] routes) {
        // 1. 시작 지점 찾기
        // 2. routes 순회하며 경로 이동
        // - 공원을 벗어나는지 확인
        // - 장애물이 있는지 확인
        // 3. 좌표 찾기

        int x = park[0].length();
        int y = park.length;

        int startX = -1;
        int startY = -1;
        for (int i = 0; i < park.length; i++) {
            String parkLine = park[i];
            startX = parkLine.indexOf("S");
            startY = i;
            if (startX != -1) {
                break;
            }
        }

        for (int i = 0; i < routes.length; i++) {
            String route = routes[i];
            String[] routeFactors = route.split(" ");
            String direction = routeFactors[0];
            int num = Integer.parseInt(routeFactors[1]);

            if (direction.equals("E")) {
                if (startX + num >= x) {
                    continue;
                }
                String subPark = park[startY].substring(startX + 1, startX + num + 1);
                if (subPark.contains("X")) {
                    continue;
                }
                startX += num;
                continue;
            }

            if (direction.equals("W")) {
                if (startX - num < 0) {
                    continue;
                }
                String subPark = park[startY].substring(startX - num, startX);
                if (subPark.contains("X")) {
                    continue;
                }
                startX -= num;
            }

            if (direction.equals("S")) {
                if (startY + num >= y) {
                    continue;
                }
                boolean flag = false;
                for (int j = startY + 1; j <= startY + num; j++) {
                    String[] factors = park[j].split("");
                    if (factors[startX].equals("X")) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    continue;
                }
                startY += num;
            }

            if (direction.equals("N")) {
                if (startY - num < 0) {
                    continue;
                }
                boolean flag = false;
                for (int j = startY - 1; j >= startY - num; j--) {
                    String[] factors = park[j].split("");
                    if (factors[startX].equals("X")) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    continue;
                }
                startY -= num;
            }
        }

        return new int[]{startY, startX};
    }
}
