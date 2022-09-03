import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj17352 {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        int N = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i]=i;
        }
        for (int i = 0; i < N - 2; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            if(find(parent[s])<find(parent[e])){
                //parent e의 부모 값을 바꿔주어야 한다.
                union(s,e);
                parent[e] = find(s);
            }else{
                union(e, s);
                parent[s] = find(e);
            }
        }
//        System.out.println(Arrays.toString(parent));
        for (int i = 1; i <= N; i++) {
            if (find(1) != find(i)) {
                System.out.println(find(1)+ " " + i);
                return;
            }
        }
    }

    public static boolean union(int a, int b) {// a는 바꿔야할 값, b가 바꿀 부모 b에 a를 더한다
        //들어온 애의 모든 자식들의 부모를 b로 변경한다.
        if (find(a) == find(b)) return false;

        if(find(a)<find(b)){
            parent[find(b)] = parent[find(a)];
            union(a,b);
        }else {
            parent[find(a)] = parent[find(b)];
            union(a,b);
        }
        return true;
    }

    public static int find(int a){
        if(parent[a] == a) return a;
        return find(parent[a]);
    }
}
