package dbtest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateMain {

    private Connection conn;
    private PreparedStatement pstmt;

    private String driver = "oracle.jdbc.driver.OracleDriver";
    private String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private String username = "C##JAVA";
    private String password = "1234";

    public UpdateMain() {
        //생성자는 딱 한번만 실행된다.
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
        //Connection은 인터페이스이고 이것을 오버라이딩한 클래스 없어서
        //DriverManager의 getConnection() 메소드로 만들음.
        //thin : 오라클 드라이버의 이름
        try {
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connection 성공!");
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateArticle(){
        Scanner scan = new Scanner(System.in);
        System.out.print("검색할 이름 입력: ");
        String name = scan.next();


        this.getConnection(); //접속

        try {
            // = WHERE NAME LIKE ?
            // = setString(1, "%"+name+"%");
            pstmt = conn.prepareStatement("UPDATE DBTEST SET AGE=AGE+1, HEIGHT=HEIGHT+1 WHERE REGEXP_LIKE(NAME, ?)");

            //?에 데이터 입력
            pstmt.setString(1, name);
//            pstmt.setInt(2, age);
//            pstmt.setDouble(3, height);


            int su = pstmt.executeUpdate(); //실행 되고 개수를 return 한다.
            System.out.println(su + " 행이 삽입되었습니다.");

        } catch(SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(pstmt != null) pstmt.close();
                if(conn != null) conn.close();
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        UpdateMain im = new UpdateMain();
        im.updateArticle();

    }
}
