package test;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import model.dao.CommentDAO;
import model.entity.CommentEntity;
import model.entity.MessageEntity;

public class CommentTest {

    static CommentDAO commentDAO = new CommentDAO();
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) throws SQLException {
        
        //출력 
        printCommentListByPostId();
        
        
//        public CommentEntity(Long postId, LocalDate regDate, Long commentId, Long userID, String content) {
//            super();
//            this.postId = postId;
//            this.regDate = regDate;
//            this.commentId = commentId;
//            this.userID = userID;
//            this.content = content;
//        }
        
        
        CommentEntity insertComment = new CommentEntity(
                1L, LocalDate.now(), null, 6L, "새 댓글입니다~"
                );
        
        System.out.println("\n넣을 데이터 : ");
        System.out.println("PostId : 1");
        System.out.println("등록일 : 11월 28일  : ");
        System.out.println("작성자 식별값  : 6");
        System.out.println("내용  : 새 댓글입니다~");
        
        // 입력
        if (commentDAO.registerComment(insertComment)){
            System.out.println("댓글 등록 성공 !");
            printCommentListByPostId();
        }else{
            System.out.println("댓글 등록 실패  !");
        }
        
        
        // 삭제 
        System.out.println("\n삭제할  댓글 식별값 : ");
        // 입력
        if (commentDAO.deleteComment(sc.nextLong())){
            System.out.println("댓글 삭제 성공 !");
            printCommentListByPostId();
        }else{
            System.out.println("댓글 삭제 실패  !");
        }
        
    }
    
    
    public static void printCommentListByPostId() throws SQLException {
        System.out.print("\n조회할 postId 입력 : ");
        List<CommentEntity> commentList = commentDAO.printCommentList(sc.nextLong());
        
        Iterator<CommentEntity> iter = commentList.iterator();
        System.out.println("등록일 \t댓 식별값 \t사용자 식별값 \t 내 \t");

        while (iter.hasNext()) {
            CommentEntity commentEntity = iter.next();
            
            System.out.println(commentEntity.getRegDate() + "\t" + commentEntity.getCommentId() + "\t"
                    + commentEntity.getUserID()+"\t"+commentEntity.getContent());
        }
        
        
    }

}
