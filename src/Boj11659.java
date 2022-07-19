import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj11659 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] info = br.readLine().trim().split(" ");
        final int[] i = {1};
        int[] arr = new int[Integer.parseInt(info[0])+1];
        Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).forEach( n -> {arr[i[0]]=arr[i[0] -1] + n; i[0] +=1;});

        int[] bound;
        for(int j=0;j<Integer.parseInt(info[1]);j++){
            bound = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            System.out.println(arr[bound[1]] - arr[bound[0]-1]);
        }
    }
}
