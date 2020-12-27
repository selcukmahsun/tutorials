package hackerrank.problemsolving;

import java.io.IOException;

public class StrangeCounter {

	// Complete the strangeCounter function below.
	static long strangeCounter(long t) {
		boolean run = true;
		long i = 0;
		long value = 0;
		long result = 0;
		long time = 0;
		do {
			value = (long) (3 * Math.pow(2, i));
			time += value;
			if (time < t) {
				++i;
				continue;
			} else {
				time = time - value + 1;
				result = value - (t - time);
				run = false;
			}

		} while (run);

		return result;

	}

	public static void main(String[] args) throws IOException {

		long t = 17;
		long result = strangeCounter(t);
		System.out.println(result);

	}
}
