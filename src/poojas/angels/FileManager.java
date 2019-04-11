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

    private final static String DATABASE = "database\\videogamelist.txt";

    private static RandomAccessFile raf;
    private static VideoGameList gameList;

    public static void readDatabase() {

        try {
            raf = new RandomAccessFile(DATABASE, "rw");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }

        gameList = new VideoGameList();

        try {
            for (int i = 0; i < raf.length() - RECORD_SIZE; i += RECORD_SIZE * 2) {
                readRecord(i);
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

    public static void readRecord(long position) throws IOException {
        raf.seek(position);

        String name = FixedLengthStringIO.readFixedLengthString(NAME_SIZE, raf).trim();
        String genre = FixedLengthStringIO.readFixedLengthString(GENRE_SIZE, raf).trim();
        String date = FixedLengthStringIO.readFixedLengthString(DATE_SIZE, raf).trim();
        String rating = FixedLengthStringIO.readFixedLengthString(RATING_SIZE, raf).trim();
        String esrb = FixedLengthStringIO.readFixedLengthString(ESRB_SIZE, raf).trim();
        String platform = FixedLengthStringIO.readFixedLengthString(PLATFORM_SIZE, raf).trim();
        String publisher = FixedLengthStringIO.readFixedLengthString(PUBLISHER_SIZE, raf).trim();
        String developer = FixedLengthStringIO.readFixedLengthString(DEVELOPER_SIZE, raf).trim();

        gameList.addGame(new VideoGame(name, genre, date, Integer.parseInt(rating), ESRB.valueOf(esrb), Platform.valueOf(platform), publisher, developer));
    }

    public static void writeRecord(String name, String genre, String date, String rating, String esrb, String platform, String publisher, String developer) throws IOException {
        try {
            raf = new RandomAccessFile(DATABASE, "rw");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (int i = 0; i <= raf.length(); i += RECORD_SIZE * 2) {
            raf.seek(i);
            String record = i < raf.length() ? FixedLengthStringIO.readFixedLengthString(RECORD_SIZE, raf) : "";
            
            if (record.trim().isEmpty()) {
                raf.seek(i);

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

    public static void deleteRecord(int index) {
        try {
            raf = new RandomAccessFile(DATABASE, "rw");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            raf.seek(index - 1 * (RECORD_SIZE * 2));
            FixedLengthStringIO.writeFixedLengthString("", RECORD_SIZE, raf);
            
            raf.close();
        } catch (IOException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void editRecord(int index, String field, String data) {
        try {
            raf = new RandomAccessFile(DATABASE, "rw");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            raf.seek((index - 1) * (RECORD_SIZE * 2));

            if(!field.equalsIgnoreCase("name"))
                raf.seek(raf.getFilePointer() + NAME_SIZE * 2);
            else
                FixedLengthStringIO.writeFixedLengthString(data, NAME_SIZE, raf);

            if (!field.equalsIgnoreCase("genre"))
                raf.seek(raf.getFilePointer() + GENRE_SIZE * 2);
            else
                FixedLengthStringIO.writeFixedLengthString(data, GENRE_SIZE, raf);
            
            if (!field.equalsIgnoreCase("date"))
                raf.seek(raf.getFilePointer() + DATE_SIZE * 2);
            else
                FixedLengthStringIO.writeFixedLengthString(data, DATE_SIZE, raf);
            
            if (!field.equalsIgnoreCase("rating"))
                raf.seek(raf.getFilePointer() + RATING_SIZE * 2);
            else
                FixedLengthStringIO.writeFixedLengthString(data, RATING_SIZE, raf);
            
            if (!field.equalsIgnoreCase("esrb"))
                raf.seek(raf.getFilePointer() + ESRB_SIZE * 2);
            else
                FixedLengthStringIO.writeFixedLengthString(data, ESRB_SIZE, raf);
            
            if (!field.equalsIgnoreCase("platform"))
                raf.seek(raf.getFilePointer() + PLATFORM_SIZE * 2);
            else
                FixedLengthStringIO.writeFixedLengthString(data, PLATFORM_SIZE, raf);
            
            if (!field.equalsIgnoreCase("publisher"))
                raf.seek(raf.getFilePointer() + PUBLISHER_SIZE * 2);
            else
                FixedLengthStringIO.writeFixedLengthString(data, PUBLISHER_SIZE, raf);
            
            if (field.equalsIgnoreCase("developer"))
                FixedLengthStringIO.writeFixedLengthString(data, DEVELOPER_SIZE, raf);

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
}
