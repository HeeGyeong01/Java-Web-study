package multi_;

public class MultiFor04 {
    public static void main(String[] args) {
        for (int block = 2; block <= 8; block += 3) {
            for (int i = 1; i <= 9; i++) {
                for (int dan = block; dan <= 9; dan++) {
                    if (dan % 3 == 2) {
                        System.out.println();
                    }
                    System.out.printf("%d*%d=%d\t", dan, i, dan * i);
                }
            }
        }

    }
}
