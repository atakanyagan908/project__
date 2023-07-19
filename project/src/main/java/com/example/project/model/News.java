package com.example.project.model;

import jakarta.persistence.*;

@Entity
@Table(name = "news")
public class News extends Event {

    @Column(name = "news_link")
    private String newsLink;

    public String getNewsLink() {
        return newsLink;
    }

    public void setNewsLink(String newsLink) {
        this.newsLink = newsLink;
    }



}
