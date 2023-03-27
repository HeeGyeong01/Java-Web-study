package inheritance;

import java.util.Scanner;

//ShapeMain 파일에서 public인 클래스는 ShapeMain 클래스 하나여야 한다.
class Shape{
    protected double area;
    protected Scanner scan = new Scanner(System.in);

    public Shape(){
        System.out.println("ShapeTest 기본 생성자");
    }
    public void calcArea(){
        System.out.println("도형을 계산합니다");
    }
    public void dispArea(){
        System.out.println("도형을 출력합니다");
    }
}

class Sam extends Shape{
    protected int base, height;

    public Sam(){
        System.out.println("Sam 기본생성자");
        System.out.print("밑변: ");
        base = scan.nextInt();
        System.out.print("높이: ");
        height = scan.nextInt();
    }

    @Override
    public void calcArea(){
        area = base * height / 2.0;
    }
    @Override
    public void dispArea(){
        System.out.println("삼각형 넓이 = " + area);
    }
}

class Rectangle extends Shape{
    protected int width, height;

    public Rectangle(){
        System.out.println("Rectangle 기본생성자");
        System.out.print("가로 길이: ");
        width = scan.nextInt();
        System.out.print("세로 길이: ");
        height = scan.nextInt();
    }

    @Override
    public void calcArea(){
        area = width * height;
    }
    @Override
    public void dispArea(){
        System.out.println("사각형 넓이 = " + area);
    }
}

class Trapezoid extends Shape{
    protected int top, bottom, height;

    public Trapezoid(){
        System.out.println("Trapezoid 기본생성자");
        System.out.print("윗변: ");
        top = scan.nextInt();
        System.out.print("밑변: ");
        bottom = scan.nextInt();
        System.out.print("높이: ");
        height = scan.nextInt();
    }

    @Override
    public void calcArea(){
        area = (top + bottom) * height / 2.0;
    }
    @Override
    public void dispArea(){
        System.out.println("사다리꼴 넓이 = " + area);
    }

}

public class ShapeMain {
    public static void main(String[] args){
        Sam sam = new Sam();
        sam.calcArea();
        sam.dispArea();


    }
}
