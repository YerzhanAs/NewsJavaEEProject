package kz.bitlab.model;

import java.sql.Timestamp;

public class News {
    private Long id;
    private Timestamp postDate;

    private NewsCategories categoryId;

    private String title;

    private String content;

    public News() {
    }

    public News(Long id, Timestamp postDate, NewsCategories categoryId, String text, String content) {
        this.id = id;
        this.postDate = postDate;
        this.categoryId = categoryId;
        this.title = text;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getPostDate() {
        return postDate;
    }

    public void setPostDate(Timestamp postDate) {
        this.postDate = postDate;
    }

    public NewsCategories getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(NewsCategories categoryId) {
        this.categoryId = categoryId;
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
}
