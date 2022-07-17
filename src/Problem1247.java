import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Problem1247 {
    private static int[] home = {0, 0};
    private static int answer;

    private static HashMap<Integer,int[]> points;

    // 방문해야 하는 곳을 하나씩 줄여가면서 가는게 더 효율 적일 것 같당
    // set으로 거르는게 낫나?
    public static int dfs(HashSet<Integer> visited, int x, int y, int cost) {
        int tempAnswer = Integer.MAX_VALUE;

        if (cost >= answer) return tempAnswer;
        if (points.size() == visited.size()) {
            return Math.min(tempAnswer, cost + Math.abs(x - home[0]) + Math.abs(y - home[1]));
        }

        for (int nxt : points.keySet()) {
            if (visited.add(nxt)) {
                int nx =  points.get(nxt)[0];
                int ny =  points.get(nxt)[1];
                tempAnswer = Math.min(tempAnswer,dfs(visited, nx,ny,cost + Math.abs(x - nx) + Math.abs(y - ny)));
                answer = Math.min(answer,tempAnswer);
                visited.remove(nxt);
            }
        }
        //7.75191s
        return tempAnswer;
    }

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        sc.nextLine();

        for (int test_case = 1; test_case <= T; test_case++) {
            answer = Integer.MAX_VALUE;
//            int size = Integer.parseInt(sc.nextLine().strip());
            int size = sc.nextInt();
            sc.nextLine();
            int[] row = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            home = new int[]{row[2], row[3]};
            points = new HashMap<>();

            for (int i = 1; i <= size; i++) {
                points.put(i, new int[]{row[(i + 1) * 2], row[(i + 1) * 2 + 1]});
            }
            System.out.println("#" + test_case + " " + dfs(new HashSet<Integer>(), row[0], row[1], 0));
        }
    }
}
