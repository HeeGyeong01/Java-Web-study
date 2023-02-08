package multi_;

//3중 for문으로 구구단 출력.
public class MultiFor04 {
    public static void main(String[] args) {
        for (int i = 2; i <= 8; i += 3) {

            for (int j = 1; j <= 9; j++) {

                for (int a = 0; a <= 2; a++) {
                    if(i + a >= 10) {
                        break;
                    }
                    System.out.printf("%d*%d=%d\t", i + a, j, (i + a) * j);
                }
                System.out.println();
            }
            System.out.println();
        }


    }
}
