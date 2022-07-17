import java.util.Scanner;

public class Problem1979 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int size, k;
            size =  sc.nextInt();
            k =  sc.nextInt();
            int[][] board = new int[size][size];

            int count=0;
            int answer = 0;
            for (int y=0;y<size;y++){ // 가로 넣으면서
                for (int x=0;x<size;x++){
                    board[y][x] = sc.nextInt();
                    if(board[y][x]==1) count++;
                    else {
                        if(count == k){
                            answer +=1;
                        }
                        count=0;
                    }
                }
                if(count == k){
                    answer +=1;
                }
                count=0;
            }

            // 세로를 확인한다

            for (int y=0;y<size;y++){ // 가로 넣으면서
                for (int x=0;x<size;x++){
                    if(board[x][y]==1) count++;
                    else {
                        if(count == k){
                            answer +=1;
                        }
                        count=0;
                    }
                }
                if(count == k){
                    answer +=1;
                }
                count=0;
            }

            System.out.println("#"+test_case+" "+answer);
        }
    }

}
