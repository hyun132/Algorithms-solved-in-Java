import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cnt = Integer.parseInt(st.nextToken());
        for(int count =0;count<cnt;count++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int[] times = new int[n + 1];
            Arrays.fill(times, Integer.MAX_VALUE);

            List<List<Edge>> graph = new ArrayList<>(new ArrayList<>());
            for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
          
            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());

                graph.get(b).add(new Edge(a, w));
            }

            PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.w, e2.w));
            pq.offer(new Edge(c, 0));
            times[c] = 0;
            while (!pq.isEmpty()) {
                Edge cur = pq.poll();

                if(times[cur.to] < cur.w) continue;

                for (Edge nxt : graph.get(cur.to)) {
                    if (times[nxt.to] > times[cur.to] + nxt.w) {
                        times[nxt.to] = times[cur.to] + nxt.w;
                        pq.offer(new Edge(nxt.to, times[nxt.to]));
                    }
                }
            }
            System.out.println(Arrays.stream(times).filter((i) -> i != Integer.MAX_VALUE).count() + " "+Arrays.stream(times).filter((i) -> i < Integer.MAX_VALUE).max().getAsInt());
        }
    }

    static class Edge {
        int to;
        int w;

        public Edge(int to, int w) {
            this.to = to;
            this.w = w;
        }
    }
}
