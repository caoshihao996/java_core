package library;

import java.util.Date;

public abstract class CatalogItem {
    private String code;
    private String title;
    private Date publishDate;

    public CatalogItem(String code, String title, Date publishDate) {
        this.code = code;
        this.title = title;
        this.publishDate = publishDate;
    }

    public String getCode(){
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle(){
        return this.title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date date) {
        this.publishDate=publishDate;
    }

    @Override
    public String toString() {
        return "CatalogItem [code=" + code + ", title=" + title + ", publishDate=" + publishDate + "]";
    }
}
