package problem1;

import java.util.InputMismatchException;
import java.util.Scanner;
import formatexception.FormatException;

public class Circle {
	
	private double radius;
	private double areaOfCircle;
	
	public Circle() {}
	
	// 반지름 입력 및 반환
	public double getRadius() {

		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("반지름을 입력하세요 : ");
			this.radius = sc.nextDouble();
			checkRadiusFormat(radius);
			sc.close();
		}catch (InputMismatchException e){
			System.out.println("잘못 입력하셨습니다. 반지름을 양의 실수로 입력해주세요.");
			getRadius();
		}catch (FormatException e) {
			System.out.println(e.getMessage());
			getRadius();
		}
		return radius;
	}
	
	// 반지름 입력 format 오류 처리
	public void checkRadiusFormat(double radius) throws FormatException {
		if(radius <= 0) {
			throw new FormatException("0 이하의 수는 입력할 수 없습니다. 반지름을 양의 실수로 입력해주세요.");
		}
	}	
	
	// 원 넓이 반환
	public double getAreaOfCircle(double radius) {
		this.areaOfCircle = Math.pow(radius, 2) * Math.PI;
		return areaOfCircle;
	}
}
