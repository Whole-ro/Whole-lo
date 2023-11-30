package model.dto;

import java.time.LocalDate;

public class MarketDTO {
	private Long postId;
    private String title;
    private String content;
    private String image;
    private LocalDate regDate;
    private Long writerId;

	private int cntLike;
    private int scrap;
    private Long price;
    private String detail;
    private String itemType;
    
    


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

}
