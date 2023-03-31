package main.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import main.user.bean.UserDTO;
import main.user.dao.UserDAO;

public class UserSearchService  implements UserService{
    @Override
    public void execute() {
        Scanner scan = new Scanner(System.in);
        String columnName = null;
        String value = null;


        System.out.println("\n1. 이름 검색");
        System.out.println("2. 아이디 검색");
        System.out.print("번호 입력:");
        int num = scan.nextInt();

        if(num==1){
            System.out.print("찾고자 하는 이름 입력:");
            value = scan.next();
            columnName = "name";

        }else if(num==2){
            System.out.print("찾고자 하는 아이디 입력:");
            value = scan.next();
            columnName = "id";

        }else{
            System.out.println("1번과 2번 중 하나를 입력해주세요.");
        }

        Map<String, String> map = new HashMap<>();
        map.put("columnName", columnName);
        map.put("value", value);

        UserDAO userDAO = UserDAO.getInstance();
        List<UserDTO> list = userDAO.search(map);

        System.out.printf("%8s\t\t%8s\t\t%8s\n", "이름", "아이디", "비밀번호");
        for(UserDTO userDTO: list) {
            System.out.printf("%8s\t\t%8s\t\t%8s\n", userDTO.getName(), userDTO.getId(),
                userDTO.getPwd());
        }


    }
}
