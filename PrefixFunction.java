import java.beans.IntrospectionException;
import java.io.*;
import java.util.*;

public class PrefixFunction {
    BufferedReader br;
    StringTokenizer in;
    PrintWriter out;

    public String nextToken() throws IOException {
        while (in == null || !in.hasMoreTokens()) {
            in = new StringTokenizer(br.readLine());
        }
        return in.nextToken();
    }

    public int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    public double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    public long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    public static void main(String[] args) throws IOException {
        new PrefixFunction().run();
    }

    public static List<Integer> prefixFunction(String s) {
        int len = s.length();
        List<Integer> res = new ArrayList<>(Collections.nCopies(len, 0));
        int t = 0;
        for (int i = 1; i < len; i++) {
            while ((t > 0) && (s.charAt(t) != s.charAt(i))) {
                t = res.get(t - 1);
            }
            if (s.charAt(i) == s.charAt(t))
                t++;
            res.set(i, t);
        }
        return res;
    }

    public void solve() throws IOException {
        String s = nextToken();

        List<Integer> res = new ArrayList<>();
        res = prefixFunction(s);

        if (2 * (s.length() - res.get(s.length() - 1)) > s.length()) {
            out.print(s.length());
        } else {
            out.print(s.length() - res.get(s.length() - 1));
        }

    }

    public void run() {
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);

            solve();

            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}