import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] parents;
    static int count = -1;
    
public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numOfComputers = Integer.parseInt(br.readLine());
        int connections = Integer.parseInt(br.readLine());
        StringTokenizer st;

        parents = new int[numOfComputers + 1];
        for (int i = 0; i <= numOfComputers; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < connections; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a,b);
        }

        for (int i = 1; i <= numOfComputers; i++) {
            if(find(i) == 1) count++;
        }

        System.out.println(count);
    }

    static int find(int a) {
        if (parents[a] == a) return a;
        return parents[a] = find(parents[a]);
    }

    static boolean union(int a, int b) {
        int parentsA = find(parents[a]);
        int parentsB = find(parents[b]);
        if (parentsA == parentsB) return false;
        if (parentsA < parentsB) {
            parents[parentsB] = parentsA;
        } else {
            parents[parentsA] = parentsB;
        }
        return true;
    }
}
