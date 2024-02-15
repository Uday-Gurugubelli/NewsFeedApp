package com.example.newsfeedexample;

import java.util.ArrayList;

public class ApiNewsModelClass {
    private String status;
    private String totalResults;
    private ArrayList<NewsItemModelClass> articles;

    public ApiNewsModelClass(String status, String totalResults, ArrayList<NewsItemModelClass> articles) {
        this.status = status;
        this.totalResults = totalResults;
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public ArrayList<NewsItemModelClass> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<NewsItemModelClass> articles) {
        this.articles = articles;
    }
}
