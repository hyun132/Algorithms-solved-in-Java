import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] firstLine = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        long[] numArr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        StringBuilder sb = new StringBuilder();

        for(int i = 1;i<numArr.length;i++){
            numArr[i] += numArr[i-1];
        }

        for(int c=0;c<firstLine[1];c++){
            int[] range = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (range[0] == 1) sb.append(String.valueOf(numArr[range[1]-1])+"\n");
            else sb.append(String.valueOf(numArr[range[1]-1] - numArr[range[0]-2])+"\n");
        }

        System.out.println(sb.toString());
    }
}
