package kz.bitlab.model;

import java.sql.Timestamp;

public class Comment {

    private Long id;

    private String comment;

    private Timestamp postDate;

    private Users userId;

    private News newsId;

    public Comment() {
    }

    public Comment(Long id, String comment, Timestamp postDate, Users userId, News newsId) {
        this.id = id;
        this.comment = comment;
        this.postDate = postDate;
        this.userId = userId;
        this.newsId = newsId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Timestamp getPostDate() {
        return postDate;
    }

    public void setPostDate(Timestamp postDate) {
        this.postDate = postDate;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
    }

    public News getNewsId() {
        return newsId;
    }

    public void setNewsId(News newsId) {
        this.newsId = newsId;
    }
}
