package test;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import model.dao.CommentDAO;
import model.entity.CommentEntity;

public class CommentTest {

    static CommentDAO commentDAO = new CommentDAO();
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) throws SQLException {
        
        //출력 
        printCommentList();
        
        // 입력
        
        // 삭
        
        
    }
    
    public static void printCommentList() throws SQLException {
        System.out.print("조회할 postId 입력 : ");
        List<CommentEntity> commentList = commentDAO.printCommentList(sc.nextLong());
        
        
        
    }

}
