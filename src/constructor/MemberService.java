package constructor;

import java.util.Scanner;

public class MemberService {
    private MemberDTO[] arr = new MemberDTO[5];
    Scanner scan = new Scanner(System.in);

    public void menu() {
        int num = 0;

        while(true) {
            System.out.print(
                "*************\n"
                    + "   1. 가입\n"
                    + "   2. 출력\n"
                    + "   3. 수정\n"
                    + "   4. 탈퇴\n"
                    + "   5. 끝내기\n"
                    + "*************\n"
                    + "  번호 : ");
            num = scan.nextInt();
            if(num == 5) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else if(num == 1) insert();
            else if(num == 2) list();
            else if(num == 3) update();
            else if(num == 4) delete();

        }
    }


    private void insert() {
        int idx;
        for(idx = 0; idx < arr.length; idx++) {
            if(arr[idx] == null) break;
        }
        if(idx == arr.length) { //idx++ 연산 실행한 후에 나오므로 arr.length -1이 아님.
            System.out.println(arr.length + "명의 정원이 꽉 찼습니다");
            return; //inser() 함수 벗어남
        }

        //데이터 입력받음
        System.out.print("이름 입력 : ");
        String name = new Scanner(System.in).nextLine();
        System.out.print("나이 입력 : ");
        int age = new Scanner(System.in).nextInt();
        System.out.print("폰 번호 입력(숫자만 적어주세요) : ");
        String phone = new Scanner(System.in).nextLine();
        System.out.print("주소 입력 : ");
        String address = new Scanner(System.in).nextLine();

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == null) {
                arr[i] = new MemberDTO(name, age, phone, address);
                System.out.println("1 row created\n");
                break;
            }
        }
    }

    private void list() {
        System.out.println("이름\t\t나이\t\t\t폰 번호\t\t\t주소");
        for(MemberDTO member : arr) {
            if(member != null) {
                System.out.printf("%s\t %d\t\t%s\t\t%s\n",
                    member.getName(), member.getAge(), member.getPhone(), member.getAddress());
            }
        }
    }

    private void update() {
        System.out.print("폰 번호 입력 : ");
        String inputPhone = new Scanner(System.in).nextLine();
        //폰 번호로 해당 회원 찾기
        for(MemberDTO member : arr) {
            if(member.getPhone() == null) {System.out.println("찾는 회원이 없습니다.");}
            if(member.getPhone().equals(inputPhone)) {
                System.out.printf("%s\t%d\t%s\t%s\n",
                    member.getName(), member.getAge(), member.getPhone(), member.getAddress());

                System.out.print("수정 할 이름 입력: ");
                String name = new Scanner(System.in).nextLine();
                System.out.print("수정 할 폰 번호 입력: ");
                String phone = new Scanner(System.in).nextLine();
                System.out.print("수정 할 주소 입력: ");
                String address = new Scanner(System.in).nextLine();

                member.setName(name);
                member.setPhone(phone);
                member.setAddress(address);

                System.out.println("1 row updated\n");
                break;

            }
            System.out.println("찾는 회원이 없습니다.");
        }


    }


    private void delete() {
        System.out.print("폰 번호 입력 : ");
        String inputPhone = new Scanner(System.in).nextLine();
        //폰 번호로 해당 회원 찾기
        for(int i = 0; i < arr.length; i++) {
            if(arr[i].getPhone() == null) {System.out.println("찾는 회원이 없습니다.");}
            if(arr[i].getPhone().equals(inputPhone)) {
                arr[i] = null;
                System.out.println("1 row deleted\n");

                //데이터가 중간에 비는 것 없이 순서대로 쌓이도록 앞으로 밀어줌.
                for(int j = i; j < (arr.length - 1); j++) {
                    arr[i] = arr[i + 1];
                }

                break;
            }
            System.out.println("찾는 회원이 없습니다.");
        }

    }
}
