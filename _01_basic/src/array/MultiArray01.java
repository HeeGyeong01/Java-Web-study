package array;

public class MultiArray01 {
    public static void main(String[] args) {
        int[][] arr = new int[3][]; //가변길이
        arr[0] = new int[2];
        arr[1] = new int[3];
        arr[2] = new int[4];

        arr[2][0] = 60;
        arr[2][1] = 70;
        arr[2][2] = 80;
        arr[2][3] = 90;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("arr[%d][%d] = %d\n", i, j, arr[i][j]);
            }
            System.out.println();
        }
        
    }
}
