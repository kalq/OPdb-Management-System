package poojas.angels;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * @author Bassam
 */
public class PoojasAngels {

    /**
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        String fileName = "database\\videogamelist.txt";
        /*
        Company company = new Company("Blizzard");
        
        VideoGame game = new VideoGame("Overwatch",
                "fps",
                2016,
                9.9,
                ESRB.TEEN,
                new Platform[]{Platform.WINDOWS, Platform.PS4, Platform.XBOX_ONE},
                new Company[]{company},
                new Company[]{company});
        
        FileOutputStream fo = new FileOutputStream(fileName);
        ObjectOutputStream oo = new ObjectOutputStream(fo);
        
        oo.writeObject(game);
        
        oo.close();
        fo.close();
         */
        FileInputStream fi = new FileInputStream(fileName);
        ObjectInputStream oi = new ObjectInputStream(fi);

        while (true) {
            try {
                VideoGame games = (VideoGame) oi.readObject();
                System.out.println(games);
            } catch (EOFException e) {
                System.out.println("Reached End of File.");
                break;
            }
        }

        fi.close();
        oi.close();
    }
}
