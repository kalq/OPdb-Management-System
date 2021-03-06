package poojas.angels;

import OPbd_User_Interface.HomeController;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Bassam
 */
public class FileManager {

    //-----Fixed Character Size for each field in record-------\\
    private final static int NAME_SIZE = 20;
    private final static int GENRE_SIZE = 10;
    private final static int DATE_SIZE = 10;
    private final static int RATING_SIZE = 2;
    private final static int ESRB_SIZE = 10;
    private final static int PLATFORM_SIZE = 10;
    private final static int PUBLISHER_SIZE = 20;
    private final static int DEVELOPER_SIZE = 20;
    private final static int RECORD_SIZE = NAME_SIZE + GENRE_SIZE
            + DATE_SIZE + RATING_SIZE + ESRB_SIZE + PLATFORM_SIZE
            + PUBLISHER_SIZE + DEVELOPER_SIZE;

    //-----The path to OPdb's RandomAccessFile-------\\
    private final static String DATABASE = "database\\videogamelist.txt";

    private static RandomAccessFile raf;
    private static VideoGameList gameList;
    private static int index = 1;

    /**
     * @method readDatabase() goes through the entire videogamelist.txt records
     * and reads all data for outputting to the TableView in the Home Page.
     */
    public static void readDatabase() {

        try {
            raf = new RandomAccessFile(DATABASE, "rw");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }

        gameList = new VideoGameList();

        try {
            // Iterates through the database file
            for (int i = 0; i < raf.length() - RECORD_SIZE; i += RECORD_SIZE * 2) {
                raf.seek(i);

                String record = i < raf.length() ? FixedLengthStringIO.readFixedLengthString(RECORD_SIZE, raf) : "";

                // Checks to see if record is empty, this happens if a previous
                // record was deleted, only reads the record if it is not empty.
                if (!record.trim().isEmpty()) {
                    readRecord(i);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            raf.close();
        } catch (IOException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void resetIndex() {
        index = 1;
    }

    /**
     * Reads record as position
     *
     * @param position
     * @throws IOException
     */
    public static void readRecord(long position) throws IOException {
        raf.seek(position);

        // Reads each record field
        String name = FixedLengthStringIO.readFixedLengthString(NAME_SIZE, raf).trim();
        String genre = FixedLengthStringIO.readFixedLengthString(GENRE_SIZE, raf).trim();
        String date = FixedLengthStringIO.readFixedLengthString(DATE_SIZE, raf).trim();
        String rating = FixedLengthStringIO.readFixedLengthString(RATING_SIZE, raf).trim();
        String esrb = FixedLengthStringIO.readFixedLengthString(ESRB_SIZE, raf).trim();
        String platform = FixedLengthStringIO.readFixedLengthString(PLATFORM_SIZE, raf).trim();
        String publisher = FixedLengthStringIO.readFixedLengthString(PUBLISHER_SIZE, raf).trim();
        String developer = FixedLengthStringIO.readFixedLengthString(DEVELOPER_SIZE, raf).trim();

        // Creates a new video game object with the read fields
        VideoGame g = new VideoGame(name, genre, date, Integer.parseInt(rating), ESRB.valueOf(esrb), Platform.valueOf(platform), publisher, developer);
        g.setIndex(index++);

        // Adds game to game list
        gameList.addGame(g);

    }

    /**
     * Finds an empty record and writes to it
     *
     * @param name
     * @param genre
     * @param date
     * @param rating
     * @param esrb
     * @param platform
     * @param publisher
     * @param developer
     * @throws IOException
     */
    public static void writeRecord(String name, String genre, String date, String rating, String esrb, String platform, String publisher, String developer) throws IOException {
        try {
            raf = new RandomAccessFile(DATABASE, "rw");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Loops through the Database are writes a new record in the position of a
        // previously deleted record. If none are found, adds record to the end of
        // the file
        for (int i = 0; i <= raf.length(); i += RECORD_SIZE * 2) {
            raf.seek(i);
            String record = i < raf.length() ? FixedLengthStringIO.readFixedLengthString(RECORD_SIZE, raf) : "";

            if (record.trim().isEmpty()) {
                raf.seek(i);

                // Writes each field once a spot in the database is found then exits the loop
                FixedLengthStringIO.writeFixedLengthString(name, NAME_SIZE, raf);
                FixedLengthStringIO.writeFixedLengthString(genre, GENRE_SIZE, raf);
                FixedLengthStringIO.writeFixedLengthString(date, DATE_SIZE, raf);
                FixedLengthStringIO.writeFixedLengthString(rating, RATING_SIZE, raf);
                FixedLengthStringIO.writeFixedLengthString(esrb, ESRB_SIZE, raf);
                FixedLengthStringIO.writeFixedLengthString(platform, PLATFORM_SIZE, raf);
                FixedLengthStringIO.writeFixedLengthString(publisher, PUBLISHER_SIZE, raf);
                FixedLengthStringIO.writeFixedLengthString(developer, DEVELOPER_SIZE, raf);
                break;
            }
        }
        raf.close();
    }

    /**
     * Loops to delete record
     *
     * @param index
     */
    public static void deleteRecord(int index) {
        try {
            raf = new RandomAccessFile(DATABASE, "rw");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            // Loops through the database to find the record with the right index. Replaces it with an empty record.
            for (int i = ((index - 1) * (RECORD_SIZE * 2)); i < raf.length(); i += RECORD_SIZE * 2) {
                raf.seek(i);
                String record = i < raf.length() ? FixedLengthStringIO.readFixedLengthString(RECORD_SIZE, raf) : "";

                if (!record.trim().isEmpty()) {
                    raf.seek(i);
                    FixedLengthStringIO.writeFixedLengthString("", RECORD_SIZE, raf);
                    break;
                }
            }

            raf.close();
        } catch (IOException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Gets index position, then seeks to appropriate field and edits it with
     * provided data param
     *
     * @param index
     * @param field
     * @param data
     */
    public static void editRecord(int index, String field, String data) {
        try {
            raf = new RandomAccessFile(DATABASE, "rw");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Seeks to record index, then goes to field position
        try {
            for (int i = ((index - 1) * (RECORD_SIZE * 2)); i < raf.length(); i += RECORD_SIZE * 2) {
                raf.seek(i);
                String record = i < raf.length() ? FixedLengthStringIO.readFixedLengthString(RECORD_SIZE, raf) : "";

                if (!record.trim().isEmpty()) {
                    raf.seek(i);
                    
                    if (!field.equalsIgnoreCase("name")) {
                        raf.seek(raf.getFilePointer() + NAME_SIZE * 2);
                    } else {
                        FixedLengthStringIO.writeFixedLengthString(data, NAME_SIZE, raf);
                    }

                    if (!field.equalsIgnoreCase("genre")) {
                        raf.seek(raf.getFilePointer() + GENRE_SIZE * 2);
                    } else {
                        FixedLengthStringIO.writeFixedLengthString(data, GENRE_SIZE, raf);
                    }

                    if (!field.equalsIgnoreCase("date")) {
                        raf.seek(raf.getFilePointer() + DATE_SIZE * 2);
                    } else {
                        FixedLengthStringIO.writeFixedLengthString(data, DATE_SIZE, raf);
                    }

                    if (!field.equalsIgnoreCase("rating")) {
                        raf.seek(raf.getFilePointer() + RATING_SIZE * 2);
                    } else {
                        FixedLengthStringIO.writeFixedLengthString(data, RATING_SIZE, raf);
                    }

                    if (!field.equalsIgnoreCase("esrb")) {
                        raf.seek(raf.getFilePointer() + ESRB_SIZE * 2);
                    } else {
                        FixedLengthStringIO.writeFixedLengthString(data, ESRB_SIZE, raf);
                    }

                    if (!field.equalsIgnoreCase("platform")) {
                        raf.seek(raf.getFilePointer() + PLATFORM_SIZE * 2);
                    } else {
                        FixedLengthStringIO.writeFixedLengthString(data, PLATFORM_SIZE, raf);
                    }

                    if (!field.equalsIgnoreCase("publisher")) {
                        raf.seek(raf.getFilePointer() + PUBLISHER_SIZE * 2);
                    } else {
                        FixedLengthStringIO.writeFixedLengthString(data, PUBLISHER_SIZE, raf);
                    }

                    if (field.equalsIgnoreCase("developer")) {
                        FixedLengthStringIO.writeFixedLengthString(data, DEVELOPER_SIZE, raf);
                    }
                }
            }
            raf.close();
        } catch (IOException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static VideoGameList getGameList() {
        return gameList;
    }

    public static void setGameList(VideoGameList gameList) {
        FileManager.gameList = gameList;
    }

    /**
     * @method testIndex() returns the maximum index number of our Random Access
     * File.
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static long testIndex() throws FileNotFoundException, IOException {
        raf = new RandomAccessFile(DATABASE, "r");
        long index = raf.length() / RECORD_SIZE;

        return index;
    }
}
