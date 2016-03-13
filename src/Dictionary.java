import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * @author Manoj Khanna
 */

public class Dictionary {

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
            String[] words = in.nextLine()
                    .toLowerCase()
                    .split("[^A-Za-z0-9]+");

            Trie trie = new Trie();
            for (String word : words) {
                trie.add(word);
            }


        }

        private class Trie {

            private Node rootNode = new Node('\0');
            private int i;

            public void add(String word) {
                Node node = rootNode;
                for (int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    Node childNode = node.childNodeMap.get(c);
                    if (childNode == null) {
                        childNode = new Node(c);
                        node.childNodeMap.put(c, childNode);
                    }

                    node = childNode;
                }

                node.i = i++;
            }

            private class Node {

                private char c;
                private int i = -1;
                private TreeMap<Character, Node> childNodeMap = new TreeMap<>();

                public Node(char c) {
                    this.c = c;
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
