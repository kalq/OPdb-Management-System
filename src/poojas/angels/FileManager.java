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

    private final static int RECORD_SIZE = 105;
    private final static int NAME_SIZE = 20;
    private final static int GENRE_SIZE = 10;
    private final static int DATE_SIZE = 10;
    private final static int RATING_SIZE = 2;
    private final static int ESRB_SIZE = 10;
    private final static int PLATFORM_SIZE = 10;
    private final static int PUBLISHER_SIZE = 20;
    private final static int DEVELOPER_SIZE = 20;

    private final static String DATABASE = "database\\videogamelist.txt";

    private static RandomAccessFile raf;

    public static VideoGameList getGameList() {
        return gameList;
    }

    public static void setGameList(VideoGameList gameList) {
        FileManager.gameList = gameList;
    }

    public static CompanyList getCompanyList() {
        return companyList;
    }

    public static void setCompanyList(CompanyList companyList) {
        FileManager.companyList = companyList;
    }
    private static VideoGameList gameList;
    private static CompanyList companyList;

    public static void readDatabase() {

        try {
            raf = new RandomAccessFile(DATABASE, "rw");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }

        gameList = new VideoGameList();
        companyList = new CompanyList();

        try {
            for (int i = 0; i < raf.length() - RECORD_SIZE; i += RECORD_SIZE * 2) {
                readRecord(i);
            }
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void readRecord(long position) throws IOException {
        raf.seek(position);

        String name = FixedLengthStringIO.readFixedLengthString(NAME_SIZE, raf);
        String genre = FixedLengthStringIO.readFixedLengthString(GENRE_SIZE, raf);
        String date = FixedLengthStringIO.readFixedLengthString(DATE_SIZE, raf);
        Integer rating = Integer.parseInt(FixedLengthStringIO.readFixedLengthString(RATING_SIZE, raf).trim());
        String esrb = FixedLengthStringIO.readFixedLengthString(ESRB_SIZE, raf).trim();
        String platform = FixedLengthStringIO.readFixedLengthString(PLATFORM_SIZE, raf).trim();
        String publisher = FixedLengthStringIO.readFixedLengthString(PUBLISHER_SIZE, raf).trim();
        String developer = FixedLengthStringIO.readFixedLengthString(DEVELOPER_SIZE, raf).trim();

        boolean exists = false;
        Company tmpPublisher = null;
        for (Company company : companyList.getCompanies()) {
            if (company.getName().equalsIgnoreCase(publisher)) {
                exists = true;
                tmpPublisher = company;
                break;
            }
        }

        if (!exists) {
            tmpPublisher = new Company(publisher);
            companyList.addCompany(tmpPublisher);
        }

        exists = false;
        Company tmpDeveloper = null;
        for (Company company : companyList.getCompanies()) {
            if (company.getName().equalsIgnoreCase(developer)) {
                exists = true;
                tmpDeveloper = company;
                break;
            }
        }

        if (!exists) {
            tmpDeveloper = new Company(developer);
            companyList.addCompany(tmpDeveloper);
        }

        gameList.addGame(new VideoGame(name, genre, date, rating, ESRB.valueOf(esrb), Platform.valueOf(platform), tmpPublisher, tmpDeveloper));
    }

    public static void writeRecord(String name, String genre, String date, String rating, String esrb, String platform, String publisher, String developer) throws IOException {
        raf.seek(raf.length());
        FixedLengthStringIO.writeFixedLengthString(name, NAME_SIZE, raf);
        FixedLengthStringIO.writeFixedLengthString(genre, GENRE_SIZE, raf);
        FixedLengthStringIO.writeFixedLengthString(date, DATE_SIZE, raf);
        FixedLengthStringIO.writeFixedLengthString(rating, RATING_SIZE, raf);
        FixedLengthStringIO.writeFixedLengthString(esrb, ESRB_SIZE, raf);
        FixedLengthStringIO.writeFixedLengthString(platform, PLATFORM_SIZE, raf);
        FixedLengthStringIO.writeFixedLengthString(publisher, PUBLISHER_SIZE, raf);
        FixedLengthStringIO.writeFixedLengthString(developer, DEVELOPER_SIZE, raf);
    }
}
