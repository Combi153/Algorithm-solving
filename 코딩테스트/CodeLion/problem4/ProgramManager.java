package problem4;

import java.util.InputMismatchException;
import java.util.Scanner;
import formatexception.FormatException;

public class ProgramManager {
	
	private int key;
	String endMessage;
	String startMessage;
	Scanner sc = new Scanner(System.in);
	
	public ProgramManager() {
		startMessage = "1.전체리스트 2.등록 0.종료>";
		endMessage = "프로그램이 종료되었습니다.";
	}
	
	// start&print message
	public void printStartMessage() {
		System.out.println(startMessage);
	}
	
	// input
	public int getProgramKey() {
		
		try {
			this.key = sc.nextInt();
			sc.nextLine();
			checkKeyFormat(key);
		
		}catch (InputMismatchException e) {
			System.out.println("잘못된 키 입력입니다. 키를 확인해주세요.");
			printStartMessage();
			sc.nextLine();
			getProgramKey();
		}catch (FormatException e) {
			System.out.println(e.getMessage());
			printStartMessage();
			getProgramKey();
		}
		return key;
	}
	
	// end&print message
	public void printEndMessage() {
		sc.close();
		System.out.println(endMessage);
	}
	
	// getProgramKey -> ExceptionCheck
	public void checkKeyFormat(int key) throws FormatException {
		if((key < 0) || (key > 2)) {
			throw new FormatException("잘못된 키 입력입니다.");
		}
	}
}
