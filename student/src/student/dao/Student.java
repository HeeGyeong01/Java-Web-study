package student.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Student {

    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    private String driver = "oracle.jdbc.driver.OracleDriver";
    private String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private String username = "C##JAVA";
    private String password = "1234";

    public Student() {
        //driver loading
        try {
            Class.forName(driver);//.Class 타입으로 생성
            System.out.println("driver loading 성공!");

        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public void getConnection(){
        try {
            conn = DriverManager.getConnection(url, username, password);
            //System.out.println("Connection 성공!");


        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void menu(){
        Scanner scan = new Scanner(System.in);
        int no;
        while(true) {
            System.out.print("****************\n"
                + "   관리\n"
                + "****************\n"
                + "  1. 입력\n"
                + "  2. 검색\n"
                + "  3. 삭제\n"
                + "  4. 종료\n"
                + "****************\n"
                + "   번호 선택: ");

            no = scan.nextInt();

            if(no == 4) break;
            else if(no == 1) {
                insertArticle();
            } else if(no == 2) {
                selectArticle();

            } else if(no == 3) {
                deleteArticle();
            }
        }



    }

    public void insertArticle(){
        Scanner scan = new Scanner(System.in);
        int code;

        while(true) {
            System.out.print("\n****************\n"
                + "   1. 학생\n"
                + "   2. 교수\n"
                + "   3. 관리자\n"
                + "   4. 이전메뉴\n"
                + "****************\n"
                + "   번호 선택 : ");
            code = scan.nextInt();
            scan.nextLine();

            if(code == 4) break;

            String name = "";
            String value = "";

            System.out.print("이름 입력: ");
            name = scan.nextLine();

            switch(code) {
                case 1: //학생인 경우
                    System.out.print("학번 입력: ");
                    value = scan.nextLine();
                    break;
                case 2: //교수인 경우
                    System.out.print("과목 입력: ");
                    value = scan.nextLine();
                    break;
                case 3: //관리자인 경우
                    System.out.print("부서 입력: ");
                    value = scan.nextLine();
            }

            try {
                this.getConnection();
                String sql = "INSERT INTO student VALUES(?, ?, ?)";
                pstmt = conn.prepareStatement(sql);

                //?에 데이터 입력
                pstmt.setString(1, name);
                pstmt.setString(2, value);
                pstmt.setInt(3, code);

                int su = pstmt.executeUpdate(); //실행 되고 개수를 return 한다.
                System.out.println(su + " 행이 삽입되었습니다.");

            } catch(SQLException e) {
                e.printStackTrace();
            }finally{
                try {
                    if(pstmt != null) pstmt.close();
                    if(conn != null) conn.close();
                } catch(SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void selectArticle(){
        Scanner scan = new Scanner(System.in);
        String name = "";
        String value = "";
        int no;
        int code;

        while(true) {
            System.out.print("\n****************\n"
                + "   1. 이름 검색 (1개 글자가 포함된 이름은 모두 검색)\n"
                + "   2. 전체 검색\n"
                + "   3. 이전메뉴\n"
                + "****************\n"
                + "   번호선택 :");
            no = scan.nextInt();
            scan.nextLine();

            this.getConnection();

            if(no == 3) break;

            String sql = null;
            if(no ==1)
                sql = "SELECT * FROM STUDENT WHERE NAME LIKE ?";
            else if(no == 2)
                sql = "SELECT * FROM STUDENT";

            try{
                pstmt = conn.prepareStatement(sql);

                if(no == 1) pstmt.setString(1,  name );
                rs = pstmt.executeQuery(); //테이블 형태의 결과를 ResultSet에 저장.

                while(rs.next()){
                    System.out.println("이름 = "+ rs.getString("name"+ "\t"));

                    if(rs.getInt("code") == 1) //학생
                            System.out.println("  학번="+ rs.getString("value"));
                    else if(rs.getInt("code") == 2)
                            System.out.println("  과목="+ rs.getString("value"));
                    else if(rs.getInt("code") == 3)
                            System.out.println("  부서="+ rs.getString("value"));

                }}catch(java.sql.SQLException e){
                    e.printStackTrace();
            }finally{
                try {
                    if(pstmt != null) pstmt.close();
                    if(conn != null) conn.close();
                } catch(SQLException e) {
                    e.printStackTrace();
                }
            }


        }
    }

    public void deleteArticle() {
        Scanner scan = new Scanner(System.in);
        String name = "";
        int su = 0;

        System.out.print("삭제를 원하는 이름 입력 :");
        name = scan.nextLine();

        try {
            this.getConnection();
            String sql = "DELETE STUDENT WHERE NAME = ?";
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1,  name);

            su = pstmt.executeUpdate(); //실행 되고 개수를 return 한다.
            System.out.println(su + " 행이 삭제되었습니다.");


        } catch(SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                if(pstmt != null) pstmt.close();
                if(conn != null) conn.close();
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        Student st = new Student();
        st.menu();
        System.out.println("프로그램을 종료합니다.");

    }
}
