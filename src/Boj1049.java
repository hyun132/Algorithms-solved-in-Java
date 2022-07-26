import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj1049 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        int repeat = input[1];
        int numOfString = input[0];

        int stringsPerPackage = 6;

        int minPrice = Integer.MAX_VALUE;
        int packagePrice = Integer.MAX_VALUE;
        int stringPrice = Integer.MAX_VALUE;
        for (int i = 0; i < repeat; i++) {
            int[] caseInfo = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            packagePrice = Math.min(packagePrice, caseInfo[0]);
            stringPrice = Math.min(stringPrice, caseInfo[1]);
        }
        minPrice = Math.min(minPrice, numOfString / stringsPerPackage * packagePrice + numOfString % stringsPerPackage * stringPrice);
        minPrice = Math.min(minPrice, (numOfString + (stringsPerPackage - 1)) / stringsPerPackage * packagePrice);
        minPrice = Math.min(minPrice, numOfString * stringPrice);
        System.out.println(minPrice);
    }
}
