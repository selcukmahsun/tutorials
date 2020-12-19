package hackerrank.problemsolving;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class TheTimeinWords {

	// Complete the timeInWords function below.
	static String timeInWords(int h, int m) {
		HashMap<Integer, String> list = new HashMap<Integer, String>();

		list.put(1, "one");
		list.put(2, "two");
		list.put(3, "three");
		list.put(4, "four");
		list.put(5, "five");
		list.put(6, "six");
		list.put(7, "seven");
		list.put(8, "eight");
		list.put(9, "nine");
		list.put(10, "ten");
		list.put(11, "eleven");
		list.put(12, "twelve");
		list.put(13, "thirteen");
		list.put(14, "fourteen");
		list.put(15, "fifteen");
		list.put(16, "sixteen");
		list.put(17, "seventeen");
		list.put(18, "eighteen");
		list.put(19, "nineteen");
		list.put(20, "twenty");

		if (m == 0) {
			return list.get(h) + " o' clock";
		} else if (m == 15)
			return "quarter past " + list.get(h);
		else if (m == 1)
			return list.get(m) + " minute past " + list.get(h);
		else if (m <= 20)
			return list.get(m) + " minutes past " + list.get(h);
		else if (m < 30) {
			return list.get(20) + " " + list.get(m % 20) + " minutes past " + list.get(h);
		} else if (m == 30)
			return "half past " + list.get(h);
		else if (m == 45)
			return "quarter to " + list.get(h + 1);
		else if ((60 - m) < 20)
			return list.get(60 - m) + " minutes to " + list.get(h + 1);
		else {
			return list.get(20) + " " + list.get((60 - m) % 20) + " minutes to " + list.get(h + 1);
		}

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int h = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int m = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String result = timeInWords(h, m);

		bufferedWriter.write(result);
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
