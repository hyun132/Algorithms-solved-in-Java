import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj2110 {
    static int[] home;
    static int N, C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());


        N = Integer.parseInt(st.nextToken()); // 집 개수
        C = Integer.parseInt(st.nextToken()); // 공유기 개수

        home = new int[N];

        for(int i=0;i<N;i++){
            home[i] = Integer.parseInt(br.readLine().trim());
        }

        Arrays.sort(home);
        //최소 거리를 조절해가면서 N개를 설치할 수 있는지 확인한다.
        //cnt == C를 만족해야 한다.

        // l은 최소거리, r은 최대거리
        int l = 1;
        int r = home[N-1]-home[0]+1;
        int dist = r-l;
        int cnt = 0;
        while (l<r){
            dist = (l+r)/2;
            cnt = setWifi(dist);
            if(cnt>=C) l=dist+1;
            else r=dist;
        }

        System.out.println(r-1);
    }

    private static int setWifi(int dist) {
        int cnt=1; //거리가 가장 멀어야 하기 때문에 첫번째 or 마지막은 무조건 선택된다고 가정한다.
        //나는 첫번째를 선택하는걸로 구현했다.
        int last = home[0];
        for(int i=1;i<home.length;i++){
            if(home[i]-last>=dist){
                cnt++;
                last = home[i];
            }
            if(cnt>C) break;
        }
        return cnt;
    }
}
