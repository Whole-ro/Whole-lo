package model.dto;

import java.time.LocalDate;

import model.enums.IsHealthy;

public class FoodDTO {
    private Long postId;
    private String title;
    private String content;
    private String image;
    private LocalDate regDate;
    private Long writerId;
    private String foodType;
    private LocalDate expDate;
    private IsHealthy isHealthy;

    public FoodDTO() { //빈 생성자 
        
    }
    
    public FoodDTO(String title, String content, String image, Long writerId, String foodType,
            LocalDate expDate, IsHealthy isHealthy) {
       
        this.title = title;
        this.content = content;
        this.image = image;
        this.writerId = writerId;
        this.foodType = foodType;
        this.expDate = expDate;
        this.isHealthy = isHealthy; 
    }
    
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
    public String getFoodType() {
        return foodType;
    }
    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }
    public LocalDate getExpDate() {
        return expDate;
    }
    public void setExpDate(LocalDate expDate) {
        this.expDate = expDate;
    }
    public IsHealthy getIsHealthy() {
        return isHealthy;
    }
    public void setIsHealthy(IsHealthy isHealthy) {
        this.isHealthy = isHealthy;
    }


}