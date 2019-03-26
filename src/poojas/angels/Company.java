package poojas.angels;

import java.util.ArrayList;
import java.util.Arrays;

public class Company {

    private String name;
    private ArrayList<VideoGame> published;
    private ArrayList<VideoGame> developed;

    public Company() {
        this.published = new ArrayList<>();
        this.developed = new ArrayList<>();
    }

    /**
     *
     * @param name
     */
    public Company(String name) {
        this.name = name;
    }

    /**
     *
     * @param name
     * @param published
     * @param developed
     */
    public Company(String name, VideoGame[] published, VideoGame[] developed) {
        this.name = name;
        this.published = new ArrayList<>(Arrays.asList(published));
        this.developed = new ArrayList<>(Arrays.asList(developed));
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

    public ArrayList<VideoGame> getPublished() {
        return this.published;
    }

    /**
     *
     * @param published
     */
    public void setPublished(ArrayList<VideoGame> published) {
        this.published = published;
    }

    public ArrayList<VideoGame> getDeveloped() {
        return this.developed;
    }

    /**
     *
     * @param developed
     */
    public void setDeveloped(ArrayList<VideoGame> developed) {
        this.developed = developed;
    }

    @Override
    public String toString() {
        return String.format("%s Published: %s, Developed: %s", this.name, this.published, this.developed);
    }

}
