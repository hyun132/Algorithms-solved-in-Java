import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] len = new int[n];
        int[] evenLen = new int[n];
        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int l = i - 1;
            int r = i + 1;
            int length = 0;
            while (l >= 0 && r < n) {
                if (arr[l] == arr[r]) {
                    l--;
                    r++;
                    length++;
                } else break;
            }
            len[i] = length;
        }
        for (int i = 0; i < n; i++) {
            int l = i;
            int r = i + 1;
            int length = 0;
            while (l >= 0 && r < n) {
                if (arr[l] == arr[r]) {
                    l--;
                    r++;
                    length++;
                } else break;
            }
            evenLen[i] = length;
        }

        int s = 0;
        int e = 0;
        int mid = 0;
        int length = 0;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken()) - 1;
            e = Integer.parseInt(st.nextToken()) - 1;
            if ((s + e) % 2 == 0) {
                mid = (s + e) / 2;
                length = (e - s) / 2;
                if (len[mid] >= length) {
                    sb.append("1\n");
                } else sb.append("0\n");
            } else {
                mid = (s + e) / 2;
                length = (e - s+1) / 2;
                if (evenLen[mid] >= length) {
                    sb.append("1\n");
                } else sb.append("0\n");
            }
        }
        System.out.println(sb.toString());
    }

    public static void main2(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        boolean[][] dp = new boolean[n][n];
        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] == arr[i]) dp[i - 1][i] = true;
        }
        for (int len=2;len<=n;len++) {
            for (int i = 0; i< n; i++) {
                int j = i+len;
                if (j<n && arr[i]==arr[j] && dp[i+1][j-1]) dp[i][j] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        int s, e;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken()) - 1;
            e = Integer.parseInt(st.nextToken()) - 1;
            if (dp[s][e]) {
                sb.append("1\n");
            } else sb.append("0\n");
        }
        System.out.println(sb.toString());
    }
}
