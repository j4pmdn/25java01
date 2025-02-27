package com.coding.persistence;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "contents")
public class Content {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Title", nullable = false, length = 255)
    private String title;

    @Column(name = "Brief", nullable = false, length = 500)
    private String brief;

    @Column(name = "Content", nullable = false, columnDefinition = "NVARCHAR(MAX)")
    private String content;

    @Column(name = "CreateDate", updatable = false, columnDefinition = "DATETIME DEFAULT GETDATE()")
    private LocalDateTime createDate;

    @Column(name = "UpdateTime", columnDefinition = "DATETIME DEFAULT GETDATE()")
    private LocalDateTime updateTime;

    @Column(name = "Sort", nullable = false, columnDefinition = "INT DEFAULT 0")
    private int sort;
    
    @ManyToOne
    @JoinColumn(name = "AuthorId", nullable = false)
//    @JsonIgnore
    private Member author;

    public Content() {
    }

    public Content(String title, String brief, String content, Member author) {
        this.title = title;
        this.brief = brief;
        this.content = content;
        this.createDate = LocalDateTime.now();
        this.updateTime = LocalDateTime.now();
        this.sort = 0;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }
    
    public Member getAuthor() {
        return author;
    }

    public void setAuthor(Member author) {
        this.author = author;
    }
    
}