package operator;

public class Dice {

    public static void main(String[] args) {
        int dice1, dice2;

        dice1 = (int) (Math.random() * 6 + 1);
        dice2 = (int) (Math.random() * 6 + 1);

        String result = "";
        if (dice1 > dice2) {
            result = "주사위1 승";
        } else if (dice1 < dice2) {
            result = "주사위2 승";
        } else if (dice1 == dice2) {
            result = "무승부";
        }

        System.out.println("주사위1: " + dice1 + "    주사위2: " + dice2);
        System.out.println(result);
    }
}
