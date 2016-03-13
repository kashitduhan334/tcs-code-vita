package v3.round2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Manoj Khanna
 */

public class SuperASCII {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(bufferedReader.readLine());
		for (int i = 1; i <= t; i++) {
			char[] chars = bufferedReader.readLine().toCharArray();
			int[] counts = new int[26];
			for (int j = 'a'; j <= 'z'; j++) {
				for (char c : chars) {
					if (c == j) {
						counts[j - 97]++;
					}
				}
			}

			int extras = 0;
			for (int j = 0; j < 26; j++) {
				if (counts[j] > j + 1) {
					extras += counts[j] - (j + 1);
					counts[j] = j + 1;
				}
			}

			int result = 0;
			for (int j = 0; j < 26; j++) {
				if (counts[j] == 0) {
					continue;
				}

				if (counts[j] < j + 1) {
					int temp = j + 1 - counts[j];

					if (extras >= temp) {
						extras -= temp;
						result += temp;
						counts[j] = j + 1;
					} else {
						int ac = (temp - extras) * 2,
								dc = counts[j] * 3;
						if (ac <= dc) {
							result += extras + ac;
							extras = 0;
							counts[j] = j + 1;
						} else {
							result += dc;
							extras += counts[j];
							counts[j] = 0;
						}
					}
				}
			}

//			int result = result;
			if (extras < 0) {
				result += extras * -2;
			} else if (extras > 0) {
				result += extras * 3;
			}

//			System.out.println(Arrays.toString(counts) + " " + extras + " " + result + " " + result);
			System.out.println(result);
		}
	}

}
