package v3.round1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Manoj Khanna
 */

public class StoneGame {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(bufferedReader.readLine());
		for (int i = 1; i <= T; i++) {
			int N = Integer.parseInt(bufferedReader.readLine()),
					div = N / 4,
					mod = N % 4;

			if (mod <= 2) {
				System.out.println("Yes");
			} else {
				if (div % 2 == 0) {
					System.out.println("Yes");
				} else {
					System.out.println("No");
				}
			}
		}
	}

}
/*
* if (div % 2 == 0) {
				if (mod % 2 == 0) {
					System.out.println("No");
				} else {
					System.out.println("Yes");
				}
			} else {
				if (mod % 2 == 0) {
					System.out.println("Yes");
				} else {
					System.out.println("No");
				}
			}*/