package hackerrank.problemsolving;

public class RepeatedString {

	static long repeatedString(String s, long n) {
		long count = 0;
		int mod = (int) (n % s.length());
		int mod_count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'a') {
				++count;
				if (mod > i)
					++mod_count;

			}
		}
		return count * (n / s.length()) + mod_count;

	}

	public static void main(String[] args) {

		String s = "a";
		long n = 1000000000000L;
		long result = repeatedString(s, n);
		System.out.println(result);

	}
}