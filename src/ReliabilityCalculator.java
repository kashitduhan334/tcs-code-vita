import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author Manoj Khanna
 */

public class ReliabilityCalculator {

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

        public static final String INVALID_INPUT = "Invalid Input";

        private int nextInt() {
            try {
                return Integer.parseInt(in.nextLine());
            } catch (NumberFormatException e) {
                return -1;
            }
        }

        public void solve() {
            int n;
            while ((n = nextInt()) <= 0) {
                out.println(INVALID_INPUT);
            }

            int f;
            while ((f = nextInt()) < 0) {
                out.println(INVALID_INPUT);
            }

            int t;
            while ((t = nextInt()) <= 0 || t > n) {
                out.println(INVALID_INPUT);
            }

            if (f == 0) {
                out.println("0");
                out.println("0");
                out.print("100%");
            } else {
                float mtbf = (float) (n - t) / f,
                        mttr = (float) t / f;
                out.println(Math.round(mtbf));
                out.println(Math.round(mttr));
                out.print(Math.round(mtbf / (mtbf + mttr) * 100.0) + "%");
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
