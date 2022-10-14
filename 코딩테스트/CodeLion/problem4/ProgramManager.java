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
		startMessage = "1.��ü����Ʈ 2.��� 0.����>";
		endMessage = "���α׷��� ����Ǿ����ϴ�.";
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
			System.out.println("�߸��� Ű �Է��Դϴ�. Ű�� Ȯ�����ּ���.");
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
			throw new FormatException("�߸��� Ű �Է��Դϴ�.");
		}
	}
}
