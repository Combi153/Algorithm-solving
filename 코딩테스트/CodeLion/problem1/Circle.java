package problem1;

import java.util.InputMismatchException;
import java.util.Scanner;
import formatexception.FormatException;

public class Circle {
	
	private double radius;
	private double areaOfCircle;
	
	public Circle() {}
	
	// ������ �Է� �� ��ȯ
	public double getRadius() {

		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("�������� �Է��ϼ��� : ");
			this.radius = sc.nextDouble();
			checkRadiusFormat(radius);
			sc.close();
		}catch (InputMismatchException e){
			System.out.println("�߸� �Է��ϼ̽��ϴ�. �������� ���� �Ǽ��� �Է����ּ���.");
			getRadius();
		}catch (FormatException e) {
			System.out.println(e.getMessage());
			getRadius();
		}
		return radius;
	}
	
	// ������ �Է� format ���� ó��
	public void checkRadiusFormat(double radius) throws FormatException {
		if(radius <= 0) {
			throw new FormatException("0 ������ ���� �Է��� �� �����ϴ�. �������� ���� �Ǽ��� �Է����ּ���.");
		}
	}	
	
	// �� ���� ��ȯ
	public double getAreaOfCircle(double radius) {
		this.areaOfCircle = Math.pow(radius, 2) * Math.PI;
		return areaOfCircle;
	}
}
