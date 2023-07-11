package com.example.Alpha.Bean;

public class ArticalBean {
    private Integer id;
    private String artical_htmlTag;
    private String artical_markdownCode;
    private String artical_title;
    private String artical_kindOf;
    private String artical_time;
    private String artical_lastChangeTime;

    private String artical_kindOfTag;

    public ArticalBean() {
    }

    public ArticalBean(Integer id, String artical_htmlTag, String artical_markdownCode, String artical_title, String artical_kindOf, String artical_time, String artical_lastChangeTime, String artical_kindOfTag) {
        this.id = id;
        this.artical_htmlTag = artical_htmlTag;
        this.artical_markdownCode = artical_markdownCode;
        this.artical_title = artical_title;
        this.artical_kindOf = artical_kindOf;
        this.artical_time = artical_time;
        this.artical_lastChangeTime = artical_lastChangeTime;
        this.artical_kindOfTag = artical_kindOfTag;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getArtical_htmlTag() {
        return artical_htmlTag;
    }

    public void setArtical_htmlTag(String artical_htmlTag) {
        this.artical_htmlTag = artical_htmlTag;
    }

    public String getArtical_title() {
        return artical_title;
    }

    public void setArtical_title(String artical_title) {
        this.artical_title = artical_title;
    }

    public String getArtical_kindOf() {
        return artical_kindOf;
    }

    public void setArtical_kindOf(String artical_kindOf) {
        this.artical_kindOf = artical_kindOf;
    }

    public String getArtical_time() {
        return artical_time;
    }

    public void setArtical_time(String artical_time) {
        this.artical_time = artical_time;
    }

    public String getArtical_lastChangeTime() {
        return artical_lastChangeTime;
    }

    public void setArtical_lastChangeTime(String artical_lastChangeTime) {
        this.artical_lastChangeTime = artical_lastChangeTime;
    }

    public String getArtical_kindOfTag() {
        return artical_kindOfTag;
    }

    public void setArtical_kindOfTag(String artical_kindOfTag) {
        this.artical_kindOfTag = artical_kindOfTag;
    }


    public String getArtical_markdownCode() {
        return artical_markdownCode;
    }

    public void setArtical_markdownCode(String artical_markdownCode) {
        this.artical_markdownCode = artical_markdownCode;
    }

    @Override
    public String toString() {
        return "ArticalBean{" +
                "id=" + id +
                ", artical_htmlTag='" + artical_htmlTag + '\'' +
                ", artical_markdownCode='" + artical_markdownCode + '\'' +
                ", artical_title='" + artical_title + '\'' +
                ", artical_kindOf='" + artical_kindOf + '\'' +
                ", artical_time='" + artical_time + '\'' +
                ", artical_lastChangeTime='" + artical_lastChangeTime + '\'' +
                ", artical_kindOfTag='" + artical_kindOfTag + '\'' +
                '}';
    }
}
