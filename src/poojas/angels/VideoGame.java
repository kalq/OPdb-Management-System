package poojas.angels;

import java.io.Serializable;

public class VideoGame implements Serializable {

    private String name;
    private String genre;
    private String releaseDate;
    private int rating;
    private ESRB esrb;
    private Platform platform;
    private String publisher;
    private String developer;
    private int index;

    public VideoGame() {
    }

    /**
     *
     * @param name
     * @param genre
     * @param releaseDate
     * @param rating
     * @param esrb
     * @param platform
     * @param publisher
     * @param developer
     */
    public VideoGame(String name, String genre, String releaseDate, int rating, ESRB esrb, Platform platform, String publisher, String developer) {
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

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
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

    public int getRating() {
        return this.rating;
    }

    /**
     *
     * @param rating
     */
    public void setRating(int rating) {
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

    public String getPublisher() {
        return this.publisher;
    }

    /**
     *
     * @param publisher
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getDeveloper() {
        return this.developer;
    }

    /**
     *
     * @param developer
     */
    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    @Override
    public String toString() {

        return String.format(
                "%-15s%s%n"
                + "%-15s%s%n"
                + "%-15s%s%n"
                + "%-15s%d%n"
                + "%-15s%s%n"
                + "%-15s%s%n"
                + "%-15s%s%n"
                + "%-15s%s%n",
                "Name:", this.name,
                "Genre:", this.genre,
                "Release Date:", this.releaseDate,
                "Rating:", this.rating,
                "ESRB:", this.esrb.getAgeRange(),
                "Platform:", this.platform.getName(),
                "Publisher:", this.publisher,
                "Developer:", this.developer
        );
    }

}
