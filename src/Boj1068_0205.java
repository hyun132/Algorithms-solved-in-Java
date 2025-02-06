import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Node[] nodes = new Node[n+1];
        for (int i=0;i<n;i++){
            nodes[i] = new Node(i);
        }
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int remove = Integer.parseInt(br.readLine());
        nodes[remove] = null;
        int root = 0;
        for (int i=0;i<arr.length;i++){
            if (arr[i] == -1) {
                root = i;
                continue;
            }
            if(i==remove) continue;
            if(arr[i]==remove) continue;
            nodes[arr[i]].addChild(nodes[i]);
        }
        if(root != remove) dfs(nodes[root]);
        System.out.println(count);
    }

    public static void dfs(Node cur){
        if (cur.children.isEmpty()) {
            count++;
            return;
        }
        for (Node nxt:cur.children){
            dfs(nxt);
        }
    }

    static class Node{
        int value;
        ArrayList<Node> children = new ArrayList();
        public Node(int val){
            value = val;
        }

        void addChild(Node child){
            children.add(child);
        }
    }
}
