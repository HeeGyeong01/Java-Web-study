package dbtest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectMain {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    private String driver = "oracle.jdbc.driver.OracleDriver";
    private String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private String username = "C##JAVA";
    private String password = "1234";

    public SelectMain() {
        //driver loading
        try {
            //ojdbc8.jar 안에 있는 OracleDriver.class 파일
            Class.forName(driver);//.Class 타입으로 생성
            System.out.println("driver loading 성공!");

        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public void getConnection(){
        try {
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connection 성공!");
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void selectArticle(){
        this.getConnection(); //접속
        String sql = "SELECT * FROM DBTEST";

        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery(); //테이블 형태의 결과를 ResultSet에 저장.

            while(rs.next()){
                System.out.println(rs.getString("name") + "\t"
                + rs.getInt("age") + "\t"
                + rs.getDouble("height") + "\t"
                + rs.getString("logtime"));
            }

        } catch(SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(rs != null) rs.close(); //close 해주지 않으면 메모리에 계속 살아있다
                if(pstmt != null) pstmt.close();
                if(conn != null) conn.close();
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }


    }

    public static void main(String[] args){
        SelectMain sm = new SelectMain();
        sm.selectArticle();
    }
}
