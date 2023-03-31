package main.user.service;

import java.util.Scanner;
import main.user.bean.UserDTO;
import main.user.dao.UserDAO;

public class UserInsertService implements UserService {
    public void execute(){
        System.out.println();

        Scanner scan = new Scanner(System.in);

        System.out.print("이름 입력: ");
        String name = scan.next();
        System.out.print("아이디 입력: ");
        String id = scan.next();
        System.out.print("비밀번호 입력: ");
        String pwd = scan.next();

        UserDTO userDTO = new UserDTO();
        userDTO.setName(name);
        userDTO.setId(id);
        userDTO.setPwd(pwd);

        //DB
        UserDAO userDAO = UserDAO.getInstance(); //싱글톤(메모리에 딱 한 번 만들어 놓고 계속 쓰는 것)
        userDAO.write(userDTO);

        System.out.println();
    }
}
