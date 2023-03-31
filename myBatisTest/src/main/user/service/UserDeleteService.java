package main.user.service;

import java.util.Scanner;
import main.user.bean.UserDTO;
import main.user.dao.UserDAO;

public class UserDeleteService  implements UserService{

    @Override
    public void execute() {

        System.out.println();
        Scanner scan = new Scanner(System.in);
        System.out.println("찾고자 하는 아이디를 입력: ");
        String id = scan.next();

        UserDAO userDAO = UserDAO.getInstance();
        UserDTO userDTO = userDAO.getUser(id);

        if(userDTO == null) {
            System.out.println("해당 아이디가 존재하지 않습니다.");
            return;
        }
            userDAO.delete(id);
            System.out.println("데이터를 삭제하였습니다.");



    }
}
