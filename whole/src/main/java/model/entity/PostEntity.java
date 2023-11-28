package model.entity;

import java.time.LocalDate;
import java.util.Date;

import model.enums.GenderEnum;

public class PostEntity extends UserEntity {
    protected Long postId;
    protected String title;
    protected String type;
    protected String content;
    protected String image;
    public PostEntity(Long postId, String title, String type, String content, String image, LocalDate regDate,
            Long writerId) {
        super();
        this.postId = postId;
        this.title = title;
        this.type = type;
        this.content = content;
        this.image = image;
        this.regDate = regDate;
        this.writerId = writerId;
    }


    protected LocalDate regDate;
    protected Long writerId;

    public PostEntity() {}
    public PostEntity(Long userId, String email, String password, String nickname, GenderEnum gender, String introduction, String interest,
            String address, int reportCount, Long postId, String title, String type, String content, String image,
            LocalDate regDate, Long writerIid) {
        super(userId, email, password, nickname, gender, introduction, interest, address, reportCount);
        this.postId = postId;
        this.title = title;
        this.type = type;
        this.content = content;
        this.image = image;
        this.regDate = regDate;
        this.writerId = writerId;    
    }

//    
//    public Food(long postId, String title, String type, String content, String image,
//            Date regDate, Long writerId, String food_type, Date exp_date) {
//
//        super(postId, title, type, content, image, regDate, writerId);
//
//        this.food_type = food_type;
//        this.exp_date = exp_date;
//    }
    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }
 
    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }

    public Long getWriterId() {
        return writerId;
    }

    public void setWriterId(Long writerId) {
        this.writerId = writerId;
    }
   
    
 @Override
    public String toString() {

        return String.format("%d %15s %15s %15s %15s %15s %d",
                postId, title, type,content, image, regDate, writerId);

    }
}
