package poojas.angels;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Bassam
 */
public class PoojasAngels {

    /**
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        final int RECORD_SIZE = 105;
        final int NAME_SIZE = 20;
        final int GENRE_SIZE = 10;
        final int DATE_SIZE = 10;
        final int RATING_SIZE = 2;
        final int ESRB_SIZE = 10;
        final int PLATFORM_SIZE = 10;
        final int PUBLISHER_SIZE = 20;
        final int DEVELOPER_SIZE = 20;

        String baseDatabase = "database\\videogamelist.txt";

        String ivansList = "database\\ivan\\videogamelist.txt";
        String mikesList = "database\\mike\\videogamelist.txt";
        String bassamsList = "database\\bassam\\videogamelist.txt";
        String sinasList = "database\\sina\\videogamelist.txt";

        RandomAccessFile raf = null;
        VideoGameList gameList = new VideoGameList();
        CompanyList companyList = new CompanyList();

        try {
            raf = new RandomAccessFile(baseDatabase, "rw");
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

        /*
        try {
            raf.seek(raf.length());
            FixedLengthStringIO.writeFixedLengthString("Overwatch", 20, raf);
            FixedLengthStringIO.writeFixedLengthString("fps", 10, raf);
            FixedLengthStringIO.writeFixedLengthString("05/24/2016", 10, raf);
            FixedLengthStringIO.writeFixedLengthString("9", 5, raf);
            FixedLengthStringIO.writeFixedLengthString("13+", 10, raf);
            FixedLengthStringIO.writeFixedLengthString("Windows", 10, raf);
            FixedLengthStringIO.writeFixedLengthString("Blizzard", 20, raf);
            FixedLengthStringIO.writeFixedLengthString("Blizzard", 20, raf);
        } catch (IOException ex) {
            Logger.getLogger(PoojasAngels.class.getName()).log(Level.SEVERE, null, ex);
        }
        */

        // Iterates through database file of patients and populates patient list
        try {
            for (int i = 0; i < raf.length() - RECORD_SIZE; i += RECORD_SIZE * 2) {
                raf.seek(i);
                String name = FixedLengthStringIO.readFixedLengthString(NAME_SIZE, raf);
                String genre = FixedLengthStringIO.readFixedLengthString(GENRE_SIZE, raf);
                String date = FixedLengthStringIO.readFixedLengthString(DATE_SIZE, raf);
                Integer rating = Integer.parseInt(FixedLengthStringIO.readFixedLengthString(RATING_SIZE, raf));
                String esrb = FixedLengthStringIO.readFixedLengthString(ESRB_SIZE, raf).trim();
                String platform = FixedLengthStringIO.readFixedLengthString(PLATFORM_SIZE, raf).trim();
                String publisher = FixedLengthStringIO.readFixedLengthString(PUBLISHER_SIZE, raf).trim();
                String developer = FixedLengthStringIO.readFixedLengthString(DEVELOPER_SIZE, raf).trim();
                
                ESRB esrbee = null;
                for (ESRB e : ESRB.values()) {
                    if (e.getAgeRange().equalsIgnoreCase(esrb)) {
                        esrbee = e;
                    }
                }

                Platform plat = null;
                for (Platform p : Platform.values()) {
                    if (p.getName().equalsIgnoreCase(platform)) {
                        plat = p;
                    }
                }

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

                gameList.addGame(new VideoGame(name, genre, date, rating, esrbee, plat, tmpPublisher, tmpDeveloper));

                
            }
        } catch (IOException ex) {
            //Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println(gameList);
        /*
        Company company = new Company("Jagex");

        VideoGame game = new VideoGame("Runescape",
                "mmorpg",
                2001,
                9.0,
                ESRB.EVERYONE,
                new Platform[]{Platform.WINDOWS, Platform.MAC_OS, Platform.LINUX},
                new Company[]{company},
                new Company[]{company});
         */

 /*
        FileOutputStream fo = new FileOutputStream(fileName);
        ObjectOutputStream oo = new ObjectOutputStream(fo);

        oo.writeObject(game);

        oo.close();
        fo.close();

        FileInputStream fi = new FileInputStream(fileName);
        ObjectInputStream oi = new ObjectInputStream(fi);

        VideoGame games = null;

        while (true) {
            try {
                games = (VideoGame) oi.readObject();

            } catch (EOFException e) {
                System.out.println("Reached End of File.");
                break;
            }
            System.out.println(games);
        }

        fi.close();
        oi.close();

        FileOutputStream fo = new FileOutputStream(fileName);
        ObjectOutputStream oo = new ObjectOutputStream(fo);

        oo.writeObject(games);

        fo.close();
        oo.close();*/
    }
}
