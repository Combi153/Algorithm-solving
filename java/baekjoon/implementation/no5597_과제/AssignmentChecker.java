package implementation.no5597_과제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class AssignmentChecker {

    private static final int OMITTED_STUDENT_NUMBER = 2;
    private final BufferedReader bufferedReader;
    private final List<Integer> students;

    public AssignmentChecker(BufferedReader bufferedReader, List<Integer> students) {
        this.bufferedReader = bufferedReader;
        this.students = students;
    }

    public void printOmittedStudent() throws IOException {
        List<Integer> omittedStudents = checkOmittedStudent();
        for (Integer omittedStudent : omittedStudents) {
            System.out.println(omittedStudent);
        }
    }

    private List<Integer> checkOmittedStudent() throws IOException {
        List<Integer> omittedStudents = copy();
        for (int i = 0; i < students.size() - OMITTED_STUDENT_NUMBER; i++) {
            omittedStudents.remove(readSubmitter());
        }
        return omittedStudents;
    }

    private List<Integer> copy() {
        return new ArrayList<>(students);
    }

    private Integer readSubmitter() throws IOException {
        String submitterNumber = bufferedReader.readLine();
        return Integer.valueOf(submitterNumber);
    }

    public static void main(String[] args) throws IOException {
        List<Integer> students = new ArrayList<>();
        IntStream.rangeClosed(1, 30).forEach(students::add);
        AssignmentChecker assignmentChecker = new AssignmentChecker(new BufferedReader(new InputStreamReader(System.in)), students);
        assignmentChecker.printOmittedStudent();
    }
}
