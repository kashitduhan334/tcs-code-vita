package v3.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Manoj Khanna
 */

public class Anagram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine()
                .toLowerCase()
                .split("[^\\w]+");

        char[][] chars = new char[words.length][];
        for (int i = 0; i < words.length; i++) {
            chars[i] = words[i].toCharArray();
        }

        ArrayList<ArrayList<String>> anagramList = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            char[] word1 = chars[i];
            if (word1 == null) {
                continue;
            }

            ArrayList<String> wordList = new ArrayList<>();
            String word1String = new String(word1);
            wordList.add(word1String);

            for (int j = 0; j < chars.length; j++) {
                char[] word2 = chars[j];
                if (i == j || word2 == null) {
                    continue;
                }

                String word2String = new String(word2);
                if (word1String.equals(word2String)) {
                    chars[j] = null;
                    continue;
                }

                if (isAnagram(word1, word2)) {
                    if (!wordList.contains(word2String)) {
                        wordList.add(word2String);
                    }

                    chars[j] = null;
                }
            }

            if (wordList.size() > 1) {
                anagramList.add(wordList);

                chars[i] = null;
            }
        }

        for (ArrayList<String> wordList : anagramList) {
            String line = "";
            for (String word : wordList) {
                line += " " + word;
            }
            System.out.println(line.substring(1));
        }
    }

    private static boolean isAnagram(char[] word1, char[] word2) {
        if (word1.length != word2.length) {
            return false;
        }

        word2 = Arrays.copyOf(word2, word2.length);
        int count = 0;
        for (int i = 0; i < word1.length; i++) {
            for (int j = 0; j < word2.length; j++) {
                if (word1[i] == word2[j]) {
                    count++;
                    word2[j] = ' ';
                    break;
                }
            }
        }

        return count == word1.length;
    }

}
