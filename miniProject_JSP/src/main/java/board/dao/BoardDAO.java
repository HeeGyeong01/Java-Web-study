package board.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import java.io.InputStream;

import board.bean.BoardDTO;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class BoardDAO {
    private SqlSessionFactory sqlSessionFactory;

    private static BoardDAO boardDAO = new BoardDAO();

    public static BoardDAO getInstance() { //싱글톤 스타일
        return boardDAO;
    }


    public BoardDAO() {
        try {
            InputStream inputStream = null;
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        }catch(IOException e){
            e.printStackTrace();
        }

    }


    public int boardWrite(Map<String, String> map){
        int updateCount = 0;

        SqlSession sqlSession = sqlSessionFactory.openSession(); //메소드 통해 객체 생성
        updateCount = sqlSession.insert("boardSQL.boardWrite", map );
        sqlSession.commit();
        sqlSession.close();

        return updateCount;


//        String sql = "insert into board(seq, id, name, email, subject, content, ref)"
//            + " values(seq_board.NEXTVAL,?, ?, ?, ?, ?, seq_board.CURRVAL)";
//
//        try{
//
//            pstmt.setString(1, map.get("id"));
//            pstmt.setString(2, map.get("name"));
//            pstmt.setString(3, map.get("email"));
//            pstmt.setString(4, map.get("subject"));
//            pstmt.setString(5, map.get("content"));

//
//        }

    }

    public List<BoardDTO> getBoardList(Map<String, Integer> map){
        List<BoardDTO> list = new ArrayList<BoardDTO>();
        SqlSession sqlSession = sqlSessionFactory.openSession(); //메소드 통해 객체 생성

        list = sqlSession.selectList("boardSQL.getBoardList", map);

//        String sql = "select * from "
//            + "(select rownum rn, tt.* from "
//            + "(select * from board order by ref desc, step asc) TT "
//            + ")where rn>=? and rn <=?";
//
//        try{
//            pstmt.setInt(1, (int)map.get("startNum"));
//            pstmt.setInt(2, (int)map.get("endNum"));
//
//            while(rs.next()){
//                BoardDTO boardDTO = new BoardDTO();
//                boardDTO.setSeq(rs.getInt("seq"));
//                boardDTO.setId(rs.getString("id"));
//                boardDTO.setName(rs.getString("name"));
//                list.add(boardDTO);
//            }
//
//        }

        return list;
    }

    public int getTotalA(){
        int totalArticle = 0;
        BoardDTO board = null;
        SqlSession sqlsession = sqlSessionFactory.openSession();
        totalArticle = sqlsession.selectOne("boardSQL.getTotalA");
        sqlsession.close();

        return totalArticle;

//        String sql = "SELECT COUNT(*) FROM BOARD";
//
//        try{
//            conn = ds.getConnection();
//            pstmt = conn.prepareStatement(sql); //생성
//            rs = pstmt.executeQuery(); //실행
//
//            if(rs.next()) {
//                totalArticle = rs.getInt(1);
//            }
//        }
//        }

    }

public BoardDTO getBoard(int seq){
    BoardDTO boardDTO = null;

    SqlSession sqlSession = sqlSessionFactory.openSession();
    boardDTO = sqlSession.selectOne("boardSQL.getBoard", seq);
    sqlSession.close();

    return boardDTO;


//    String sql = "select * from board where seq = ?";
//    try{
//        pstmt.setInt(1, seq);
//        rs = pstmt.executeQuery(); //실행 - 개수 리턴
//
//        while(rs.next()){
//            boardDTO.setSeq(rs.getInt("seq"));
//            boardDTO.setId(rs.getString("id"));
//            boardDTO.setName(rs.getString("name"));
//            boardDTO.setEmail(rs.getString("email"));
//
//        }
//
//    }
    }

    public List<BoardDTO> search(Map<String, String> map) {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<BoardDTO> list = sqlSession.selectList("boardSQL.search", map);

        sqlSession.close();
        return list;
    }

    public int searchSize(Map<String, String> map) {
        int totalA = 0;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        totalA = sqlSession.selectOne("boardSQL.searchSize", map);

        sqlSession.close();
        return totalA;
    }
}
