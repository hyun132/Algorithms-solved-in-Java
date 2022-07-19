import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Problem1519 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int inputCase = Integer.parseInt(br.readLine().trim());
        int answer = 0;
        for (int i=0;i<inputCase;i++){
            int[] lengthArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] array1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] array2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            if( lengthArr[1] > lengthArr[0]){
                answer = calculateValue(array2,array1);
            }else {
                answer = calculateValue(array1,array2);
            }
            System.out.println("#"+(i+1) +" "+ answer);
        }

    }
    // arr1이 긴쪽 arr2가 짧은 쪽
    public int calculateValue(int[] arr1, int[] arr2){

        int maxValue = 0;
        int sumValue;
        for (int i = 0 ; i<arr1.length - arr2.length+1;i++){
            sumValue= 0;
            for (int j = 0; j< arr2.length;j++){
                sumValue += arr1[j+i]*arr2[j];
            }
            maxValue = Math.max(maxValue,sumValue);
        }

        return maxValue;
    }

    public static void main(String[] args) throws IOException {
        Problem1519 prob = new Problem1519();
        prob.solution();
    }

}
