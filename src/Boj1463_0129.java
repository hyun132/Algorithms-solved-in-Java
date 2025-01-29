import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dfs(n,0);

        System.out.println(answer-1);
    }

    public static void dfs(int num, int depth){
        if (num==0){
            if (answer > depth) answer = depth;
            return;
        }
        if (answer<=depth) return;

        if (num%3 == 0) dfs(num/3,depth+1);
        if (num%2 == 0) dfs(num/2,depth+1);
        dfs(num-1,depth+1);
    }
}
