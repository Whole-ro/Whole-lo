package model.entity;

import java.sql.Date;
import java.time.LocalDate;

public class ItemEntity extends PostEntity {

    private int cntLike;
    private int scrap;
    private Long price;
    private String detail;
    private String itemType;

    public ItemEntity() {
        super();
    }


    public ItemEntity(Long postId, String title, String type, String content, String image, LocalDate regDate,
            Long writerId, int cntLike, int scrap, Long price, String detail, String itemType) {
        super(postId, title, type, content, image, regDate, writerId);
        this.cntLike = cntLike;
        this.scrap = scrap;
        this.price = price;
        this.detail = detail;
        this.itemType = itemType;
    }


    public int getCntLike() {
        return cntLike;
    }


    public void setCntLike(int cntLike) {
        this.cntLike = cntLike;
    }


    public int getScrap() {
        return scrap;
    }


    public void setScrap(int scrap) {
        this.scrap = scrap;
    }


    public Long getPrice() {
        return price;
    }


    public void setPrice(Long price) {
        this.price = price;
    }


    public String getDetail() {
        return detail;
    }


    public void setDetail(String detail) {
        this.detail = detail;
    }


    public String getItemType() {
        return itemType;
    }


    public void setItemType(String itemType) {
        this.itemType = itemType;
    }


    @Override
    public String toString() {

        return String.format("%d %15s %15s %15s %15s %15s %d %d %d %d %15s", postId, title, type, image, content,
                regDate, writerId, cntLike, scrap, price, detail);

    }
}