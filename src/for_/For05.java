package for_;

public class For05 {
    //대문자(A~Z)를 랜덤으로 100개 만들어 출력하기
    //1줄에 10개씩 출력
    //100개 중에서 A가 몇개 나왔는지 개수를 출력
    public static void main(String[] args) {
        int count = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                //65~90 까지가 A~Z의 아스키코드 값임
                int random_num = (int) (Math.random() * 26 + 65);
                System.out.print((char) random_num);
                if (random_num == 65) {
                    count += 1;
                }
            }
            System.out.println();
        }
        System.out.printf("A의 개수 = " + count);
    }


}
