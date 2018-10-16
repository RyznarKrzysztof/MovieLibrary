import People.Actor;
import People.Director;

public class Movie {

    private String title;
    private Director director;
    private int year;
    private String genre;
    private Actor[] actors;

    public Movie(){};

    public Movie(String title, Director director, int year, String genre, Actor[] actors){
        this.title = title;
        this.director = director;
        this.year = year;
        this.genre = genre;
        this.actors = actors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Actor[] getActors() {
        return actors;
    }

    public void setActors(Actor[] actors) {
        this.actors = actors;
    }
}
