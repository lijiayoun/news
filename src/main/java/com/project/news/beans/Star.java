package com.project.news.beans;

public class Star {
    private Long id;

    private Long memberId;

    private Long news;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getNews() {
        return news;
    }

    public void setNews(Long news) {
        this.news = news;
    }
}