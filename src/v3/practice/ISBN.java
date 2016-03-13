package v3.practice;

import java.util.Scanner;

/**
 * @author Manoj Khanna
 */

public class ISBN {

    private static final String INVALID_INPUT = "INVALID INPUT";
    private static final String NO_SOLUTION_POSSIBLE = "NO SOLUTION POSSIBLE";

    public static void main(String[] args) {
        char[] chars = new Scanner(System.in).nextLine().toCharArray();
        if (chars.length != 10) {
            System.out.println(INVALID_INPUT);
            return;
        }

        int[] digits = new int[10];
        int unknownIndex = -1;
        for (int i = 0; i < 10; i++) {
            char c = chars[i];
            int digit = c - 48;
            if (digit < 0 || digit > 9) {
                if (c == '?') {
                    if (unknownIndex == -1) {
                        unknownIndex = i;
                    } else {
                        System.out.println(INVALID_INPUT);
                        return;
                    }
                } else if (i == 9 && c == 'X') {
                    digit = 10;
                } else {
                    System.out.println(INVALID_INPUT);
                    return;
                }
            }

            digits[i] = digit;
        }

        if (unknownIndex == -1) {
            System.out.println(INVALID_INPUT);
            return;
        }

        for (int i = 0, n = unknownIndex < 9 ? 9 : 10; i <= n; i++) {
            digits[unknownIndex] = i;

            int sum = 0;
            for (int j = 0; j < 10; j++) {
                sum += digits[j] * (10 - j);
            }

            if (sum % 11 == 0) {
                System.out.println(i);
                return;
            }
        }

        System.out.println(NO_SOLUTION_POSSIBLE);
    }

}
