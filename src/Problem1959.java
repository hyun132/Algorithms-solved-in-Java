import java.util.Scanner;

public class Problem1959 {
    public static int calculateValue(int[] arr1,int[] arr2){

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

    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int size1, size2;
            size1 = sc.nextInt();
            size2=sc.nextInt();
            int[] array1 = new int[size1];
            int[] array2 = new int[size2];
            int answer;

            for (int i=0;i<size1;i++){
                array1[i]=sc.nextInt();
            }
            for (int i=0;i<size2;i++){
                array2[i]=sc.nextInt();
            }

            if( size1 > size2){
                answer = calculateValue(array1,array2);
            }else {
                answer = calculateValue(array2,array1);
            }
            System.out.println("#"+ (test_case) +" "+ answer);
        }
    }
}
