package v4.round1;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author Manoj Khanna
 */

public class RobotsMove {

    private static InputReader in;
    private static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        if (Arrays.asList(args).contains("-local")) {
            try {
                in = new InputReader(new FileInputStream("in.txt"));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        } else {
            in = new InputReader(System.in);
        }

        new Solution().solve();

        out.close();
    }

    private static class Solution {

        public void solve() {
            int n = in.nextInt();

            for (int i = 0; i < n; i++) {
                long f = in.nextLong(),
                        b = in.nextLong(),
                        t = in.nextLong(),
                        d = in.nextLong();

                if (f > d) {
                    out.print(d * t);
                } else {
                    long x = (long) Math.ceil((double) (d - f) / (f - b));
                    out.print(x * (f + b) * t + ((d - (f - b) * x) * t));
                }

                if (i < n - 1) {
                    out.println("");
                }
            }
        }

    }

    @SuppressWarnings("UnusedDeclaration")
    private static class InputReader {

        private BufferedReader bufferedReader;
        private StringTokenizer stringTokenizer;

        public InputReader(InputStream inputStream) {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        }

        public String next() {
            while (stringTokenizer == null || !stringTokenizer.hasMoreTokens()) {
                try {
                    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            return stringTokenizer.nextToken();
        }

        public char nextChar() {
            return next().charAt(0);
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public float nextFloat() {
            return Float.parseFloat(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() {
            if (stringTokenizer != null && stringTokenizer.hasMoreTokens()) {
                return stringTokenizer.nextToken("");
            }

            try {
                return bufferedReader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

}
