package com.zoo.safari;

import com.zoo.Zoo;

/*safari패키지는 zoo패키지 안에 있으나
zoo패키지와 같은 패키지 안에 있다고 고려되지 않아서
zoo패키지의 default, protected, private 함수에 접근하지 못한다.*/
public class Safari extends Zoo {
    public static void main(String[] args){
        Zoo z = new Zoo();
        z.tiger();
//        z.giraffe();
//        z.elephant();
//        z.lion();

        Safari s = new Safari();
        s.tiger();
        s.giraffe();
        //protected는 다른 패키지에서 자식패키지에서 접근이 가능하다.
        //But 자식 클래스로 생성해야 접근이 가능하다.
//        s.elephant();
//        s.lion();

    }
}
