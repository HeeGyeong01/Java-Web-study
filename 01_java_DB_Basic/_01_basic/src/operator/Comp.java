package operator;

public class Comp {

    public static void main(String[] args) {
        char ch = 'Z';
        char convertedCh = '0';

//        if (ch >= 65 && ch < 97) {
        if (ch >= 'A' && ch <= 'Z') {
            convertedCh = (char) (ch + 32);
        } else if (ch >= 97 && ch <= 122) { //a~z의 아스키코드값 범위
            convertedCh = (char) (ch - 32);
        } else {
            System.out.println("영어 대소문자 한 글자만 입력해 주세요!");
        }

        System.out.println(ch + " -> " + convertedCh);


    }

}
