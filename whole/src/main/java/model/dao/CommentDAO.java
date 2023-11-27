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
                     rs.getDate("reg_date").toLocalDate(),
                     rs.getLong("comment_id"),
                     rs.getLong("user_id"),
                     rs.getString("comment_content")
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
    
   public Boolean registerComment(CommentEntity comment) throws SQLException {
       int rs = 0;

        Long postId = comment.getPostId();
        LocalDate regDate = comment.getRegDate();
        Long commentId = comment.getCommentId();
        Long userId = comment.getUserID();
        String content = comment.getContent();
        
        String sql = "INSERT INTO comment_table "
                + "(post_id, reg_date, comment_id, user_id, comment_content) "
                + "VALUES (? ,?, SEQUENCE_COMMENTID.nextval, ?, ?) ";
               
     jdbcUtil.setSqlAndParameters(sql, new Object[] {postId, regDate,commentId, userId ,content});        // JDBCUtil에 query문 설정
               
     try {
         rs = jdbcUtil.executeUpdate();         // query 실행      
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
   
//   deleteComment(Long commentId) : Boolean
   
   public Boolean deleteComment(Long commentId) throws SQLException {
       String sql = "DELETE FROM comment_table WHERE comment_id=?";  
       
       jdbcUtil.setSqlAndParameters(sql, new Object[] {commentId});   // JDBCUtil에 delete문과 매개 변수 설정

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

}
