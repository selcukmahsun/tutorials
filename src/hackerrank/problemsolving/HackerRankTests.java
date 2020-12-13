package hackerrank.problemsolving;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HackerRankTests {

	public static void main(String[] args) {

		/*
		 * int i = 6; drawsybmol(i); int[] arr = { 793810624, 895642170, 685903712,
		 * 623789054, 468592370 }; miniMaxSum(arr);
		 * 
		 * System.out.println(timeConversion("12:45:54PM"));
		 * System.out.println(kangaroo(4523, 8092, 9419, 8076)); pageCount(6, 2);
		 * 
		 * int s[][] = { { 4, 8, 2 }, { 4, 5, 7 }, { 6, 1, 6 } }; //
		 * extraLongFactorials(25); int[] ss = { 13, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5,
		 * 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 };
		 * 
		 * int[] ss1 = { 6, 3, 6, 3, 1, 7, 3, 7, 1, 6, 7, 4, 7, 4, 3, 2, 4, 2, 5, 4, 3,
		 * 6, 7, 6, 2, 5 };
		 * 
		 * designerPdfViewer(ss1, "abc"); queensAttack(8, 0, 4, 4, null);
		 */

		/*
		 * Integer integerArray[] = { 4, 3, 1, 2, 2, 5, 5, 1, 4, 7, 8 }; List<Integer>
		 * integerList = new ArrayList<>(Arrays.asList(integerArray));
		 * System.out.println(pickingNumbers(integerList));
		 */

		System.out.println(taumBday(95677, 39394, 86983, 311224, 588538));

		int[] p = { 0, 0, 1, 0, 0, 1, 1, 0 };

		System.out.println(findDigits(1012));

		System.out.println("test");
		System.out.println(Math.sqrt(25) % 1 == 0);
		System.out.println(Math.floor(Math.sqrt(26)));

		System.out.println((int) Math.sqrt(24));
		// encryption("haveaniceday");

		// encryption("feedthedog");

		System.out.println(encryption("chillout"));

	}

	private static void drawsybmol(int n) {

		String k = "";
		String space;

		for (int i = 0; i < n; i++) {
			space = "";
			for (int j = 1; j < n - i; j++) {
				space += " ";
			}
			k += "#";
			System.out.println(space + k);
		}

	}

	static void miniMaxSum(int[] arr) {

		long[] m = new long[arr.length];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (i == j)
					continue;
				else {
					m[i] += arr[j];
				}
			}
		}
		long minSum = m[0];
		long maxSum = m[0];
		for (int i = 0; i < m.length; i++) {
			if (minSum > m[i])
				minSum = m[i];
			if (maxSum < m[i])
				maxSum = m[i];
		}
		System.out.println(minSum + " " + maxSum);
	}

	public static int birthdayCakeCandles(List<Integer> candles) {
		Map<Integer, Integer> userMap = new HashMap<Integer, Integer>();

		for (int i = 0; i < candles.size(); i++) {
			if (userMap.containsKey(candles.get(i))) {
				userMap.put(candles.get(i), userMap.get(candles.get(i)) + 1);
			} else
				userMap.put(candles.get(i), 1);
		}

		return maxUsingCollectionsMaxAndLambda(userMap);

	}

	public static <K, V extends Comparable<V>> V maxUsingCollectionsMaxAndLambda(Map<K, V> map) {
		Entry<K, V> maxEntry = Collections.max(map.entrySet(),
				(Entry<K, V> e1, Entry<K, V> e2) -> e1.getValue().compareTo(e2.getValue()));
		return maxEntry.getValue();
	}

	static String timeConversion(String s) {
		String listTime[] = s.split(":");
		int hour = Integer.parseInt(listTime[0]);
		String caser = listTime[2].substring(2, 4);

		if (listTime[0].equals("12")) {
			if (caser.equals("AM"))
				listTime[0] = "00";
		} else if (caser.equals("PM")) {
			listTime[0] = (hour + 12) + "";
		}
		return listTime[0] + ":" + listTime[1] + ":" + listTime[2].substring(0, 2);

	}

	public static List<Integer> gradingStudents(List<Integer> grades) {
		List<Integer> list = new ArrayList<Integer>();
		for (Integer integer : grades) {
			if (integer < 38)
				list.add(integer);
			else if (integer % 5 > 2)
				list.add((integer - (integer % 5) + 5));
			else
				list.add(integer);

		}
		return list;

	}

	static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
		int apple = 0;
		int orange = 0;
		for (int i = 0; i < apples.length; i++) {

			if (s <= (apples[i] + a) && (apples[i] + a) <= t)
				++apple;
		}
		for (int i = 0; i < oranges.length; i++) {
			if (s <= (oranges[i] + b) && (oranges[i] + b) <= t)
				++orange;

		}
		System.out.println(apple);
		System.out.println(orange);

	}

	static String kangaroo(int x1, int v1, int x2, int v2) {
		int fark = x2 - x1;
		String result = "NO";
		while (x1 <= x2) {
			x1 += v1;
			x2 += v2;
			if (x1 == x2) {
				result = "YES";
				break;

			}
		}
		return result;

	}

	public static int getTotalX(List<Integer> a, List<Integer> b) {
		boolean var, var2;
		int i;
		int j;
		int m = 0;

		for (i = a.get(a.size() - 1); i <= b.get(0); i++) {
			var = false;
			for (j = 0; j < a.size(); j++) {
				if (i % a.get(j) == 0) {
					var = true;
				} else {
					var = false;
					break;
				}
			}
			if (var == true) {
				var2 = false;
				for (int k = 0; k < b.size(); k++) {
					if (b.get(k) % i == 0) {
						var2 = true;
					} else {
						var2 = false;
						break;
					}

				}
				if (var2 == true) {
					m++;
				}
			}
		}
		return m;

	}

	static int[] breakingRecords(int[] scores) {
		int[] records = new int[2];
		int countHighest = 0;
		int countLowest = 0;
		int highestScore = scores[0];
		int lowestScore = scores[0];
		for (int i = 0; i < scores.length; i++) {
			if (highestScore < scores[i]) {
				++countHighest;
				highestScore = scores[i];
			} else if (lowestScore > scores[i]) {
				++countLowest;
				lowestScore = scores[i];
			}
		}
		records[0] = countHighest;
		records[1] = countLowest;
		return records;

	}

	static int birthday(List<Integer> s, int d, int m) {
		int peace = 0;
		for (int i = 0; i < s.size(); i++) {
			int square = 0;

			for (int j = i; j < (i + m); j++) {
				if ((i + m) > s.size())
					break;
				else {
					square += s.get(j);
				}
			}
			if (square == d)
				++peace;
		}
		return peace;
	}

	static int divisibleSumPairs(int n, int k, int[] ar) {
		int count = 0;
		for (int i = 0; i < ar.length; i++) {
			for (int j = i + 1; j < ar.length; j++) {
				if ((ar[i] + ar[j]) % k == 0)
					++count;
			}
		}
		return count;
	}

	static int migratoryBirds(List<Integer> arr) {

		Set<Integer> set = new HashSet<>();
		set.addAll(arr);
		int birdTypeCount = 0;
		int birdtype = arr.get(0);

		for (Integer bType : set) {
			int tempBirtypeCount = 0;
			for (int i = 0; i < arr.size(); i++) {
				if (tempBirtypeCount * 2 >= arr.size()) {
					return bType;
				} else if (bType.equals(arr.get(i)))
					++tempBirtypeCount;
			}
			birdtype = birdtype;
			if (birdTypeCount < tempBirtypeCount) {
				birdTypeCount = tempBirtypeCount;
				birdtype = bType;
			} else if (birdTypeCount == tempBirtypeCount) {
				if (birdtype > bType) {
					birdtype = bType;
				}
			}
		}
		return birdtype;

	}

	static String dayOfProgrammer(int year) {
		String answerDate = "";
		Calendar ca = Calendar.getInstance();
		if (year < 1918 && year % 100 == 0) {
			answerDate = getDate(ca, year, 255);
		} else if (year == 1918) {
			answerDate = getDate(ca, year, 269);
		} else {
			answerDate = getDate(ca, year, 256);
		}
		return answerDate;

	}

	static String getDate(Calendar ca, int year, int day) {
		ca.set(ca.YEAR, year);
		ca.set(ca.DAY_OF_YEAR, day);
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		return sdf.format(ca.getTime());

	}

	static void bonAppetit(List<Integer> bill, int k, int b) {
		int totalBill = 0;
		for (int i = 0; i < bill.size(); i++) {
			if (i == k) {
				continue;
			}
			totalBill += bill.get(i);
		}
		System.out.println(((totalBill / 2 == b) ? "Bon Appetit" : b - totalBill / 2));

	}

	static int sockMerchant(int n, int[] ar) {
		int pairCount = 0;
		HashMap<Integer, Integer> sockList = new HashMap<Integer, Integer>();
		for (int i = 0; i < ar.length; i++) {
			if (sockList.containsKey(ar[i]))
				sockList.put(ar[i], sockList.get(ar[i]) + 1);
			else {
				sockList.put(ar[i], 1);
			}
		}

		for (int i : sockList.keySet()) {
			if (sockList.get(i).equals(1))
				sockList.remove(i);
		}

		for (int i : sockList.values()) {
			pairCount += (i % 2 == 1) ? (i - 1) / 2 : i / 2;
		}
		return pairCount;

	}

	static int pageCount(int n, int p) {
		int sf = 0;
		int sn = 0;
		if (n % 2 == 0) {
			n = n + 1;
		}
		for (int i = 2; i <= n; i = i + 2) {
			if ((i - 2) == p || (i - 1) == p) {
				break;
			}
			++sf;
		}
		System.out.println("sf :" + sf);
		for (int i = n - 2; i >= 0; i = i - 2) {

			if ((i + 2) == p || (i + 1) == p) {
				break;
			}
			++sn;
		}

		System.out.println("sn :" + sn);
		return sf < sn ? sf : sn;

	}

	public static int countingValleys(int steps, String path) {

		int seaside = 0;
		int valleyCount = 0;
		boolean valley = false;
		for (int i = 0; i < path.length(); i++) {
			seaside = (path.charAt(i) == 'U') ? (seaside + 1) : (seaside - 1);
			if (seaside < 0) {
				valley = true;
			}
			if (seaside == 0 && valley) {
				++valleyCount;
				valley = false;
			}
		}
		return valleyCount;

	}

	static int getMoneySpent(int[] keyboards, int[] drives, int b) {
		int totalCost = -1;
		for (int i = 0; i < drives.length; i++) {
			for (int j = 0; j < keyboards.length; j++) {
				if ((drives[i] + keyboards[j]) > totalCost && (drives[i] + keyboards[j]) <= b)
					totalCost = drives[i] + keyboards[j];
			}
		}
		return totalCost;

	}

	static String catAndMouse(int x, int y, int z) {

		return (Math.abs(x - z) == Math.abs(y - z)) ? "Mouse C"
				: (Math.abs(x - z) < Math.abs(y - z)) ? "Cat A" : "Cat B";

	}

	/*
	 * static void extraLongFactorials(int n) { Double factor = new Double(1); do {
	 * factor *= n; --n; } while (n > 1); BigInteger factor1 = new
	 * BigInteger(factor.toString()); System.out.println(factor); }
	 */

	static int hurdleRace(int k, int[] height) {
		int drink = 0;
		for (int i = 0; i < height.length; i++)
			if ((k - height[i]) < 0)
				drink = (Math.abs(k - height[i]) > drink) ? Math.abs(k - height[i]) : drink;
		return drink;

	}

	static int designerPdfViewer(int[] h, String word) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("a", 1);
		map.put("b", 2);
		map.put("c", 3);
		map.put("d", 4);
		map.put("e", 5);
		map.put("f", 6);
		map.put("g", 7);
		map.put("h", 8);
		map.put("i", 9);
		map.put("j", 10);
		map.put("k", 11);
		map.put("l", 12);
		map.put("m", 13);
		map.put("n", 14);
		map.put("o", 15);
		map.put("p", 16);
		map.put("q", 17);
		map.put("r", 18);
		map.put("s", 19);
		map.put("t", 20);
		map.put("u", 21);
		map.put("v", 22);
		map.put("w", 23);
		map.put("x", 24);
		map.put("y", 25);
		map.put("z", 26);
		int tallestLetter = 0;
		for (char i = 0; i < word.length(); i++) {
			tallestLetter = (h[map.get(String.valueOf(word.charAt(i))) - 1] > tallestLetter)
					? h[map.get(String.valueOf(word.charAt(i))) - 1]
					: tallestLetter;
		}
		return tallestLetter * word.length();
	}



	public static int pickingNumbers(List<Integer> a) {

		Collections.sort(a);
		int i = 0;
		int start = 0;
		int max = 0;
		while (i < a.size()) {
			if (Math.abs(a.get(start) - a.get(i)) > 1) {
				start = i;
			}
			max = Math.max(max, i - start + 1);
			i++;
		}
		i--;
		System.out.println(a);
		System.out.println(Math.max(max, i - start + 1));
		return Math.max(max, i - start + 1);

	}

	public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {

		List<Integer> rank = new ArrayList<Integer>();
		ranked = new ArrayList<Integer>();

		player = new ArrayList<Integer>();
		ranked.add(100);
		ranked.add(100);
		ranked.add(50);
		ranked.add(40);
		ranked.add(40);
		ranked.add(100);
		ranked.add(20);
		ranked.add(10);

		player.add(5);
		player.add(25);
		player.add(50);
		player.add(120);

		for (int i = 0; i < ranked.size(); i++) {
			for (int j = i; j < ranked.size(); j++) {
				if (ranked.get(i) == ranked.get(j)) {
					break;
				}

			}
		}

		Set<Integer> set = new HashSet<Integer>();
		set.addAll(ranked);
		List<Integer> setList = new ArrayList<>(set);
		Collections.sort(setList);
		boolean checklastVal;
		for (int i = 0; i < player.size(); i++) {
			checklastVal = true;
			for (int j = setList.size() - 1; j >= 0; j--) {
				if (player.get(i) >= setList.get(j)) {
					rank.add(setList.size() - j);
					checklastVal = false;
					break;
				}
			}
			if (checklastVal) {
				rank.add(setList.size() + 1);
			}

		}

		System.out.println("Rank :" + setList);
		System.out.println("player :" + player);

		System.out.println("rank :" + rank);
		return rank;

	}

	static int utopianTree(int n) {
		int h = 1;
		boolean isSpring = true;
		for (int i = 0; i < n; i++) {
			if (isSpring) {
				h *= 2;
				isSpring = false;
			} else {
				h += 1;
				isSpring = true;

			}

		}
		return h;
	}

	static String angryProfessor(int k, int[] a) {

		for (int i = 0; i < a.length; i++) {
			if (a[i] < 0) {
				--k;
				if (k < 0) {
					return "YES";
				}
			}
		}
		return k > 0 ? "NO" : "YES";

	}

	static int beautifulDays(int i, int j, int k) {
		int beatifulDays = 0;
		for (int k2 = i; k2 <= j; k2++) {
			if (Math.abs(k2 - val(k2)) % k == 0)
				++beatifulDays;
		}
		return beatifulDays;
	}

	public static int val(int x) {
		int reverse = 0;
		while (x != 0) {
			reverse *= 10;
			reverse += x % 10;
			x = x / 10;
		}
		return reverse;

	}

	static int viralAdvertising(int n) {
		int i = 1;
		int shared = 2;
		int cumulative = 2;
		while (i < n) {
			++i;
			shared = (int) Math.floor(shared * 3 / 2);
			cumulative += shared;
		}
		return cumulative;

	}

	static int saveThePrisoner(int n, int m, int s) {
		if (m % n + s - 1 == 0)
			return n;
		if ((m % n + s - 1) > n)
			return (m % n + s - 1) % n;
		else
			return s - 1 + m % n;

	}

	static int[] circularArrayRotation(int[] a, int k, int[] queries) {
		int rotateVal = k % a.length;
		a = rotate(a, rotateVal);
		for (int i = 0; i < queries.length; i++) {
			queries[i] = a[queries[i]];
		}
		return queries;

	}

	static int[] rotate(int[] a, int k) {

		int[] rotate = new int[a.length];
		rotate[0] = a[a.length - 1];
		for (int i = 1; i < a.length; i++) {
			rotate[i] = a[i - 1];
		}
		if (k > 1) {
			--k;
			return rotate(rotate, k);
		} else
			return rotate;

	}

	static int[] rotate2(int[] arr, int k) {
		int rotateVal = k % arr.length;
		for (int i = 0; i < rotateVal; i++) {
			int last = arr[arr.length - 1];
			for (int j = arr.length - 1; j > 0; j--) {
				arr[j] = arr[j - 1];
			}
			arr[0] = last;
		}
		return arr;

	}

	static int[] permutationEquation(int[] p) {
		Map<Integer, Integer> map = new HashMap<>();
		int[] y = new int[p.length];
		for (int i = 0; i < p.length; i++) {
			map.put(i + 1, p[i]);
		}

		for (int i = 0; i < y.length; i++) {
			y[i] = map.get(map.get(i + 1));
		}
		return y;

	}

	static String organizingContainers(int[][] container) {
		return null;

	}

	static int findDigits(int n) {
		int count = 0;
		for (char c : String.valueOf(n).toCharArray())
			if (Character.getNumericValue(c) != 0 && n % Character.getNumericValue(c) == 0) {
				++count;
			}

		return count;
	}

	static int squares(int a, int b) {
		int start = (int) Math.sqrt(a); // Finds our starting squareInteger
		int end = (int) Math.sqrt(b); // Finds our ending squareInteger

		int squareIntegers = end - start; // Calculates the squareIntegers between them

		return squareIntegers += (Math.pow(start, 2) == a) ? 1 : 0;

	}

	static String encryption(String s) {
		String removeSpace = "";
		int x, y;
		String result = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != ' ')
				removeSpace += s.charAt(i) + "";
		}
		x = (int) Math.ceil(Math.sqrt(removeSpace.length())); // sütun
		y = (int) Math.floor(Math.sqrt(removeSpace.length())); // satýr

		int j = 0;
		if (x * y < removeSpace.length())
			++y;
		String[] arrayY = new String[y];

		for (int i = 0; i < removeSpace.length(); i += x) {

			if (i + x > removeSpace.length())
				arrayY[j] = removeSpace.substring(i, i + x - ((i + x) - removeSpace.length()));
			else {
				arrayY[j] = removeSpace.substring(i, i + x);
			}

			++j;
		}

		for (int i = 0; i < x; i++) {
			for (int k = 0; k < y; k++) {
				if (i >= arrayY[k].length())
					continue;
				result += arrayY[k].charAt(i);

			}
			result += " ";
		}
		return result;

	}

	public static long taumBday(int b, int w, int bc, int wc, int z) {

		long bprice = bc > (wc + z) ? (wc + z) : bc;
		long wprice = wc > (bc + z) ? (bc + z) : wc;

		return bprice * b + wprice * w;

	}
}