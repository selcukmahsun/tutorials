package hackerrank.problemsolving;

import java.util.Scanner;
import java.util.Scanner;

public class JavaOutputFormat {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("================================");
		for (int i = 0; i < 3; i++) {
			String s1 = sc.next();
			int x = sc.nextInt();
			String space = "";
			String zero = "";
			for (int j = 0; j < (15 - s1.length()); j++)
				space += " ";
			for (int k = 0; k < (3 - String.valueOf(x).length()); k++)
				zero += "0";
			System.out.println(s1 + space + zero + x);
		}

		System.out.println("================================");

	}
}
