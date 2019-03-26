package poojas.angels;

import java.util.ArrayList;
import java.util.Arrays;

public class VideoGame {

    private String name;
    private String genre;
    private int year;
    private double rating;
    private ESRB esrb;
    
    // ArrayLists are created in the VideoGame constructors because of how
    // Java converts arrays into an ArrayList using the ArrayList constructor.
    private ArrayList<Platform> platform;
    private ArrayList<Company> publishers;
    private ArrayList<Company> developers;

    public VideoGame() {
        this.platform = new ArrayList<>();
        this.publishers = new ArrayList<>();
        this.developers = new ArrayList<>();
    }

    /**
     *
     * @param name
     * @param genre
     * @param year
     * @param rating
     * @param esrb
     * @param platforms
     * @param publishers
     * @param developers
     */
    public VideoGame(String name, String genre, int year, double rating, ESRB esrb, Platform[] platforms, Company[] publishers, Company[] developers) {
        this.name = name;
        this.genre = genre;
        this.year = year;
        this.rating = rating;
        this.esrb = esrb;
        this.platform = new ArrayList<>(Arrays.asList(platforms));
        this.publishers = new ArrayList<>(Arrays.asList(publishers));
        this.developers = new ArrayList<>(Arrays.asList(developers));
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

    public int getYear() {
        return this.year;
    }

    /**
     *
     * @param year
     */
    public void setYear(int year) {
        this.year = year;
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

    public ArrayList<Platform> getPlatform() {
        return this.platform;
    }

    /**
     *
     * @param platform
     */
    public void setPlatform(ArrayList<Platform> platform) {
        this.platform = platform;
    }

    public ArrayList<Company> getPublishers() {
        return this.publishers;
    }

    /**
     *
     * @param publishers
     */
    public void setPublishers(ArrayList<Company> publishers) {
        this.publishers = publishers;
    }

    public ArrayList<Company> getDevelopers() {
        return this.developers;
    }

    /**
     *
     * @param developers
     */
    public void setDevelopers(ArrayList<Company> developers) {
        this.developers = developers;
    }

    @Override
    public String toString() {
        //return String.format("");
        return "";
    }

}
