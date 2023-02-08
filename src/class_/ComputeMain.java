package class_;

import java.util.Scanner;

public class ComputeMain {
    public static void main(String[] args) {
        System.out.print("횟수 입력 : ");
        int count = new Scanner(System.in).nextInt();

        Compute[] com = new Compute[count];

        for (int i = 0; i < count; i++) {
            System.out.printf("\n[%d번째]\n", (i + 1));
            System.out.print("x 입력 : ");
            int x = new Scanner(System.in).nextInt();

            System.out.print("y 입력 : ");
            int y = new Scanner(System.in).nextInt();
            com[i] = new Compute();
            com[i].setData(x, y);
            com[i].calc();
        }

        System.out.println("x\t y\t sum\tsub\tmul\tdiv");
        for (int i = 0; i < count; i++) {
            System.out.printf("%d\t%d\t%d\t%d\t%d\t%s\n",
                com[i].getX(), com[i].getY(), com[i].getSum(),
                com[i].getSub(), com[i].getMul(), com[i].getDiv());
        }
    }
}
