import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Boj1931 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int meeting = Integer.parseInt(br.readLine().trim());

        ArrayList<int []> schedule = new ArrayList<>();


        for(int i=0;i<meeting;i++){
            schedule.add(Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray());
        }

        schedule.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {  //음수면 오른쪽이 아래로
                return o1[1] != o2[1] ? o1[1]-o2[1] : o1[0]-o2[0];
            }
        });

        int end=0;
        int count = 0;
        for(int[] m: schedule){
            if(end<=m[0]){
                count++;
                end=m[1];
            }
        }
        System.out.println(count);
    }
}
