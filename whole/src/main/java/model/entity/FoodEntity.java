package model.entity;


import java.sql.Date;
import java.time.LocalDate;

import model.enums.IsHealthy;

public class FoodEntity extends PostEntity {

    private String foodType;
    private Date expDate;
    private IsHealthy isHealthy;

    public FoodEntity()
    {
        super();
    }

    public FoodEntity(long postId, String title, String type, String content, String image,
            LocalDate regDate, Long writerId, String foodType, Date expDate) {

        super(postId, title, type, content, image, regDate, writerId);

        this.foodType = foodType;
        this.expDate = expDate;
    }

    public IsHealthy getIsHealthy() {
        return isHealthy;
    }

    public void setIsHealthy(IsHealthy isHealthy) {
        this.isHealthy = isHealthy;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    @Override

    public String toString() {

        return String.format("%d %15s %15s %15s %15s",
                postId, title, image, expDate, regDate);

    }
}