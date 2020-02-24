import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class ZFunction {
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
        new ZFunction().run();
    }

    public static List<Integer> zfunction(String s) {
        ArrayList<Integer> z = new ArrayList<>();
        int left = 0;
        int right = 0;

        for (int i = 0; i < s.length(); i++) {
            z.add(-1);
        }


        for (int i = 1; i < s.length(); i++) {
            z.set(i, Math.max(0, Math.min(right - i, z.get(i - left))));
            while ((i + z.get(i) < s.length()) && s.charAt(z.get(i)) == s.charAt(z.get(i) + i))
                z.set(i, z.get(i) + 1);
            if (i + z.get(i) > right) {
                left = i;
                right = z.get(i) + i;
            }
        }
        return z;
    }

    public void solve() throws IOException {
        String s = nextToken();

        List<Integer> res = new ArrayList<>();
        res = zfunction(s);

        for (int i = 1; i < s.length(); i++) {
            out.print(res.get(i) + " ");
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