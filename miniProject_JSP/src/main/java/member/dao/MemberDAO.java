package member.dao;

import java.util.HashMap;
import java.util.Map;
import java.io.IOException;
import java.io.InputStream;

import member.bean.MemberDTO;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemberDAO {
    private SqlSessionFactory sqlSessionFactory;

    private static MemberDAO memberDAO = new MemberDAO();

    public static MemberDAO getInstance() { //싱글톤 스타일
        return memberDAO;
    }

    public MemberDAO() {
        try {
            InputStream inputStream = null;
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        }catch(IOException e){
            e.printStackTrace();
        }

    }


    public int memberWrite(MemberDTO memberDTO){
        int su = 0;

        SqlSession sqlSession = sqlSessionFactory.openSession(); //메소드 통해 객체 생성
        su = sqlSession.insert("memberSQL.memberWrite",memberDTO );
        sqlSession.commit();
        sqlSession.close();

        return su;


//        String sql = "insert into member values(?,?,?,?,?,?,?,?,?,?,?,?,sysdate)";


    }


    public MemberDTO memberLogin(Map map){
        SqlSession sqlsession = sqlSessionFactory.openSession();
        MemberDTO memberDTO = null;

        memberDTO = sqlsession.selectOne("memberSQL.memberLogin", map);
        //String sql = "select name, email1, email2  from member where id=? and pwd=?";

        if(memberDTO != null) { //id와 pw에 해당하는 회원정보가 있을 경우
            return memberDTO;
        }
        else
            return null;
    }


    public MemberDTO getMember(String id){
        MemberDTO member = null;

        //String sql = "select * from member where id = ?";
        SqlSession sqlsession = sqlSessionFactory.openSession();
        member = sqlsession.selectOne("memberSQL.getMember", id);
        sqlsession.close();

        if(member == null){
            System.out.println("id로 회원정보 가져오기 실패");
        }

        return member;
    }

    public int memberUpdate(MemberDTO memberDTO){
        int updateCount = 0;

        SqlSession sqlsession = sqlSessionFactory.openSession();
        updateCount = sqlsession.update("memberSQL.memberUpdate", memberDTO);
        sqlsession.commit();
        sqlsession.close();

        if(updateCount == 0){
            System.out.println("업데이트 실패");
        }

        return updateCount;


//        String sql = "UPDATE member "
//            + "SET name=?, pwd=?, gender=?, email1=?, email2=?, tel1=?, tel2=?, tel3=?"
//            + ", zipcode=?, addr1=?, addr2=? WHERE id=?";

//        try{
//            pstmt.setString(1, memberDTO.getName());
//            pstmt.setString(2, memberDTO.getPwd());
//            pstmt.setString(3, memberDTO.getGender());
//
//            updateCount = pstmt.executeUpdate(); //업데이트 실행 - 개수 리턴
//
//        }catch(SQLException e){
//            System.out.println("업데이트 실패");
//            e.printStackTrace();
//        }

    }

    public boolean isExistPwd(String id, String pwd){
        boolean exist = false;
        MemberDTO memberDTO = null;

        SqlSession sqlsession = sqlSessionFactory.openSession();
        Map<String, String> map = new HashMap<>();
        map.put("id", id);
        map.put("pwd", pwd);
        memberDTO = sqlsession.selectOne("memberSQL.isExistPwd", map);
        sqlsession.close();

        if(memberDTO != null){ //해당 id-pwd 가 존재할 경우
                exist = true;
        }
        return exist;
//        String sql = "SELECT * FROM member WHERE id=? and pwd=?";

    }

    public boolean isExistId(String id){
        boolean exist = false;
        MemberDTO memberDTO = null;

        SqlSession sqlsession = sqlSessionFactory.openSession();
        memberDTO = sqlsession.selectOne("memberSQL.isExistId", id);
        sqlsession.close();

        if(memberDTO != null){ //해당 id-pwd 가 존재할 경우
            exist = true;
        }

        return exist;
//        String sql = "SELECT * FROM member WHERE id=?";

    }

    public void memberDelete(String id){
        SqlSession sqlsession = sqlSessionFactory.openSession();
        sqlsession.delete("memberSQL.memberDelete", id);
        sqlsession.commit();
        sqlsession.close();
//        String sql = "DELETE FROM member WHERE id=?";

    }



}
