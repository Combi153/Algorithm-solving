package date1012_greedy_twopointers.no1931_h;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Meeting {
    private int start;
    private int end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}

public class No1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        List<Meeting> meetings = new ArrayList<>();


        for (int i = 0; i < length; i++) {
            String[] meetingTime = br.readLine().split(" ");
            meetings.add(new Meeting(Integer.parseInt(meetingTime[0]), Integer.parseInt(meetingTime[1])));
        }

        meetings.sort(Comparator.comparing(Meeting::getEnd).thenComparing(Meeting::getStart));
        for (Meeting meeting : meetings) {
            System.out.println(meeting);
        }

        System.out.println("====================================");
        int lastEnd = meetings.get(0).getEnd();
        System.out.println(meetings.get(0));
        int cnt = 1;
        for (int i = 1; i < meetings.size(); i++) {
            Meeting meeting = meetings.get(i);

            if (lastEnd <= meeting.getStart()) {
                System.out.println(meeting);
                lastEnd = meeting.getEnd();
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}