package model.entity;

import java.time.LocalDate;

public class CommentEntity {
//    POST_ID
//    REG_DATE
//    COMMENT_ID
//    USER_ID
//    COMMENT_CONTENT
//    
    private Long postId;
    private LocalDate regDate;
    private Long commentId;
    private Long userID;
    private String content;
      
    public CommentEntity(Long postId, LocalDate regDate, Long commentId, Long userID, String content) {
        super();
        this.postId = postId;
        this.regDate = regDate;
        this.commentId = commentId;
        this.userID = userID;
        this.content = content;
    }
    
    public Long getPostId() {
        return postId;
    }
    public void setPostId(Long postId) {
        this.postId = postId;
    }
    public LocalDate getRegDate() {
        return regDate;
    }
    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }
    public Long getCommentId() {
        return commentId;
    }
    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }
    public Long getUserID() {
        return userID;
    }
    public void setUserID(Long userID) {
        this.userID = userID;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    
    


}
