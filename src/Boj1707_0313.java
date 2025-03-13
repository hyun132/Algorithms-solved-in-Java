import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine());

        String answer = "";
        for (int i = 0; i < cases; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] nodeColors = new int[input[0] + 1];

            ArrayList<ArrayList<Integer>> graph = new ArrayList<>(input[0] + 1);
            for (int j = 0; j < input[0] + 1; j++) graph.add(new ArrayList<>());
            for (int j = 0; j < input[1]; j++) {
                int[] vertex = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

                graph.get(vertex[0]).add(vertex[1]);
                graph.get(vertex[1]).add(vertex[0]);
            }


            for (int no = 1; no < input[0] + 1; no++) {
                if (nodeColors[no] != 0) continue;
                if(!bfs(no,nodeColors,graph)) {
                    answer = "NO";
                    break;
                }
            }
            if (answer.isEmpty()) answer = "YES";
            System.out.println(answer);
            answer = "";
        }
    }

    public static boolean bfs(int no, int[] nodeColors,ArrayList<ArrayList<Integer>> graph){
        Queue<Integer> q = new LinkedList<>();
        q.offer(no);
        nodeColors[no] = 1;
        while (!q.isEmpty()) {
            int cur = q.poll();
            int nxtColor = (nodeColors[cur] % 2) + 1;
            for (int n : graph.get(cur)) {
                if (nodeColors[n] == nodeColors[cur]) {
                    return false;
                } else {
                    if (nodeColors[n] == 0) {
                        nodeColors[n] = nxtColor;
                        q.offer(n);
                    }
                }
            }
        }
        return true;
    }
}
