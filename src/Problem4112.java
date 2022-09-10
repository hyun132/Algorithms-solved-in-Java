import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem4112 {

    static int[] dirY = new int[]{0, 1, 1, 0};
    static int[] dirX = new int[]{-1, 0, 1, 1};
    static int s, e;
    static boolean[] visited;
    static int[] startNo;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(st.nextToken());


        for (int tc = 1; tc <= TC; tc++) {
            answer = Integer.MAX_VALUE;
            startNo = new int[150];
            sb.append("#").append(tc).append(" ");
            st = new StringTokenizer(br.readLine().trim());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            if (s == e) { //시작점과 도착점이 같으면 바로 다음케이스로 넘어간다.
                sb.append(0).append("\n");
                continue;
            }
            if (s > e) { // s가 더 작도록 설정한다.
                int temp = e;
                e = s;
                s = temp;
            }

            int add=0;
            int sum=0;
            while (sum<=e){
                startNo[add] = sum+= add++;
            }
            Queue<Integer> q = new ArrayDeque();
            visited = new boolean[sum+1];
            q.add(s);
            int answer = 1;

            found:
            while (!q.isEmpty()) {
                int size = q.size();
                for (int cnt = 0; cnt < size; cnt++) {

                    int cur = q.poll();
                    int floor = 1;
                    while (cur > startNo[floor]) floor++;

                    //floor는 현재층
                    for (int i = 0; i < 4; i++) {
                        int nxt = cur + (floor) * dirY[i] + dirX[i];
                        if (check(nxt, floor+ dirY[i]) || visited[nxt] || nxt> e) continue;
                        if (nxt == e) {
                            break found;
                        }
                        visited[nxt] = true;
                        q.add(nxt);
                    }
                }
                answer++;
            }
            sb.append(answer).append("\n");
        }
        System.out.print(sb.toString());
    }

    private static boolean check(int nxt, int floor) {
        return nxt <= startNo[floor-1] || nxt > startNo[floor];
    }
}
