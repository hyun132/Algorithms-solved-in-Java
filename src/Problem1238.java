import java.util.*;
import java.io.FileInputStream;

public class Problem1238 {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = 10;
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

        HashMap<Integer, ArrayList<Integer>> map;
        for (int test_case = 1; test_case <= T; test_case++) {
            int size = sc.nextInt();
            int start = sc.nextInt();
            int input = 0;

            map = new HashMap<>();

            for (int i = 0; i < size/2; i++) {
                input = sc.nextInt();
                if (map.containsKey(input)) {
                    map.get(input).add(sc.nextInt());
                } else {
                    map.put(input, new ArrayList<>());
                    map.get(input).add(sc.nextInt());
                }
            }

            Set<Integer> visited = new HashSet<>();
            visited.add(start);
            ArrayList<Integer> list = new ArrayList<>();
            list.add(start);

            Queue<Integer> q = new LinkedList<>();
            q.add(start);

            int cur = 0;
            int max = -1;
            int qSize = 0;
            while (!q.isEmpty()) {
                qSize = q.size();
                max = -1;
                for (int i = 0; i < qSize; i++) {
                    cur = q.poll();
                    if (!map.containsKey(cur)) continue;
                    for (int n : map.get(cur)) {
                        if (visited.add(n)) {
                            q.add(n);
                            max = Math.max(max, n);
                        }
                    }
                }
                if (max != -1) list.add(max);
            }
            System.out.println("#" + test_case + " " + list.get(list.size()-1));
        }
    }
}
