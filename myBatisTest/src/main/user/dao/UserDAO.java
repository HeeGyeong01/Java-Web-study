package main.user.dao;

import java.io.IOException;
import java.io.InputStream;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import main.user.bean.UserDTO;

public class UserDAO {
    private SqlSessionFactory sqlSessionFactory;
    private static UserDAO userDAO = new UserDAO();

    public static UserDAO getInstance() {
        return userDAO;
    }


    public UserDAO(){
        try {
            InputStream inputStream = null;
            //Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void write(UserDTO userDTO){
        SqlSession sqlSession = sqlSessionFactory.openSession(); //메소드 통해 객체 생성
        sqlSession.insert("userSQL.write",userDTO );
        sqlSession.commit();
        sqlSession.close();
    }

    public List<UserDTO> getUserList() {
        SqlSession sqlsession = sqlSessionFactory.openSession();
        List<UserDTO> list = sqlsession.selectList("userSQL.getUserList"); //MyBatis에서 자체적으로 제공하는 함수(List를 return해줌)
        sqlsession.close();

        return list;
    }



    public UserDTO getUser(String id) {
        SqlSession sqlsession = sqlSessionFactory.openSession();
        //userMapper.xml 파일 안에 id명, 넘겨줄 데이터(반드시 1개)
        UserDTO userDTO = sqlsession.selectOne("userSQL.getUser", id);
        sqlsession.close();

        return userDTO;
    }

    public void update(Map<String, String> map) {
        SqlSession sqlsession = sqlSessionFactory.openSession();
        sqlsession.update("userSQL.update", map);
        sqlsession.commit();
        sqlsession.close();
    }

    public void delete(String id) {
        SqlSession sqlsession = sqlSessionFactory.openSession();
        sqlsession.delete("userSQL.delete", id);
        sqlsession.commit();
        sqlsession.close();
    }

    public List<UserDTO> search(Map<String, String> map) {

        SqlSession sqlsession = sqlSessionFactory.openSession();
        List<UserDTO> list = sqlsession.selectList("userSQL.search", map);

        sqlsession.close();
        return list;
    }
}
