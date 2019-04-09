package poojas.angels;

import java.util.ArrayList;
import java.util.Arrays;

public class VideoGameList {

    private ArrayList<VideoGame> games;

    public VideoGameList() {
        this.games = new ArrayList<>();
    }

    /**
     *
     * @param games
     */
    public VideoGameList(VideoGame[] games) {
        this.games = new ArrayList<>(Arrays.asList(games));
    }

    public ArrayList<VideoGame> getGames() {
        return this.games;
    }

    /**
     *
     * @param games
     */
    public void setGames(ArrayList<VideoGame> games) {
        this.games = games;
    }

    /**
     *
     * @param game
     */
    public void addGame(VideoGame game) {
        this.games.add(game);
    }

    /**
     *
     * @param game
     */
    public void removeGame(VideoGame game) {
        this.games.remove(game);
    }

    public void sort() {
        // TODO - implement VideoGameList.sort
        throw new UnsupportedOperationException();
    }

    /**
     * A single line list of all Video Games
     * @return String representation
     */
    @Override
    public String toString() {
        String gameList = "";

        for (VideoGame game : this.games) {
            gameList += game  + "\n";
        }

        return gameList.trim();
    }

    public String reverseToString() {
        String gameList = "";
        
        for(int i = this.games.size() - 1; i >= 0; i--) {
            gameList += this.games.get(i) + "\n";
        }
        
        return gameList.trim();
    }
}
