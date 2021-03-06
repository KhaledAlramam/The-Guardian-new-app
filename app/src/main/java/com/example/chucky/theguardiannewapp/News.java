package com.example.chucky.theguardiannewapp;

/**
 * Created by chucky on 1/26/18.
 */

public class News {
    private String title,date,section,webUrl,writer;

    public News(String title,String date,String section,String webUrl,String writer){
        this.title=title;
        this.date= date != "" ? date : "Unknown";
        this.section=section;
        this.webUrl=webUrl;
        this.writer=writer != "" ? writer : "Unknown writer";
    }

    public String getWriter() {
        return writer;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public String getDate() {
        return date;
    }

    public String getSection() {
        return section;
    }

    public String getTitle() {
        return title;
    }
}
