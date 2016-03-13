package v3.round2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * @author Manoj Khanna
 */

public class ValidSegments {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		String[] words = bufferedReader.readLine().toLowerCase().replaceAll("[\\.!]+", "").split(" ");

		String[] strings = bufferedReader.readLine().split(" ");
		int k = Integer.parseInt(strings[0]),
				lb = Integer.parseInt(strings[1]),
				ub = Integer.parseInt(strings[2]);

		HashSet<String> wordList = new HashSet<>(k);
		for (int i = 0; i < k; i++) {
			wordList.add(bufferedReader.readLine().toLowerCase());
		}

		int result = 0;
		for (int i = 0; i < words.length; i++) {
			if (!wordList.contains(words[i])) {
				continue;
			}

			HashSet<String> wordSet = new HashSet<>(ub);
			wordSet.add(words[i]);

			int last = -1;
			try {
				for (int j = lb - 1; j < ub; j++) {
					if (!wordList.contains(words[i + j])) {
						continue;
					}

					wordSet.add(words[i + j]);
					last = i + j;
					break;
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				last = -1;
			}

			if (last != -1) {
				if (wordSet.size() == wordList.size()) {
					result++;
				} else if (last - i - 1 >= wordList.size() - 2) {
					for (int j = i + 1; j < last; j++) {
						if (wordList.contains(words[j])) {
							wordSet.add(words[j]);
						}
					}

					if (wordSet.size() == wordList.size()) {
						result++;
					}
				}
			}
		}

		System.out.println(result);
	}

}
