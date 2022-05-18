package com.example.evaluationtask;

public class ProcessesModel {

    int mainImg;
    String title;

    public ProcessesModel(int mainImg, String title) {
        this.mainImg = mainImg;
        this.title = title;
    }


    public int getMainImg() {
        return mainImg;
    }

    public void setMainImg(int mainImg) {
        this.mainImg = mainImg;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
