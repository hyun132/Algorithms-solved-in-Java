import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Daily2033 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test_case = Integer.parseInt(br.readLine().trim());
        for (int i=1;i<=test_case;i++){
            int n = Integer.parseInt(br.readLine().trim());
            char[] arr =br.readLine().trim().toCharArray();

            int ky,y,kx,x;
            ky = arr[0]-'0';
            kx = arr[1]-'0';
            x = arr[2]-'0';
            y = arr[3]-'0';
            int answer = 0;
            int diff = Math.abs(ky-x);
            int[][] cases = {{y, x + diff}, {y, x - diff}, {y + diff, x}, {y - diff, x}, {y + diff, x + diff}, {y + diff, x - diff}, {y - diff, x - diff}, {y - diff, x + diff}};

            for (int[] c :cases){
                if(ky == c[0]&& kx == c[1]) {
                    answer =1; break;
                }
            }

            System.out.println("#"+test_case+" "+answer);
        }
    }
}
