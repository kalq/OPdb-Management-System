package poojas.angels;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;

/**
 * @author Bassam
 */
public class PoojasAngels {

    /**
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        String baseDatabase = "database\\videogamelist.txt";
        
        String ivansList = "database\\ivan\\videogamelist.txt";
        String mikesList = "database\\mike\\videogamelist.txt";
        String bassamsList = "database\\bassam\\videogamelist.txt";
        String sinasList = "database\\sina\\videogamelist.txt";

        RandomAccessFile raf = new RandomAccessFile(baseDatabase, "rw");

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

        raf.seek(raf.length());
        raf.writeBytes("Runescape,");
        raf.writeBytes("mmorpg,");
        raf.writeBytes("2001,");
        raf.writeBytes("4.0,");
        raf.writeBytes("Everyone,");
        raf.writeBytes("Windows/MacOS/Linux,");
        raf.writeBytes("Jagex,");
        FixedLengthStringIO.writeFixedLengthString("Jagex", 50, raf);

        raf.seek(0);

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