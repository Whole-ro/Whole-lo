package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.entity.CommentEntity;
import model.entity.MessageEntity;
import model.enums.BooleanEnum;
import model.enums.MessageType;

public class CommentDAO {
    
    private JDBCUtil jdbcUtil = null;
    
    public CommentDAO() {          
        jdbcUtil = new JDBCUtil();  // JDBCUtil 객체 생성
    }
    

//    public CommentEntity(Long postId, LocalDate regDate, Long commentId, Long userID, String content) {
//        super();
//        this.postId = postId;
//        this.regDate = regDate;
//        this.commentId = commentId;
//        this.userID = userID;
//        this.content = content;
//    }
//    POST_ID
//    REG_DATE
//    COMMENT_ID
//    USER_ID
//    COMMENT_CONTENT
    
    public List<CommentEntity> printCommentList(Long postId) throws SQLException {
        String sql = "SELECT reg_date, comment_id, user_id, comment_content "
                + "FROM comment_table "
                + "where post_id = ? ";
        
        
     jdbcUtil.setSqlAndParameters(sql, new Object[] { postId });        // JDBCUtil에 query문 설정
              
     List<CommentEntity> commentList = new ArrayList<>();
     try {
         ResultSet rs = jdbcUtil.executeQuery();         // query 실행                  
         while (rs.next()) {
             CommentEntity comment = new CommentEntity(
                     null,
                     rs.getDate("reg_date"),
                     rs.getLong("comment_id"),
                     rs.getLong("user_id"),
                     rs.getString("comment_content"),
                     );
             
             commentList.add(comment);
         }                        
         return commentList;
         
     } catch (Exception ex) {
         ex.printStackTrace();
     } finally {
         jdbcUtil.close();       // resource 반환
     }
     return null;
 }
    
//    registerComment(CommentEntity comment) : Boolean
   public Boolean registerComment(CommentEntity comment) throws SQLException {
       int rs = 0;

        String title = message.getTitle();
        String content = message.getContent();
        String img = message.getImage();
        LocalDate regDate = message.getRegDate();
        BooleanEnum isRead = message.getIsRead();
        MessageType messageType = message.getMsgType();
        Long senderId = message.getSenderId();
        Long receiverId = message.getReceiverId();
        Long postId = message.getPostId();
        
        String sql = "INSERT INTO message "
                + "(TITLE, CONTENT, IMAGE, REG_DATE, IS_READ, MSG_TYPE, MSG_ID, SENDER_ID, RECEIVER_ID, POST_ID) "
                + "VALUES (? ,?, ?, ?, ?, ?, SEQUENCE_MESSAGEID.nextval, ?, ?, ?) ";
               
     jdbcUtil.setSqlAndParameters(sql, new Object[] {title, content, img, regDate, isRead.toString(), messageType.toString(), senderId, receiverId,  postId });        // JDBCUtil에 query문 설정
               
     try {
         rs = jdbcUtil.executeUpdate();         // query 실행      
        System.out.print(rs);
         return true;
     } catch (Exception ex) {
         jdbcUtil.rollback();
         ex.printStackTrace();
     }finally {
         jdbcUtil.commit();
         jdbcUtil.close();       // resource 반환
     }
     return false;
 }
   
   public Boolean deleteMessage(Long id) throws SQLException {
       String sql = "DELETE FROM message WHERE msg_id=?";  
       
       jdbcUtil.setSqlAndParameters(sql, new Object[] {id});   // JDBCUtil에 delete문과 매개 변수 설정

       try {               
           jdbcUtil.executeUpdate();  // delete 문 실행
           return true;
       } catch (Exception ex) {
           jdbcUtil.rollback();
           ex.printStackTrace();
       }
       finally {
           jdbcUtil.commit();
           jdbcUtil.close();   // resource 반환
       }       
       return false;
       
    
    

}
