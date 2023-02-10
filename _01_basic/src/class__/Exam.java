package class__;

public class Exam {
    private String name = null;
    private String answer = null;
    private char[] ox = null;
    private int score = 0;
    private final String rightAnswer = "11111"; //상수


    public Exam(String name, String answer){
        this.name = name;
        this.answer = answer;
        ox = new char[answer.length()];
        compare();
    }

    public void compare(){
        for(int i = 0; i<answer.length(); i++){
            if(answer.charAt(i) == rightAnswer.charAt(i)){
                this.score +=20;
                ox[i] = 'O';
            }else{
                ox[i] = 'X';
            }
        }
    }


    public String getName() {
        return name;
    }

    public String getOx() {
        StringBuilder sb = new StringBuilder();
        for(char ch: ox){
            sb.append(ch).append(" ");
        }
        return sb.toString();
    }

    public int getScore() {
        return score;
    }

}
