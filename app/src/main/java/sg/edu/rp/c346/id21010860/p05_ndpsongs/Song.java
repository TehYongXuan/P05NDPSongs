package sg.edu.rp.c346.id21010860.p05_ndpsongs;

import java.io.Serializable;

public class Song implements Serializable {

    private int id;
    private String noteContent;
    private String title;
    private String singers;
    private int year;
    private int stars;

    public Song( String title, String singers, int year, int stars ) {
        this.id = id;
        this.title = title;
        this.singers = singers;
        this.year = year;
        this.stars = stars;
    }

    public int getId() {  return id;  }

    public String getTitle() { return title; }

    public void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
    }

    @Override
    public String toString() { return "ID:" + id + ", " + noteContent;  }

}
