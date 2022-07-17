import java.util.*;

public class Problem1248 {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        sc.nextLine();
        for (int test_case = 1; test_case <= T; test_case++) {
            HashMap<Integer, ArrayList<Integer>> tree = new HashMap<>();
            int[] line1 = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] line2 = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] parent = new int[10001];

            for (int i = 0; i < line1[1]; i++) {
                int p = line2[2 * i];
                int c = line2[2 * i + 1];
                if (tree.containsKey(p)) {
                    tree.get(p).add(c);
                } else {
                    tree.put(p, new ArrayList<>());
                    tree.get(p).add(c);
                }
                parent[c] = p;
            }
            HashSet<Integer> set = new HashSet<Integer>();
            Queue<Integer> q = new LinkedList<Integer>();

            q.add(line1[2]);
            q.add(line1[3]);
            int answer=line1[3];
            while (!q.isEmpty()){
                answer = q.poll();
                if(answer!=0 && !set.add(answer)) break;
                q.add(parent[answer]);
            }
            System.out.println("#"+test_case+" "+answer+" "+countChildren(tree,answer));
        }
    }

    public static int countChildren(HashMap<Integer, ArrayList<Integer>> tree, int node){
        HashSet<Integer> answer = new HashSet<>();

        answer.add(node);
        Queue<Integer> q = new LinkedList<>();
        q.add(node);

        while (!q.isEmpty()){
            int cur = q.poll();
            if (tree.containsKey(cur)){
                q.addAll(tree.get(cur));
                answer.addAll(tree.get(cur));
            }
        }
        return answer.size();
    }
}
