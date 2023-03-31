package member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import member.bean.MemberDTO;

public class MemberDAO {
    private Connection conn;        // Interface "Connection"
    private PreparedStatement pstmt;
    private ResultSet rs; // = null;

    private String driver = "oracle.jdbc.driver.OracleDriver";
    private String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private String user_name = "c##java";
    private String password = "1234";

    private static MemberDAO memberDAO = new MemberDAO();

    public MemberDAO() {
        try {
            //ojdbc8.jar 안에 있는 OracleDriver.class 파일
            Class.forName(driver);//.Class 타입으로 생성
            System.out.println("driver loading 성공!");

        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }

    }

    public static MemberDAO getInstance() { //싱글톤 스타일
        return memberDAO;
    }


    public void getConnection(){
        try {
            conn = DriverManager.getConnection(url, user_name, password);    // getConnection(url, username, pw)
            System.out.println("Connection Success!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void close(PreparedStatement pstmt, Connection conn) {
        try {
            // db close() 꼭 해줘야 함
            if(pstmt != null) pstmt.close();
            if(conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //오버로드
    private static void close(PreparedStatement pstmt, Connection conn, ResultSet rs) {
        try {
            if(rs != null) rs.close();
            if(pstmt != null) pstmt.close();
            if(conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public int memberWrite(MemberDTO memberDTO){
        int su = 0;

        this.getConnection();
        String sql = "insert into member values(?,?,?,?,?,?,?,?,?,?,?,?,sysdate)";

        try{
            pstmt = conn.prepareStatement(sql); //생성

            pstmt.setString(1, memberDTO.getName());
            pstmt.setString(2, memberDTO.getId());
            pstmt.setString(3, memberDTO.getPwd());
            pstmt.setString(4, memberDTO.getGender());
            pstmt.setString(5, memberDTO.getEmail1());
            pstmt.setString(6, memberDTO.getEmail2());
            pstmt.setString(7, memberDTO.getTel1());
            pstmt.setString(8, memberDTO.getTel2());
            pstmt.setString(9, memberDTO.getTel3());
            pstmt.setString(10, memberDTO.getZipcode());
            pstmt.setString(11, memberDTO.getAddr1());
            pstmt.setString(12, memberDTO.getAddr2());

            su = pstmt.executeUpdate(); //실행 - 개수 리턴
            System.out.println(su + " 행이 삽입되었습니다.");



        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            MemberDAO.close(pstmt, conn);

        }

        return su;
    }


    public String memberLogin(String id, String pwd){
        String name = null;
        String sql = "select name from member where id=? and pwd=?";
        this.getConnection();

        try{
            pstmt = conn.prepareStatement(sql); //생성

            pstmt.setString(1, id);
            pstmt.setString(2, pwd);

            rs = pstmt.executeQuery(); //실행 - 쿼리문 실행 결과 리턴

            if(rs.next()) name=rs.getString(1);

        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            MemberDAO.close(pstmt, conn, rs);

        }
        if (name == null) return null;
        else return name;
    }


    public MemberDTO getMember(String id){
        MemberDTO member = null;

        this.getConnection();
        String sql = "select * from member where id = ?";

        try{
            pstmt = conn.prepareStatement(sql); //생성
            pstmt.setString(1, id);
            rs = pstmt.executeQuery(); //SELECT 실행 - 개수 리턴

            if(rs.next()){
                member = new MemberDTO();
                member.setName(rs.getString("name"));
                member.setId(rs.getString("id"));
                member.setPwd(rs.getString("pwd"));
                member.setGender(rs.getString("gender"));
                member.setEmail1(rs.getString("email1"));
                member.setEmail2(rs.getString("email2"));
                member.setTel1(rs.getString("tel1"));
                member.setTel2(rs.getString("tel2"));
                member.setTel3(rs.getString("tel3"));
                member.setZipcode(rs.getString("zipcode"));
                member.setAddr1(rs.getString("addr1"));
                member.setAddr2(rs.getString("addr2"));

            }



        }catch(SQLException e){
            System.out.println("id로 회원정보 가져오기 실패");
            e.printStackTrace();
        }finally {
            MemberDAO.close(pstmt, conn, rs);

        }

        return member;
    }

    public int memberUpdate(MemberDTO memberDTO){
        int updateCount = 0;

        this.getConnection();
        String sql = "UPDATE member "
            + "SET name=?, pwd=?, gender=?, email1=?, email2=?, tel1=?, tel2=?, tel3=?"
            + ", zipcode=?, addr1=?, addr2=? WHERE id=?";

        try{
            pstmt = conn.prepareStatement(sql); //생성

            pstmt.setString(1, memberDTO.getName());
            pstmt.setString(2, memberDTO.getPwd());
            pstmt.setString(3, memberDTO.getGender());
            pstmt.setString(4, memberDTO.getEmail1());
            pstmt.setString(5, memberDTO.getEmail2());
            pstmt.setString(6, memberDTO.getTel1());
            pstmt.setString(7, memberDTO.getTel2());
            pstmt.setString(8, memberDTO.getTel3());
            pstmt.setString(9, memberDTO.getZipcode());
            pstmt.setString(10, memberDTO.getAddr1());
            pstmt.setString(11, memberDTO.getAddr2());
            pstmt.setString(12, memberDTO.getId());

            updateCount = pstmt.executeUpdate(); //업데이트 실행 - 개수 리턴

        }catch(SQLException e){
            System.out.println("업데이트 실패");
            e.printStackTrace();
        }finally {
            MemberDAO.close(pstmt, conn);

        }

        return updateCount;
    }

    public boolean isExistPwd(String id, String pwd){
        boolean exist = false;
        String sql = "SELECT * FROM member WHERE id=? and pwd=?";
        this.getConnection();

        try{
            pstmt = conn.prepareStatement(sql); //생성
            pstmt.setString(1, id);
            pstmt.setString(2, pwd);

            rs = pstmt.executeQuery(); //실행 - 쿼리 실행 결과 리턴
            if(rs.next()){
                exist = true;
            }

        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            MemberDAO.close(pstmt, conn, rs);
        }
        return exist;
    }

    public void memberDelete(String id){
        String sql = "DELETE FROM member WHERE id=?";
        this.getConnection();

        try{
            pstmt = conn.prepareStatement(sql); //생성
            pstmt.setString(1, id);

            pstmt.executeUpdate(); //쿼리 실행

        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            MemberDAO.close(pstmt, conn);
        }
    }



}
