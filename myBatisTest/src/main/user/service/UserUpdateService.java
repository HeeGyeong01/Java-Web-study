package main.user.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import main.user.bean.UserDTO;
import main.user.dao.UserDAO;

public class UserUpdateService implements UserService{

    @Override
    public void execute() {

        System.out.println();
        Scanner scan = new Scanner(System.in);
        System.out.print("찾고자 하는 아이디를 입력: ");
        String id = scan.next();

        UserDAO userDAO = UserDAO.getInstance();
        UserDTO userDTO = userDAO.getUser(id);

        if(userDTO == null) {
            System.out.println("해당 아이디가 존재하지 않습니다.");
            return;
        }

        System.out.println();
        System.out.printf("%8s\t\t%8s\t\t%8s\n", "이름", "아이디", "비밀번호");
        System.out.printf("%8s\t\t%8s\t\t%8s", userDTO.getName(), userDTO.getId(), userDTO.getPwd());

        System.out.print("\n변경할 이름:");
        String name = scan.next();
        System.out.print("변경할 비밀번호:");
        String pwd = scan.next();

        Map<String, String> map = new HashMap<>();
        map.put("name", name);
        map.put("id", id);
        map.put("pwd", pwd);

        userDAO.update(map);
        System.out.println("회원 정보 수정을 완료했습니다.");

    }
}
