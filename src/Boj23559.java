import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj23559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N,X;
        N = Integer.parseInt(st.nextToken()); // n개메뉴선택
        X = Integer.parseInt(st.nextToken()); //가격상한

        //차이가 크고 맛이 큰
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing((int[] a) -> -a[0]).thenComparing((int[] a)-> -a[1]));

        int sum=0;

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int A= Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            pq.add( new int[]{A-B,B});
            sum+=B;
        }

        int i= (X-1000*N)/4000;
        while (i>0 && !pq.isEmpty()){
            int[] temp = pq.poll();
            if(temp[0]>0) {
                sum += temp[0];
                i-=1;
            }
        }

        System.out.println(sum);
    }
}
