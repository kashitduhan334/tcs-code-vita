package v3.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class OldAnagram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        text = text.toLowerCase();
        ArrayList<LinkedHashSet<String>> anagrams = new ArrayList<>();
        Loop:
        for (String word : text.split("[^\\w]+")) {
            if (word.isEmpty()) {
                continue;
            }
            for (LinkedHashSet<String> anagram : anagrams) {
                String anagramWord = anagram.iterator().next();
                if (anagramWord.length() != word.length()) {
                    continue;
                }
                for (char letter : word.toCharArray()) {
                    int charPos = anagramWord.indexOf(letter);
                    if (charPos == 0) {
                        anagramWord = anagramWord.substring(1);
                    } else if (charPos > 0) {
                        anagramWord = anagramWord.substring(0, charPos) + anagramWord.substring(charPos + 1);
                    } else {
                        break;
                    }
                }
                if (anagramWord.isEmpty()) {
                    anagram.add(word);
                    continue Loop;
                }
            }
            anagrams.add(new LinkedHashSet<>(Arrays.asList(word)));
        }
        for (LinkedHashSet<String> anagram : anagrams) {
            if (anagram.size() < 2) {
                continue;
            }
            String anagramLine = "";
            for (String anagramWord : anagram) {
                anagramLine += anagramWord + " ";
            }
            System.out.println(anagramLine.substring(0, anagramLine.length() - 1));
        }
    }

}