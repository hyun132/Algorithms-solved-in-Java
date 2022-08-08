import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class Boj2258 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int weight = 0;
        int cost = 0;

        int N = Integer.parseInt(st.nextToken());
        int need = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> chunk = new PriorityQueue<>(Comparator.comparing((int[] o) -> -o[1]).thenComparing((int[] o) -> o[0]));

        int[] one;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            one = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            weight += one[0];
            chunk.add(one);
        }
        if (weight<need) {
            System.out.println(-1);
            return;
        }

        cost = chunk.peek()[1];
        while (!chunk.isEmpty() && weight - chunk.peek()[0] >= need ) {
            int[] c = chunk.poll();
            weight -= c[0];
            if(chunk.peek()[1]!=c[1] ) cost = c[1];
        }

        int unit = chunk.peek()[1];
        int answer = 0;
        while (!chunk.isEmpty() && chunk.peek()[1] == unit){
            answer+=unit;
            chunk.poll();
        }

        if(cost!= unit) answer = Math.min(cost,answer);

        System.out.println(answer);

    }
}
