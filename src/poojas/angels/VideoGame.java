package poojas.angels;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class VideoGame implements Serializable {

    private String name;
    private String genre;
    private String releaseDate;
    private double rating;
    private ESRB esrb;
    private Platform platform;
    private Company publisher;
    private Company developer;

    public VideoGame() {}

    /**
     *
     * @param name
     * @param genre
     * @param releaseDate
     * @param rating
     * @param esrb
     * @param platforms
     * @param publishers
     * @param developers
     */
    public VideoGame(String name, String genre, String releaseDate, double rating, ESRB esrb, Platform platform, Company publisher, Company developer) {
        this.name = name;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.rating = rating;
        this.esrb = esrb;
        this.platform = platform;
        this.publisher = publisher;
        this.developer = developer;
    }

    public String getName() {
        return this.name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return this.genre;
    }

    /**
     *
     * @param genre
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getReleaseDate() {
        return this.releaseDate;
    }

    /**
     *
     * @param releaseDate
     */
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public double getRating() {
        return this.rating;
    }

    /**
     *
     * @param rating
     */
    public void setRating(double rating) {
        this.rating = rating;
    }

    public ESRB getEsrb() {
        return this.esrb;
    }

    /**
     *
     * @param esrb
     */
    public void setEsrb(ESRB esrb) {
        this.esrb = esrb;
    }

    public Platform getPlatform() {
        return this.platform;
    }

    /**
     *
     * @param platform
     */
    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    public Company getPublisher() {
        return this.publisher;
    }

    /**
     *
     * @param publisher
     */
    public void setPublisher(Company publisher) {
        this.publisher = publisher;
    }

    public Company getDeveloper() {
        return this.developer;
    }

    /**
     *
     * @param developer
     */
    public void setDeveloper(Company developer) {
        this.developer = developer;
    }

    @Override
    public String toString() {

        return String.format("Name: %s%n"
                + "Genre: %s%n"
                + "Year: %s%n"
                + "Rating: %.1f%n"
                + "ESRB: %s%n"
                + "Platform(s): %s%n"
                + "Publisher: %s%n"
                + "Developer: %s%n",
                this.name, this.genre, this.releaseDate, this.rating,
                this.esrb.getAgeRange(), this.platform, this.publisher,
                this.developer
        );
    }

}
