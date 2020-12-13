package hackerrank.problemsolving;

import java.util.Scanner;

public class ModifiedKaprekarNumbers {

	// Complete the kaprekarNumbers function below.
	static void kaprekarNumbers(int p, int q) {
		long powVal;
		String s;
		int firstpart;
		int secondpart;
		boolean check_is_not_empty = false;
		for (int i = p; i <= q; i++) {
			powVal = (long) Math.pow(i, 2);
			s = String.valueOf(powVal);
			if ((s.length() % 2 == 0)) {

				firstpart = Integer.parseInt(s.substring(0, (s.length() / 2)));
				secondpart = Integer.parseInt(s.substring(s.length() / 2, s.length()));
				if (i != (firstpart + secondpart))
					continue;
				else {
					check_is_not_empty = true;
					System.out.print(String.valueOf(i) + " ");
				}
			} else if (s.length() == 1) {
				firstpart = Integer.parseInt(s.substring(0, (s.length())));
				if (i == firstpart) {
					check_is_not_empty = true;
					System.out.print(String.valueOf(i) + " ");
				}

			} else if (s.length() % 2 == 1) {

				firstpart = Integer.parseInt(s.substring(0, (s.length() - 1) / 2));
				secondpart = Integer.parseInt(s.substring((s.length() - 1) / 2, s.length()));
				if ((firstpart + secondpart) == i) {
					check_is_not_empty = true;
					System.out.print(String.valueOf(i) + " ");

				}
			}
		}
		if (!check_is_not_empty)
			System.out.println("INVALID RANGE");
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int p = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		kaprekarNumbers(p, q);

		scanner.close();
	}
}
