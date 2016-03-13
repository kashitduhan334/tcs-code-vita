import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author Manoj Khanna
 */

public class FascinatingNumbers {

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

        private String zero(int n) {
            if (n <= 0) {
                return "";
            }

            char[] s = new char[n];

            for (int i = 0; i < n; i++) {
                s[i] = '0';
            }

            return new String(s);
        }

        private int print(String s, long l, long u) {
            long n = Long.parseLong(s);

            if (n < l) {
                return -1;
            } else if (n <= u) {
                out.println(n);
                return 0;
            } else {
                return 1;
            }
        }

        public void solve() {
            long l = in.nextLong(),
                    u = in.nextLong();

            String[] s = new String[]{"192", "219", "273", "327"};
            boolean[] b = new boolean[s.length];

            for (int i = 0; i <= 7; i++) {
                for (int j = 0; j < s.length; j++) {
                    String sj = s[j], s1, s2;

                    if (j % 2 != 0) {
                        s1 = sj.substring(0, 1) + zero(i) + sj.substring(1);
                        s2 = sj.substring(0, 1) + zero(i - 1) + sj.substring(1) + "0";
                    } else {
                        s1 = sj.substring(0, sj.length() - 1) + zero(i) + sj.substring(sj.length() - 1);
                        s2 = sj.substring(0, sj.length() - 1) + zero(i - 1) + sj.substring(sj.length() - 1) + "0";
                    }

                    int p1 = print(s1, l, u), p2 = 0;

                    if (i > 0 && !b[j]) {
                        p2 = print(s2, l, u);

                        if (p2 == 1) {
                            return;
                        }
                    }

                    if (p1 == 0) {
                        b[j] = p2 == 0;
                    } else if (p1 == 1) {
                        return;
                    }
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
