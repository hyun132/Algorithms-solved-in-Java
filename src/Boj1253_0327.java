import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int answer = 0;

        int[] numArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

        for(int i=0;i<numArr.length;i++){
           if(isPossible(numArr,i)) answer++;
        }

        System.out.println(answer);
    }

    private static boolean isPossible(int[] arr ,int i) {
        int l = 0;
        int r = arr.length-1;
        int target = arr[i];
        while (l<r){
            int sum = arr[l] + arr[r];

            if (sum == target){
                if (l==i) l++;
                else if (r==i) r--;
                else return true;
            } else {
                if (sum<target) l++;
                else r--;
            }
        }
        return false;
    }
}
