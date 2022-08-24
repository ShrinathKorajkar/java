package codecheif;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class LargestLaddu {
    static boolean yes = true;

    public static void main(String args[]) {
        try {
            BufferedInputStream bf = new BufferedInputStream(System.in);
            BufferedReader r = new BufferedReader(new InputStreamReader(bf, StandardCharsets.UTF_8));
            OutputStream out = new BufferedOutputStream(System.out);

            int t = Integer.parseInt(r.readLine().trim());
            while (t-- > 0) {
                int n = Integer.parseInt(r.readLine().trim());
                String[] sa = r.readLine().split(" ");
                String ret = "YES";
                long[] a = new long[1 << n];
                int m = 1 << n;
                for (int i = 0; i < m; i++)
                    a[i] = Long.parseLong(sa[i]);
                Arrays.sort(a);
                ret = (a[m - 1] - a[0] > 1) ? "NO" : "YES";
                out.write((ret + "\n").getBytes());
            }
            out.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
