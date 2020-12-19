package hackerrank.problemsolving;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class HalloweenSale {

	static int howManyGames(int p, int d, int m, int s) {
		int gameCount = 0;
		while (s >= p) {
			++gameCount;
			s -= p;
			if (p - d >= m)
				p -= d;
			else
				p = m;
		}
		return gameCount;

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String[] pdms = scanner.nextLine().split(" ");

		int p = Integer.parseInt(pdms[0]);

		int d = Integer.parseInt(pdms[1]);

		int m = Integer.parseInt(pdms[2]);

		int s = Integer.parseInt(pdms[3]);

		int answer = howManyGames(p, d, m, s);

		bufferedWriter.write(String.valueOf(answer));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
