package hackerrank.problemsolving;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BiggerisGreater {

	static String biggerIsGreater(String w) {

		StringBuilder response = new StringBuilder(w);
		boolean changed = false;
		int changeLocationI = -1;
		int changeLocationJ = -1;
		char changedItemI = 0;
		char changedItemJ = 0;

		for (int i = w.length() - 1; i > -1; i--) {
			if (changeLocationJ > i)
				break;
			for (int j = i - 1; j > -1; j--) {

				if (((int) w.charAt(i)) > ((int) w.charAt(j))) {
					if (j > changeLocationJ) {
						changeLocationI = i;
						changeLocationJ = j;
						changedItemI = w.charAt(j);
						changedItemJ = w.charAt(i);
						changed = true;
					}
				}

			}
		}

		if (changed) {

			response.setCharAt(changeLocationI, changedItemI);
			response.setCharAt(changeLocationJ, changedItemJ);

			for (int i = changeLocationJ + 1; i < response.length(); i++) {
				int x = 0;
				char temp = response.charAt(i);
				boolean issmallerthan = false;
				for (int j = i + 1; j < response.length(); j++) {
					if ((int) response.charAt(j) < (int) temp) {
						temp = response.charAt(j);
						issmallerthan = true;
						x = j;
					}

				}
				if (issmallerthan) {
					response.setCharAt(x, response.charAt(i));
					response.setCharAt(i, temp);
				}

			}

		}

		return response.toString().equals(w) ? "no answer" : response.toString();

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int T = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int TItr = 0; TItr < T; TItr++) {
			String w = scanner.nextLine();

			String result = biggerIsGreater(w);

			bufferedWriter.write(result);
			bufferedWriter.newLine();
		}

		bufferedWriter.close();

		scanner.close();
	}
}
