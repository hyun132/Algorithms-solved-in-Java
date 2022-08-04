import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Boj13549 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        int me = input[0];
        int sis = input[1];

        int[] arr = new int[2 * Math.max(me, sis)];
        arr[me] = 1;
        List<Integer> list = new ArrayList<>();
        list.add(me);
        while (list.size() > 0 && arr[sis] == 0) {
            me = list.remove(0);
            if (me * 2 < arr.length) {
                if (arr[me * 2] == 0) {
                    arr[me * 2] = arr[me];
                    list.add(me * 2);
                } else if (arr[me * 2] > arr[me] + 1) arr[me * 2] = arr[me];
            }
            if (me > 0) {
                if (arr[me - 1] == 0) {
                    arr[me - 1] = arr[me] + 1;
                    list.add(me - 1);
                } else if (arr[me - 1] > arr[me] + 1) arr[me - 1] = arr[me] + 1;


            }
            if (me + 1 < arr.length) {
                if (arr[me + 1] == 0) {
                    arr[me + 1] = arr[me] + 1;
                    list.add(me + 1);
                } else if (arr[me + 1] > arr[me] + 1) arr[me + 1] = arr[me] + 1;
            }
        }
//        System.out.println(Arrays.toString(arr));
        System.out.println(arr[sis] - 1);
    }

}
