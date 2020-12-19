package hackerrank.problemsolving;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MinimumDistances {

	static int minimumDistances(int[] a) {
		int distance = a.length - 1;
		boolean checkDistance = false;
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (j - i > distance)
					break;
				else if (a[i] == a[j]) {
					if (distance > j - i)
						distance = j - i;
					checkDistance = true;
				}
			}
		}
		return checkDistance ? distance : -1;

	}

	// Complete the minimumDistances function below.

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		int[] a = new int[n];
		String[] aItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		for (int i = 0; i < n; i++) {
			int aItem = Integer.parseInt(aItems[i]);
			a[i] = aItem;
		}
		int result = minimumDistances(a);
		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();
		bufferedWriter.close();
		scanner.close();
	}
}
