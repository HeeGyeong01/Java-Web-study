package operator;

public class Boxing {
    public static void main(String[] args) {
        int a = 25;
        double b = (double)a / 3; //강제형변환(Casting) / a에 의해 자동형변환됨

        String c = "25";
        //int d = (int)c; // (기본형)객체형 !!Error!!
        int d = Integer.parseInt(c); //c가 객체형이므로 메소드 이용해서 형변환 해줌

        int e = 5;
        Integer f = e; //AutoBoxing (기본형 -> 객체형)
        //  객체형 = 기본형

        Integer g = 5;
        int h = g; //unAutoBoxing (객체형 -> 기본형)
    }

}
