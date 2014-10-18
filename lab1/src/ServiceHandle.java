import java.io.BufferedReader;
import java.io.File;
//import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//import java.io.Reader;
import java.util.ArrayList;
/**
 * ¡­¡­¡­¡­¡­¡­¡­¡­¡­¡­.
 */
public class ServiceHandle {
    /**
    * ¡­¡­¡­¡­¡­¡­¡­¡­¡­¡­.
    */
    private static BufferedReader bf;
    /**
     * ¡­¡­¡­¡­¡­¡­¡­¡­¡­¡­.
     */
    private static String tempString;
    /**
     * ¡­¡­¡­¡­¡­¡­¡­¡­¡­¡­.
     */
    static ArrayList<QoS> service = new ArrayList();
    /**
     *¡­¡­.
     *@throws IOException if has error.
     *@param name parameter additional(name)
     */
    public static void serviceHandle(final String name) throws IOException {
        final int tTREE = 3;
        final int fOUR = 4;
        bf = new BufferedReader(new FileReader(new File(name)));
        while ((tempString = bf.readLine()) != null) {
            tempString.trim();
            String[] temp = tempString.split(" ");
            QoS s = new QoS(temp[0], Float.parseFloat(temp[1]),
                    Float.parseFloat(temp[2]), Float.parseFloat(temp[tTREE]),
                    Float.parseFloat(temp[fOUR]));
            service.add(s);
        }
    }
}

/**
 * ¡­¡­¡­¡­¡­¡­¡­¡­¡­¡­.
 */
class QoS {
    /**
     * ¡­¡­¡­¡­¡­¡­¡­¡­¡­¡­.
     */
    private String name;
    /**
    * ¡­¡­¡­¡­¡­¡­¡­¡­¡­¡­.
    */
    public float reliaBility;
    /**
     * ¡­¡­¡­¡­¡­¡­¡­¡­¡­¡­.
     */
    public float prIce;
    /**
    * ¡­¡­¡­¡­¡­¡­¡­¡­¡­¡­.
    */
    private float unknown1, unknown2;

    /**
     * ¡­¡­¡­¡­¡­¡­¡­¡­¡­¡­.
     * @param n (n)
     * @param x1 (x1)
     * @param x2 (x2)
     * @param x3 (x3)
     * @param x4 (x4)
     */
    public QoS(final String n, final float x1, final float x2,
            final float x3, final float x4) {
    /**
    * ¡­¡­¡­¡­¡­¡­¡­¡­¡­¡­.
    */
        this.name = n;
        /**
    * ¡­¡­¡­¡­¡­¡­¡­¡­¡­¡­.
    */
        this.unknown1 = x1;
        /**
    * ¡­¡­¡­¡­¡­¡­¡­¡­¡­¡­.
    */
        this.reliaBility = x2;
        /**
    * ¡­¡­¡­¡­¡­¡­¡­¡­¡­¡­.
    */
        this.unknown2 = x3;
        /**
    * ¡­¡­¡­¡­¡­¡­¡­¡­¡­¡­.
    */
        this.prIce = x4;
        /**
    * ¡­¡­¡­¡­¡­¡­¡­¡­¡­¡­.
    */
        }
    /**
     * ¡­¡­¡­¡­¡­¡­¡­¡­¡­¡­.
     * @return name.charAt(0)
     */
    public char getcLass() {
        return name.charAt(0);
        }
}
