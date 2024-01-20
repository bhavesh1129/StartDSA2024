package AlgoU;

import java.util.Scanner;

public class ChasingTheDragon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, k;
        n = scanner.nextInt();
        k = scanner.nextInt();
        int[][] a = new int[1005][1005];

        for (int i = 0; i < n; i++) {
            int l1, r1, l2, r2;
            l1 = scanner.nextInt() + 1;
            r1 = scanner.nextInt() + 1;
            l2 = scanner.nextInt() + 1;
            r2 = scanner.nextInt() + 1;

            a[l1][r1] += 1;
            a[l2 + 1][r1] -= 1;
            a[l1][r2 + 1] -= 1;
            a[l2 + 1][r2 + 1] += 1;
        }

        int ans = 0;
        for (int i = 1; i <= 1001; i++) {
            for (int j = 1; j <= 1001; j++) {
                a[i][j] += a[i - 1][j] + a[i][j - 1] - a[i - 1][j - 1];
                if (a[i][j] == k) ans += 1;
            }
        }
        System.out.println(ans);
    }
}
