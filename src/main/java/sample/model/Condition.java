package sample.model;

/**
 * Created by kmlsz on 17.11.2016.
 */
public class Condition {
    private String text;

    private String iconUrl;

    public Condition(String text, String iconUrl, int code) {
        this.text = text;
        this.iconUrl = iconUrl;
        this.code = code;
    }

    public Condition(String text, String iconUrl) {

        this.text = text;
        this.iconUrl = iconUrl;
    }

    public Condition(String text) {

        this.text = text;
    }

    public String getText() {

        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    private int code;

}
