package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import javax.sound.midi.Soundbank;

public class PersonSort {
    public static void main(String[] args){
        String[] arr = {"orange", "apple", "banana", "pear", "peach", "mango"};

        System.out.println("정렬 전 = ");
        for(String data: arr){
            System.out.print(data + " ");
        }
        System.out.println();

        Arrays.sort(arr);

        System.out.print("정렬 후 = ");
        for(String data: arr){
            System.out.print(data+ " ");
        }
        System.out.println();

        //----------------------------------------
        PersonDTO aa = new PersonDTO("홍길동", 25);
        PersonDTO bb = new PersonDTO("프로도", 30);
        PersonDTO cc = new PersonDTO("라이언", 15);

        ArrayList<PersonDTO> list = new ArrayList<PersonDTO>();
        list.add(aa);
        list.add(bb);
        list.add(cc);

        System.out.println("정렬 전");
        for(PersonDTO personDTO: list){
            System.out.println(personDTO);
        }
        System.out.println();

        Collections.sort(list);

        System.out.println("정렬 후");
        for(PersonDTO personDTO: list){
            System.out.println(personDTO);
        }
        System.out.println();

        System.out.println("이름으로 내림차순");
        Comparator<PersonDTO> com = new Comparator<PersonDTO>() {
            @Override
            public int compare(PersonDTO dto1, PersonDTO dto2) {
                //return dto1.getName().compareTo(dto2.getName()); 오름차순
//                return dto1.getName().compareTo(dto2.getName()) * (-1); //내림차순
                return dto2.getName().compareTo(dto1.getName()); //내림차순
            }
        };

        Collections.sort(list, com);
        System.out.println("정렬 후");
        for(PersonDTO personDTO: list){
            System.out.println(personDTO);
        }

    }
}
