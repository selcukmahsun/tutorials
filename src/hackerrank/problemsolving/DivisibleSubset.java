package hackerrank.problemsolving;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result1 {

	/*
	 * Complete the 'nonDivisibleSubset' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts following
	 * parameters: 1. INTEGER k 2. INTEGER_ARRAY s
	 */

	public static int nonDivisibleSubset(int k, List<Integer> s) {

		Set<Integer> s1 = new HashSet<Integer>();
		int setSize;
		for (int i = 0; i < s.size(); i++) {
			setSize = 0;
			Set<Integer> s2 = new HashSet<Integer>();
			s2.add(s.get(i));
			for (int j = i + 1; j < s.size(); j++) {
				if ((s.get(i) + s.get(j)) % k != 0) {
					s2.add(s.get(j));
					++setSize;
				}
			}
			if (setSize > s1.size())
				s1 = s2;
			

		}
		return s1.size();

	}
}

public class DivisibleSubset {
	public static void main(String[] args) throws IOException {

		List<Integer> s3 = new ArrayList<Integer>();
		s3.add(1);
		s3.add(7);
		s3.add(2);
		s3.add(4);

		List<Integer> s4 = new ArrayList<Integer>();
		s4.add(278);
		s4.add(576);
		s4.add(496);
		s4.add(727);
		s4.add(410);
		s4.add(124);
		s4.add(338);
		s4.add(149);
		s4.add(209);
		s4.add(702);
		s4.add(282);
		s4.add(718);
		s4.add(771);
		s4.add(575);
		s4.add(436);

		List<Integer> s5 = new ArrayList<Integer>();

		s5.add(422346306);
		s5.add(940894801);
		s5.add(696810740);
		s5.add(862741861);
		s5.add(85835055);
		s5.add(313720373);
		int result = Result1.nonDivisibleSubset(7, s4);
		System.out.println(result);

	}
}
