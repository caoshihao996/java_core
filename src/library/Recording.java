package library;


import java.util.Date;

public class Recording extends CatalogItem{

    private String performer;
    private String format;

    public Recording(String code, String title, Date publishDate, String performer, String format) {
        super(code, title, publishDate);
        this.performer = performer;
        this.format = format;
    }

    public String getPerformer() {
        return performer;
    }

    public void setPerformer(String performer) {
        this.performer=performer;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format=format;
    }

    @Override
    public String toString() {
        return "Recording_" +getCode()+"_"+getTitle()+"_"+getPublishDate()+"_"+
                performer + "_" + format;
    }
}

