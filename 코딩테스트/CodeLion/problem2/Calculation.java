package problem2;

public class Calculation {

	private int start = 1;
	private int end = 100;
	int number1;
	int number2;
	private int leastCommonMultiple;
	
	public Calculation(int number1, int number2) {
		this.number1 = number1;
		this.number2 = number2;
	}
	
	// 최소공배수 반환
	public int getLCM() {
		leastCommonMultiple = 0; // 초기값 0
		for (int i = start; i <= end; i++) {
			if ((i % 7 == 0) && (i % 8 == 0)) {
				leastCommonMultiple = i;
				break;
			}
		}
		return leastCommonMultiple;
	}
	
	// start, end 참조 및 설정 메서드
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
}
