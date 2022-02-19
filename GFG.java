package algos.dp.SumOfSubsets;


// { Driver Code Starts

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String[] input_line = read.readLine().trim().split("\\s+");
            int[] arr = new int[N];
            for (int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if (Solution.isSubsetSum(N, arr, sum))
                System.out.println(1);
            else
                System.out.println(0);


        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {

    //static int table[][];
    static boolean[][] table;

    static Boolean isSubsetSum(int N, int[] arr, int sum) {
        /*table = new int[N + 1][sum + 1];
        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0 || j == 0) {
                    table[i][j] = 0;
                    continue;
                }
                int origIdx = i - 1;
                if (arr[origIdx] <= j) {
                    table[i][j] = Math.max((arr[origIdx] + table[i - 1][j - arr[origIdx]]), table[origIdx][j]);
                } else {
                    table[i][j] = table[origIdx][j];
                }
                if(sum==table[i][j]) {
                    return true;
                }
            }
        }
        return false;*/
        table = new boolean[N + 1][sum + 1];
        for (int i = 0; i < N + 1; i++) {
            table[i][0] = true;
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0) {
                    if(j != 0)
                        table[i][j] = false;
                    continue;
                }
                int origIdx = i - 1;
                if (arr[origIdx] <= j) {
                    table[i][j] = table[origIdx][j - arr[origIdx]] || table[origIdx][j];
                } else {
                    table[i][j] = table[origIdx][j];
                }
                if (j == sum && table[i][j] == true)
                    return true;
            }
        }
        return false;
    }
}
