package problem3;

import java.util.InputMismatchException;
import formatexception.FormatException;
import java.util.Scanner;

public class MoneyCountMachine {
	
	private long money;
	private int count;
	private int[] moneyUnit;
	private int[] unitCount;
	Scanner sc = new Scanner(System.in);


	public MoneyCountMachine(int[] moneyUnit, int[] unitCount) {
		this.moneyUnit = moneyUnit;
		this.unitCount = unitCount;
	}
	
	// input money
	public void inputMoney() {
		
		try {
			System.out.println("금액을 넣으세요 : ");
			this.money = sc.nextLong();
			checkMoneyFormat(money);
			sc.close();
		}catch (InputMismatchException e) {
			System.out.println("입력 오류입니다. 금액을 정수로 입력해주세요.");
			sc.nextLine();
			inputMoney();
		}catch (FormatException e) {
			System.out.println(e.getMessage());
			sc.nextLine();
			inputMoney();
		}
	}
	
	// input money format 예외 처리
	public void checkMoneyFormat(long money) throws FormatException  {
		if((money % 10) > 0) {
			throw new FormatException("10원 단위 미만의 수는 계산할 수 없습니다. '10원 단위 이상'의 금액을 입력해주세요");
		}
		else if(money < 0) {
			throw new FormatException("음수는 계산할 수 없습니다. 금액을 '양수'로 입력해주세요");
		}
	}
	
	// count money
	public void countMoneyUnit() {
		for (int i = 0; i<moneyUnit.length; i++) {
			count = 0;
			while (money >= moneyUnit[i]) {
				money -= moneyUnit[i];
				count += 1;
			}
			unitCount[i] = count;
		}
		
		for (int i = 0; i<moneyUnit.length; i++) {
			System.out.println(moneyUnit[i] + "원" + unitCount[i] + "개");
		}
	}
}
