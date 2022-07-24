import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj5585 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 1000 - Integer.parseInt(br.readLine().trim());

        int[] unit = {500,100,50,10,5};
        int answer =0;
        int idx = 0;
        while (n>=5){
            answer+= n/unit[idx];
            n %= unit[idx++];
        }
        System.out.println(n+answer);
    }
}
