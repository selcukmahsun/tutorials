package hackerrank.problemsolving;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class diagonalDifference {

	/*
	 * Complete the 'diagonalDifference' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts
	 * 2D_INTEGER_ARRAY arr as parameter.
	 */

	public static int diagonalDifference(List<List<Integer>> arr) {
		int left_to_right = 0;
		int right_to_left = 0;
		int rows = arr.size();
		int columns = arr.get(0).size();
		int i = 0;
		int j = 0;
		int l = rows ;
		System.out.println("arr.size() " + arr.size());
		System.out.println("arr.get(0).size() " + arr.get(0).size());
		while (i < rows && j < columns && l >0) {
			System.out.println("arr.get("+i+").get("+j+") " + arr.get(i).get(j));
			System.out.println("arr.get("+i+").get("+l+ ") " + arr.get(i).get(l));
			left_to_right += arr.get(i).get(j);
			right_to_left += arr.get(i).get(l);
			i += 1;
			j += 1;
			l -= 1;

		}
		return Math.abs(left_to_right - right_to_left);

	}

}

class Solution1 {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = Integer.parseInt(bufferedReader.readLine().trim());

		List<List<Integer>> arr = new ArrayList<>();

		IntStream.range(0, n).forEach(i -> {
			try {
				arr.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt)
						.collect(toList()));
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		int result = diagonalDifference.diagonalDifference(arr);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
