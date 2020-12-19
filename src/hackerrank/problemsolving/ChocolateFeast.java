package hackerrank.problemsolving;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ChocolateFeast {

	// Complete the chocolateFeast function below.
	static int chocolateFeast(int n, int c, int m) {
		int totalChocolate = n / c;
		int wrapper = totalChocolate;
		do {
			int chocolate = wrapper / m;

			totalChocolate += chocolate;
			wrapper = wrapper % m;
			wrapper += chocolate;

		} while (wrapper >= m);
		return totalChocolate;

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			String[] ncm = scanner.nextLine().split(" ");

			int n = Integer.parseInt(ncm[0]);

			int c = Integer.parseInt(ncm[1]);

			int m = Integer.parseInt(ncm[2]);

			int result = chocolateFeast(n, c, m);

			bufferedWriter.write(String.valueOf(result));
			bufferedWriter.newLine();
		}

		bufferedWriter.close();

		scanner.close();
	}
}
