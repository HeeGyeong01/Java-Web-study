package for_;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        //입력한 금액에 따라 가위바위보게임 반복함.
        //한 게임당 300원.
        System.out.print("Insert Coin : ");
        Scanner scan = new Scanner(System.in);
        int money = scan.nextInt();

        for (int i = 300; i <= money; i += 300) {
            System.out.print("가위(1), 바위(2), 보(3) 중 번호 입력 : ");
            Scanner scan1 = new Scanner(System.in);
            int user = scan1.nextInt();
            int com = (int) (Math.random() * 3 + 1);

            System.out.print("결과를 보려면 Enter를 치세요");
            //String pressEnter =
            new Scanner(System.in).nextLine();

            switch (com) {
                case (1): {
                    switch (user) {
                        case (1): {
                            System.out.println("컴퓨터: 가위   나: 가위\nYou Draw!!\n ");
                            break;
                        }
                        case (2): {
                            System.out.println("컴퓨터: 가위   나: 바위\nYou Win!!\n ");
                            break;
                        }
                        case (3): {
                            System.out.println("컴퓨터: 가위   나: 보자기\nYou Lose!!\n ");
                            break;
                        }

                    }
                    break;
                }
                case (2): {
                    switch (user) {
                        case (1): {
                            System.out.println("컴퓨터: 바위   나: 가위\nYou Lose!!\n ");
                            break;
                        }
                        case (2): {
                            System.out.println("컴퓨터: 바위   나: 바위\nYou Draw!!\n ");
                            break;
                        }
                        case (3): {
                            System.out.println("컴퓨터: 바위   나: 보자기\nYou Win!!\n ");
                            break;
                        }

                    }
                    break;
                }
                case (3): {
                    switch (user) {
                        case (1): {
                            System.out.println("컴퓨터: 보자기   나: 가위\nYou Win!!\n ");
                            break;
                        }
                        case (2): {
                            System.out.println("컴퓨터: 보자기   나: 바위\nYou Lose!!\n ");
                            break;
                        }
                        case (3): {
                            System.out.println("컴퓨터: 보자기   나: 보자기\nYou Draw!!\n ");
                            break;
                        }

                    }
                    break;
                }


            }


        }
    }
}
