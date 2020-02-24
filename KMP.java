import java.io.*;
import java.util.*;

public class KMP {
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
        new KMP().run();
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
        String p = nextToken();
        String t = nextToken();

        List<Integer> pref = prefixFunction(p + "@" + t);
        int count = 0;
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < t.length(); i++) {
            if (pref.get(i + p.length() + 1) == p.length())
                res.add(i - p.length() + 2);
        }
        out.println(res.size());
        for (Integer re : res) {
            out.print(re + " ");
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