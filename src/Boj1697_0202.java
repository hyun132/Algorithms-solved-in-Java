import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int n = input[0];
        int k = input[1];

        ArrayDeque<Integer> q = new ArrayDeque<Integer>();
        boolean[] visited = new boolean[100001];
        visited[n] = true;
        q.offer(n);
        int count = 0;
        while (!q.isEmpty()){
            int size = q.size();

            for (int i=0;i<size;i++) {
                int cur = q.poll();
                if (cur == k){
                    System.out.println(count);
                    return;
                }
                if (cur + 1 <= 100000 && !visited[cur +1]) {
                    q.offer(cur + 1);
                    visited[cur +1] = true;
                }
                if (cur * 2 <= 100000 && !visited[cur *2]) {
                    q.offer(cur * 2);
                    visited[cur * 2] = true;
                }
                if (cur > 0 && !visited[cur -1]) {
                    q.offer(cur - 1);
                    visited[cur -1] = true;
                }
            }
            count++;
        }

        System.out.println(count);
    }
}
