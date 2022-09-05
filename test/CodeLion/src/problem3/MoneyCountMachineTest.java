package problem3;

public class MoneyCountMachineTest {

	public static void main(String[] args) {
		
		int[] unitArray = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
		int[] countArray = new int[unitArray.length];
		
		MoneyCountMachine moneyCount = new MoneyCountMachine(unitArray, countArray);
		moneyCount.inputMoney();
		moneyCount.countMoneyUnit();
	}
}

