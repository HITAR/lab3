
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *…….
 */

public class Service {
/**
 *…….
 */
    static final int TN = 4;
    /**
     *…….
     */
    private float temp;
    /**
     *…….
     */
    private ArrayList <QoS> tp;
    /**
     *…….
     */
    private static String[] pro = new String [TN];
    /**
     *…….
     */
    private static BufferedReader bf;
    /**
     *…….
     */
    static final int SEVEN = 70000;
    /**
     *…….
     */
    static final int ONE = 100;
    /**
     *…….
     */
    static final int FIVE = 500;
    /**
     *…….
     *@throws IOException if has error.
     */
    public static void serVice() throws IOException {
        serviceWork();
     }
    /**
     *…….
     *@throws IOException if has error.
     */
    public static void serviceWork() throws IOException {
        String name = "SERVICE.txt";
        String name1 = "PROCESS.txt";
        ServiceHandle.serviceHandle(name);
        final int t = 3;
       bf = new BufferedReader(new FileReader(new File(name1)));
       pro[0] = bf.readLine();
       pro[1] = bf.readLine();
       pro[2] = bf.readLine();
       pro[t] = bf.readLine();
     //System.out.print(pro[0]);

       for (int i = 0; i <= t; i++) {
           pro[i] = pro[i].replaceAll("[^A-Z]", "");
           //pro[i].replaceAll("[^A-Z]"," ");
           //pro[i].replaceAll("[^A-Z]"," ");
       }
       //System.out.print(pro[0]+" ");
       for (int z = 0; z <= t; z++) {
           char[] pro0 = pro[z].toCharArray();
     //System.out.print(" "+pro0[0]+pro0[pro0.length]);
       for (int i = 0; i <= pro0.length - 1; i++) {
           for (int j = i + 1; j <= pro0.length - 1; j++) {
               if (pro0[j] == pro0[i]) {
                pro0[j] = ' ';
            }
           }
       }
       /*for(int i=0;i<=pro0.length-1;i++)
       System.out.print(pro0[i]);*/
       pro[z] = new String(pro0);
       pro[z] = pro[z].replaceAll("\\ ", "");
       System.out.print("\n" + pro[z] + "\n");
       }
       BufferedWriter rp = new BufferedWriter(new FileWriter("Ans.txt"));
       bf = new BufferedReader(new FileReader(new File(name1)));
       for (int i = 0; i <= t; i++) {
           String tmp = bf.readLine();
           //System.out.print(tmp);
           float rtF = 1, ptF = 0;     //rtF ptF是上个选择的值
           int no = 0;
           float rt = 0;
           float pt = 0;
        System.out.print(" " + i + " ");
        int nu = 0;
        int rem = 0;
        rt = ServiceHandle.service.get(0).reliaBility;
        pt = ServiceHandle.service.get(0).prIce;
        for (int j = 1; j <= ServiceHandle.service.size() - 1; j++) {
            if (j >= SEVEN) {
                System.out.print(j + ",");
            }
            if (pro[i].charAt(nu) == ServiceHandle.service.get(j).getcLass()) {
                if (rtF * ServiceHandle.service.get(j).reliaBility
                        - (ptF + ServiceHandle.service.get(j).prIce) / ONE
                        > rt - pt / ONE) {
                    rt = rtF * ServiceHandle.service.get(j).reliaBility;
                    pt = ptF + ServiceHandle.service.get(j).prIce;
                    rem = j + 1;
                }
                if (j == ServiceHandle.service.size() - 1) {
                    System.out.print(pro[i].charAt(nu)
                            + "-" + rem % FIVE + " ");
                    String k = pro[i].charAt(nu) + "-"
                            + Integer.toString(rem % FIVE);
                    String l = pro[i].charAt(nu) + "";
                        tmp = tmp.replaceAll(l, k);
                        //System.out.print(tmp);
                        rp.write(tmp);
                        rp.newLine();
                    System.out.print(j + "\n" + (rt - pt / ONE));
                    System.out.print("\nrt=" + rt + ",pt=" + pt + "\n");
                    break;
                }
           }  else if (nu == pro[i].length() - 1) {
                System.out.print(pro[i].charAt(nu) + "-" + rem % FIVE + " ");
                String k = pro[i].charAt(nu) + "-"
                          + Integer.toString(rem % FIVE);
                String l = pro[i].charAt(nu) + "";
                tmp = tmp.replaceAll(l, k);
                    System.out.print(tmp);
                    rp.write(tmp);
                    rp.newLine();
                System.out.print(j + "\n" + (rt - pt / ONE));
                System.out.print("\nrt=" + rt + ",pt=" + pt + "\n");
                break;
            } else if (pro[i].charAt(nu + 1)
                    == ServiceHandle.service.get(j).getcLass()) {
                System.out.print(pro[i].charAt(nu) + "-" + rem % FIVE + " ");
                String k = pro[i].charAt(nu) + "-"
                    + Integer.toString(rem % FIVE);
                String l = pro[i].charAt(nu) + "";
                tmp = tmp.replaceAll(l, k);
                nu++;
                rtF = rt;
                ptF = pt;
                rt = rtF * ServiceHandle.service.get(j).reliaBility;
                pt = ptF * ServiceHandle.service.get(j).prIce;
                continue;
                } else { continue; }
        }
        }
     rp.close();
    }
}
