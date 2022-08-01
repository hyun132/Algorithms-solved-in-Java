import java.io.*;

public class Problem1289 {
    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine().trim());

        int answer =0;
        char last = '0';
        for(int i=1;i<=testCase;i++){
            answer = 0;
            last = '0';
            for(char c : br.readLine().trim().toCharArray()){
                if (c != last){
                    last = c;
                    answer ++;
                }
            }
            System.out.println("#"+i+" "+answer);
        }
    }
}
