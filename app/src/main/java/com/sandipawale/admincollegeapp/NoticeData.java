package com.sandipawale.admincollegeapp;

public class NoticeData {
    String title,image,date,time,key;

    public NoticeData() {
    }

    public NoticeData(String title, String image, String data, String time, String key) {
        this.title = title;
        this.image = image;
        this.date = date;
        this.time = time;
        this.key = key;
    }
    public String getTitle()
    {
        return title;
    }
}
