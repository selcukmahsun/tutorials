package hackerrank.problemsolving;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class queensAttack {

    // Complete the queensAttack function below.
    static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
        

        int r1 = n - r_q;
        int r2 = r_q - 1;
        int q1 = n - c_q;
        int q2 = c_q - 1;
        int a = returnSize(r1, q1);
        int b = returnSize(r1, q2);
        int c = returnSize(r2, q2);
        int d = returnSize(r2, q1);

        int r1_engel = 0;
        int r2_engel = 0;
        int q1_engel = 0;
        int q2_engel = 0;
        int a_engel = 0;
        int b_engel = 0;
        int c_engel = 0;
        int d_engel = 0;

        int total_engelsiz = a + b + c + d + 2 * n - 2;

        for (int i = 0; i < k; i++) {
            if (obstacles[i][1] == 20002 && obstacles[i][0] == 20002) {
                System.out.println("sutunlar esit r2_engel' girmeli");
            }
            if (obstacles[i][0] == 4) {
                System.out.println("satirlar esit q2_engel' girmeli");
            }

            if (c_q == obstacles[i][1]) {
                if (r_q > obstacles[i][0]) {
                    r2_engel = (r2_engel < obstacles[i][0]) ? obstacles[i][0] : r2_engel;
                    System.out.println(" r2_engel'e girdi" + r2_engel);
                } else {
                    r1_engel = (r1_engel < (n - obstacles[i][0] + 1)) ? (n - obstacles[i][0] + 1) : r1_engel;
                }
            } else if (r_q == obstacles[i][0]) {
                if (c_q > obstacles[i][1]) {
                    q2_engel = (q2_engel < obstacles[i][1]) ? obstacles[i][1] : q2_engel;
                    System.out.println(" q2_engel girdi" + q2_engel);
                } else {
                    q1_engel = (q1_engel < (n - obstacles[i][1] + 1)) ? (n - obstacles[i][1] + 1) : q1_engel;
                }
            } else if ((obstacles[i][0] + obstacles[i][1]) == (r_q + c_q)) {

                if (r_q < obstacles[i][0]) {
                    b_engel = (b_engel < returnSize(n - obstacles[i][0] + 1, obstacles[i][1]))
                            ? returnSize(n - obstacles[i][0] + 1, obstacles[i][1])
                            : b_engel;
                } else {
                    d_engel = (d_engel < returnSize(obstacles[i][0], n - obstacles[i][1] + 1))
                            ? returnSize(obstacles[i][0], n - obstacles[i][1] + 1)
                            : d_engel;
                }
            } else if ((obstacles[i][0] - obstacles[i][1]) == (r_q - c_q)) {
                if (r_q < obstacles[i][0] && c_q < obstacles[i][1]) {
                    a_engel = (a_engel < returnSize(n - obstacles[i][0] + 1, n - obstacles[i][1] + 1))
                            ? returnSize(n - obstacles[i][0] + 1, n - obstacles[i][1] + 1)
                            : a_engel;
                } else if (r_q > obstacles[i][0] && c_q > obstacles[i][1]) {
                    c_engel = (c_engel < returnSize(obstacles[i][0], obstacles[i][1]))
                            ? returnSize(obstacles[i][0], obstacles[i][1])
                            : c_engel;
                }
            }

        }

    

        return total_engelsiz - (+c_engel + a_engel + d_engel + b_engel + q1_engel + q2_engel + r1_engel + r2_engel);

    
    
        
    
}
static int returnSize(int v1, int v2) {

        return v1 < v2 ? v1 : v2;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        String[] r_qC_q = scanner.nextLine().split(" ");

        int r_q = Integer.parseInt(r_qC_q[0]);

        int c_q = Integer.parseInt(r_qC_q[1]);

        int[][] obstacles = new int[k][2];

        for (int i = 0; i < k; i++) {
            String[] obstaclesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int obstaclesItem = Integer.parseInt(obstaclesRowItems[j]);
                obstacles[i][j] = obstaclesItem;
            }
        }

        int result = queensAttack(n, k, r_q, c_q, obstacles);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
