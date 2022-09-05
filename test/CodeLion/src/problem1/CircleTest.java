package problem1;

public class CircleTest {

	public static void main(String[] args) {
		
		double radiusInput;
		double areaValue;
		
		Circle circleOne = new Circle();
		radiusInput = circleOne.getRadius();
		areaValue = circleOne.getAreaOfCircle(radiusInput);
		System.out.println("원의 넓이는 : " + areaValue);
	}

}
