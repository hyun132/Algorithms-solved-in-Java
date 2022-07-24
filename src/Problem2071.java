import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2071 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());

        for (int i=1;i<=t;i++){
            double sum=0;
            String[] arr = br.readLine().trim().split(" ");
            for(String num:arr) sum+=Integer.parseInt(num);
            System.out.printf("#%d %d\n",i, Math.round(sum / arr.length));
        }
    }
}
