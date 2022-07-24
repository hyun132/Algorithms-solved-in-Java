import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1970 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int repeat = Integer.parseInt(br.readLine().trim());
        int unit[] = {50000,10000,5000,1000,500,100,50,10};

        for(int test_case=1; test_case<=repeat;test_case++){
            System.out.println("#"+test_case);
            int n = Integer.parseInt(br.readLine().trim());
            int i=0;
            while (n>0){
                System.out.printf("%d ",n/unit[i]);
                n%=unit[i++];
            }
            System.out.println();
        }
    }
}
