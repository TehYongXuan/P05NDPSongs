package sg.edu.rp.c346.id21010860.p05_ndpsongs;

import java.io.Serializable;

public class Song implements Serializable {

    private int id;
    private String title;
    private String singers;
    private int year;
    private int stars;



    public Song(int id, String title, String singers,int year,int stars) {
        this.id = id;
        this.title = title;
        this.singers = singers;
        this.year = year;
        this.stars = stars;

    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getSingers() { return singers; }
    public int getYear() { return year; }
    public int getStars() { return stars; }
    public void setTitle(String title) { this.title = title; }
    public void setSingers(String singers) { this.singers = singers; }
    public void setYear(int i) {this.year = year;}
    public void setStars(int rg) {this.stars = stars;}

    @Override
    public String toString() {
        return "Song name " + title + "\n " + "Song artist " + singers + "\n" + "Song Year " + year + "\n" + "Song Stars " + stars;
    }
}
