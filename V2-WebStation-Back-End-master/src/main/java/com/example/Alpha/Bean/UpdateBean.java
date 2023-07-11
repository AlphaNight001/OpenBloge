package com.example.Alpha.Bean;

public class UpdateBean {

    private Integer id;

    private String html_Tag;

    private String update_Time;

    private String markdown_Code;


    public UpdateBean() {
    }

    public UpdateBean(Integer id, String html_Tag, String update_Time, String markdown_Code) {
        this.id = id;
        this.html_Tag = html_Tag;
        this.update_Time = update_Time;
        this.markdown_Code = markdown_Code;
    }

    public String getMarkdown_Code() {
        return markdown_Code;
    }

    public void setMarkdown_Code(String markdown_Code) {
        this.markdown_Code = markdown_Code;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHtml_Tag() {
        return html_Tag;
    }

    public void setHtml_Tag(String html_Tag) {
        this.html_Tag = html_Tag;
    }

    public String getUpdate_Time() {
        return update_Time;
    }

    public void setUpdate_Time(String update_Time) {
        this.update_Time = update_Time;
    }

    @Override
    public String toString() {
        return "UpdateBean{" +
                "id=" + id +
                ", html_Tag='" + html_Tag + '\'' +
                ", update_Time='" + update_Time + '\'' +
                ", markdown_Code='" + markdown_Code + '\'' +
                '}';
    }
}
