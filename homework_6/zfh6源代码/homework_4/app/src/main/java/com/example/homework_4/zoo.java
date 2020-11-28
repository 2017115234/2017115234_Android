package com.example.homework_4;

import android.widget.ImageView;

public class zoo {
    private String name;
    private int imageId;

    public zoo(String name, int imageId){
        this.name = name;
        this.imageId = imageId;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public int getImageId(){
        return imageId;
    }
}
