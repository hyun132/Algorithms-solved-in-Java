import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> list = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
        HashSet<Integer> set = new HashSet<>(list);
        StringBuilder sb = new StringBuilder();

        int n2 = Integer.parseInt(br.readLine());
        Arrays.stream(br.readLine().split(" ")).forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                String val = "";
                if(set.contains(Integer.parseInt(s))) val = "1";
                else val = "0";
                sb.append(val + "\n" );
            }
        });

        System.out.println(sb.toString());
    }
}
