package com.example.Alpha.Bean;

import org.springframework.context.annotation.Bean;


public class ImgBean {
    private String nameImg;
    private  Long size;

    private String path;



    private String type;

    public ImgBean() {
    }


    public ImgBean(String nameImg, Long size, String path, String type) {
        this.nameImg = nameImg;
        this.size = size;
        this.path = path;
        this.type = type;
    }

    public String getNameImg() {
        return nameImg;
    }

    public void setNameImg(String nameImg) {
        this.nameImg = nameImg;
    }


    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ImgBean{" +
                "nameImg='" + nameImg + '\'' +
                ", size=" + size +
                ", path='" + path + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
