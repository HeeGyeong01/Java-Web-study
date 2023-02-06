package multi_;

public class MultiFor03 {
    public static void main(String[] args) {
//        int dan, i;

        for (int j = 1; j <= 9; j++) {
            for (int i = 2; i <= 9; i++) {
                System.out.printf("%d*%d=%d\t", i, j, i * j);

            }
            System.out.println();
        }
    }
}
