import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray());
        }

        list.sort(Comparator.comparingInt((int[] a) -> a[1]).thenComparing((int[] a) -> a[0]));

        int last = 0;
        int answer = 0;
        for (int[] m : list){
            if (last<=m[0]) {
                answer += 1;
                last = m[1];
            }
        }

        System.out.println(answer);
    }
}
