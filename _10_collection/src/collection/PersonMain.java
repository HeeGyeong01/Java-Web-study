package collection;

import java.util.ArrayList;

public class PersonMain {
    public ArrayList<PersonDTO> init(){
        PersonDTO aa = new PersonDTO("홍길동", 25);
        PersonDTO bb = new PersonDTO("프로도", 20);
        PersonDTO cc = new PersonDTO("라이언", 15);

        ArrayList<PersonDTO> list = new ArrayList<PersonDTO>();
        list.add(aa);
        list.add(bb);
        list.add(cc);

        return list; //aa의 메모리 위 주소값(클래스명@해쉬값) 반환함.

    }

    public static void main(String[] args){
        PersonMain personMain = new PersonMain();

        ArrayList<PersonDTO> list = personMain.init();

        for(PersonDTO personDTO: list){
            System.out.println(personDTO.getName() + '\t' + personDTO.getAge());
        }

    }
}
