package guestbook.dao;

import guestbook.bean.GuestbookDTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import guestbook.bean.GuestbookDTO;
import java.util.ArrayList;

public class GuestbookDAO {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    private String driver = "oracle.jdbc.driver.OracleDriver";
    private String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private String user_name = "c##java";
    private String password = "1234";

    private static GuestbookDAO guestbookDAO = new GuestbookDAO();

    public static GuestbookDAO getInstance() { //싱글톤 스타일
        return guestbookDAO;
    }

    //생성자에서 드라이버 로딩.
    public GuestbookDAO() {
        try {
            Class.forName(driver);
            System.out.println("driver loading 성공!");

        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }


    public void getConnection(){
        try {
            conn = DriverManager.getConnection(url, user_name, password);
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
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void guestbookWrite(GuestbookDTO guestbookDTO){
        int su = 0;

        String sql = "insert into GUESTBOOK values(SEQ_GUESTBOOK.NEXTVAL,?,?,?,?,?,sysdate)";

        this.getConnection();
        try{
            pstmt = conn.prepareStatement(sql); //생성

            pstmt.setString(1, guestbookDTO.getName());
            pstmt.setString(2, guestbookDTO.getEmail());
            pstmt.setString(3, guestbookDTO.getHomepage());
            pstmt.setString(4, guestbookDTO.getSubject());
            pstmt.setString(5, guestbookDTO.getContent());

            pstmt.executeUpdate(); //실행

        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            GuestbookDAO.close(pstmt, conn);
        }

    }

    public GuestbookDTO guestbookSearch(int seq){
        GuestbookDTO guestbookDTO = new GuestbookDTO();

        String sql = "SELECT name, email, homepage, subject, content,"
            + "to_char(logtime, 'YYYY.MM.DD') as logtime FROM GUESTBOOK WHERE seq = ?";

        this.getConnection();
        try{
            pstmt = conn.prepareStatement(sql); //생성

            pstmt.setInt(1, seq);

            rs = pstmt.executeQuery(); //실행

            if(rs.next()) { //해당 seq에 해당하는 결과 레코드가 있을 때.

                guestbookDTO.setSeq(seq);
                guestbookDTO.setName(rs.getString(1));
                guestbookDTO.setEmail(rs.getString(2));
                guestbookDTO.setHomepage(rs.getString(3));
                guestbookDTO.setSubject(rs.getString(4));
                guestbookDTO.setContent(rs.getString(5));
                guestbookDTO.setLogtime(rs.getString(6));
            }

        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            GuestbookDAO.close(pstmt, conn, rs);
        }
        return guestbookDTO;

    }

    public ArrayList<GuestbookDTO> guestbookList(int startNum, int endNum){
        ArrayList<GuestbookDTO> list = new ArrayList<GuestbookDTO>();

        String sql = "SELECT * FROM ("
            + "SELECT ROWNUM rn, AA.* "
            + "FROM (SELECT seq, name, email, homepage, subject, content, to_char(logtime, 'YYYY.MM.DD') as logtime "
            + "FROM GUESTBOOK ORDER BY seq desc) aa)"
            + "         WHERE RN>=? AND RN<=?";

        this.getConnection();

        try{
            pstmt = conn.prepareStatement(sql); //생성
            pstmt.setInt(1, startNum);
            pstmt.setInt(2, endNum);
            rs = pstmt.executeQuery(); //실행

            while(rs.next()) { //해당 seq에 해당하는 결과 레코드가 있을 때.
                GuestbookDTO guestbookDTO = new GuestbookDTO();

                guestbookDTO.setSeq(Integer.parseInt(rs.getString(1)));
                guestbookDTO.setName(rs.getString(2));
                guestbookDTO.setEmail(rs.getString(3));
                guestbookDTO.setHomepage(rs.getString(4));
                guestbookDTO.setSubject(rs.getString(5));
                guestbookDTO.setContent(rs.getString(6));
                guestbookDTO.setLogtime(rs.getString(7));

                list.add(guestbookDTO);
            }

        }catch(SQLException e){
            e.printStackTrace();
            list = null;
        }finally {
            GuestbookDAO.close(pstmt, conn, rs);
        }
        return list;

    }

    public int getTotalA(){
        int totalArticle = 0;
        String sql = "SELECT COUNT(*) FROM GUESTBOOK";

        this.getConnection();

        try{
            pstmt = conn.prepareStatement(sql); //생성
            rs = pstmt.executeQuery(); //실행

            if(rs.next()) { //해당 seq에 해당하는 결과 레코드가 있을 때.
                totalArticle = rs.getInt(1);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            GuestbookDAO.close(pstmt, conn, rs);
        }
        return totalArticle;

    }



}
