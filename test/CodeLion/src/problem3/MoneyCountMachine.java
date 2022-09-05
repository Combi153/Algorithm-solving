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
			System.out.println("�ݾ��� �������� : ");
			this.money = sc.nextLong();
			checkMoneyFormat(money);
			sc.close();
		}catch (InputMismatchException e) {
			System.out.println("�Է� �����Դϴ�. �ݾ��� ������ �Է����ּ���.");
			sc.nextLine();
			inputMoney();
		}catch (FormatException e) {
			System.out.println(e.getMessage());
			sc.nextLine();
			inputMoney();
		}
	}
	
	// input money format ���� ó��
	public void checkMoneyFormat(long money) throws FormatException  {
		if((money % 10) > 0) {
			throw new FormatException("10�� ���� �̸��� ���� ����� �� �����ϴ�. '10�� ���� �̻�'�� �ݾ��� �Է����ּ���");
		}
		else if(money < 0) {
			throw new FormatException("������ ����� �� �����ϴ�. �ݾ��� '���'�� �Է����ּ���");
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
			System.out.println(moneyUnit[i] + "��" + unitCount[i] + "��");
		}
	}
}
