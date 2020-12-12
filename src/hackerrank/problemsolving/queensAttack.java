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
        


        int ust = n - c_q;
        int alt = c_q - 1;
        int sag = n - r_q;
        int sol = r_q - 1;
        int altEngel = 0;
        int ustEngel = 0;
        int solEngel = 0;
        int sagEngel = 0;
        int a_sagust_engel = 0;
        int b_solust_engel = 0;
        int c_solalt_engel = 0;
        int d_sagalt_engel = 0;

        int a_sagust = returnSize(sag, ust);
        int b_solust = returnSize(sol, ust);
        int c_solalt = returnSize(alt, sol);
        int d_sagalt = returnSize(sag, alt);
        int total_engelsiz = a_sagust + b_solust + c_solalt + d_sagalt + 2 * n - 2;

        for (int i = 0; i < k; i++) {

            if (c_q == obstacles[i][0]) {
                if (r_q > obstacles[i][1]) {
                    solEngel = (solEngel < obstacles[i][1]) ? obstacles[i][1] : solEngel;
                } else {
                    sagEngel = (sagEngel < (n - obstacles[i][1] + 1)) ? (n - obstacles[i][1] + 1) : sagEngel;
                }
            } else if (r_q == obstacles[i][1]) {
                if (c_q > obstacles[i][0]) {
                    altEngel = (altEngel < obstacles[i][0]) ? obstacles[i][0] : altEngel;
                } else {
                    ustEngel = (ustEngel < (n - obstacles[i][0] + 1)) ? (n - obstacles[i][0] + 1) : ustEngel;
                }
            } else if ((obstacles[i][0] + obstacles[i][1]) == (r_q + c_q)) {

                if (c_q < obstacles[i][1]) {
                    b_solust_engel = (b_solust_engel < returnSize(n - obstacles[i][0] + 1, obstacles[i][1]))
                            ? returnSize(n - obstacles[i][0] + 1, obstacles[i][1])
                            : b_solust_engel;
                } else {
                    d_sagalt_engel = (d_sagalt_engel < returnSize(obstacles[i][0], r_q - obstacles[i][1] + 1))
                            ? returnSize(obstacles[i][0], r_q - obstacles[i][1] + 1)
                            : d_sagalt_engel;
                }

            } else if ((obstacles[i][0] - obstacles[i][1]) == (r_q - c_q)) {
                if (c_q < obstacles[i][0]) {
                    a_sagust_engel = (a_sagust_engel < returnSize(n - obstacles[i][0] + 1, n - obstacles[i][1] + 1))
                            ? returnSize(n - obstacles[i][0] + 1, n - obstacles[i][1] + 1)
                            : a_sagust_engel;
                } else {
                    c_solalt_engel = (c_solalt_engel < returnSize(obstacles[i][0], obstacles[i][1]))
                            ? returnSize(obstacles[i][0], obstacles[i][1])
                            : c_solalt_engel;
                }
            }

        }
        return total_engelsiz - (b_solust_engel + d_sagalt_engel + c_solalt_engel + a_sagust_engel + sagEngel
                + solEngel + ustEngel + altEngel);

    
        
    
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
