import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution1230 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N, M;
        String answer;
        for (int c = 1; c <= 10; c++) {
            st = new StringTokenizer(br.readLine());
            int originalSize = Integer.parseInt(st.nextToken()); // 원본 문자열 길이
            List<Integer> original = new LinkedList<>();

            st = new StringTokenizer(br.readLine()); // 원본 문자열
            while (st.hasMoreTokens()) {
                original.add(Integer.parseInt(st.nextToken()));
            }

            st = new StringTokenizer(br.readLine());
            int operationsSize = Integer.parseInt(st.nextToken()); // 연산자 길이

            st = new StringTokenizer(br.readLine()); // 연산자

            while (st.hasMoreTokens()) {
                String flag = st.nextToken(); // 연산자

                switch (flag) {
                    case "I": {

                        List<Integer> newList = new LinkedList<>();
                        int X = Integer.parseInt(st.nextToken());
                        int Y = Integer.parseInt(st.nextToken());

                        for (int j = 0; j < Y; j++) {
                            newList.add(Integer.parseInt(st.nextToken()));
                        }

                        original.addAll(X, newList);
                        break;
                    }
                    case "D": {

                        int X = Integer.parseInt(st.nextToken());
                        int Y = Integer.parseInt(st.nextToken());

                        for (int j = 0; j < Y; j++) {
                            original.remove(X);
                        }
                        break;
                    }
                    case "A": {
                        int Y = Integer.parseInt(st.nextToken());
                        for (int j = 0; j < Y; j++) {
                            original.add(Integer.parseInt(st.nextToken()));
                        }
                        break;
                    }
                }
            }
            sb.append("#").append(c).append(" ");
            for(int a : original.subList(0, 10)){
                sb.append(a).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}

