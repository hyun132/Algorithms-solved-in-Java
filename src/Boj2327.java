import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj2327 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().trim().split(" ");

        int H = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);

        ArrayList<Integer> list = new ArrayList<>();
        PriorityQueue<int[]> students = new PriorityQueue<>(Comparator.comparing((int[] o) -> -o[1]).thenComparing((int[] o) -> -o[0]));

        for (int i = 1; i <= N; i++) {
            int[] info = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (info[0] > H) continue;
            students.add(info);
        }

        int size;
        while (!students.isEmpty()) {
            int[] info = students.poll();

            size = list.size();
            if (size == 0){
                list.add(info[0]);
                if(info[0]==H){
                    System.out.println(info[1]);
                    return;
                }
                continue;
            }
            for(int i=0;i<size;i++){
                int temp =list.get(i)+info[0];
                if(temp == H || info[0]==H){
                    System.out.println(info[1]);
                    return;
                } else if (temp< H && !list.contains(temp)) {
                    list.add(temp);
                }
            }
            if(!list.contains(info[0])) list.add(info[0]);
        }
    }
}
