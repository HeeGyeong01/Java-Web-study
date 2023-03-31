package main.user.service;

import java.util.List;
import main.user.bean.UserDTO;
import main.user.dao.UserDAO;

public class UserSelectService  implements UserService{
    @Override
    public void execute() {
        //DB
        UserDAO userDAO = UserDAO.getInstance();
        List<UserDTO> list = userDAO.getUserList();

        System.out.printf("%8s\t\t%8s\t\t%8s\n", "이름", "아이디", "비밀번호");
        for(UserDTO userDTO: list) {
            System.out.printf("%8s\t\t%8s\t\t%8s\n", userDTO.getName(), userDTO.getId(),
                userDTO.getPwd());
        }


    }
}
