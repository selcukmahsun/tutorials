package hackerrank.problemsolving;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CountingSort {

	// Complete the countingSort function below.
	static int[] countingSort1(int[] arr) {

		int enb = 0;
		for (int i = 0; i < arr.length; i++) {
			if (enb < arr[i])
				enb = arr[i];
		}

		int[] sort = new int[enb + 1];
		for (int i = 0; i < sort.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (i == arr[j])
					sort[i] += 1;
			}

		}
		return sort;

	}

	static int[] countingSort(int[] arr) {
		arr=countingSort1(arr);
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0)
				continue;
			else {
				for (int j = 0; j < arr[i]; j++) {
					list.add(i);
				}
			}

		}

		return list.stream().mapToInt(i -> i).toArray();

	}

	public static void main(String[] args) throws IOException {

		int[] arr = { 1, 1, 3, 2, 1 };
		int[] result = countingSort(arr);
		for (int i = 0; i < result.length; i++) {
			System.out.println("result[" + i + "]: " + result[i]);

		}

	}
}
