package es.uniovi.ds.lab.videostore;

public class Movie {
    private String title;
    private int category;

    public static final int STANDARD = 0;
    public static final int NEW_RELEASE = 1;
    public static final int CHILDREN = 2;

    public Movie(String title, int category) {
        this.title = title;
        this.category = category;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }
}
