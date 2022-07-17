import java.util.Scanner;

public class Problem2001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

        for (int test_case = 1; test_case <= T; test_case++) {

            /////////////////////////////////////////////////////////////////////////////////////////////
			/*
				 이 부분에 여러분의 알고리즘 구현이 들어갑니다.
			 */
            /////////////////////////////////////////////////////////////////////////////////////////////
            int boardSize, hitSize;
            boardSize = sc.nextInt();
            hitSize = sc.nextInt();

            int[][] board = new int[boardSize + 1][boardSize + 1]; //
            int answer = 0;
            for (int y = 1; y <= boardSize; y++) {
                for (int x = 1; x <= boardSize; x++) {
                    board[y][x] = board[y][x - 1] + board[y - 1][x] + sc.nextInt() - board[y - 1][x - 1];
                    if (x < hitSize || y < hitSize) continue;
                    else{
                        answer = Math.max(answer, board[y][x] - board[y - hitSize][x] - board[y][x - hitSize] + board[y - hitSize][x - hitSize]);
                    }
                }
            }

            System.out.println("#" + test_case + " " + answer);
        }
    }
}
