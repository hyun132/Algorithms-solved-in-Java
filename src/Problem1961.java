import java.util.Scanner;

public class Problem1961 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

        for (int test_case = 1; test_case <= T; test_case++) {
            int size = sc.nextInt();
            String[][] board = new String[size][size];

            for (int y = 0; y < size; y++) {
                for (int x = 0; x < size; x++) {
                    // 90도
                    String input = Integer.toString(sc.nextInt());
                    board[x][0] = input + board[x][0];
                    // 180 도
                    board[size - 1 - y][1] = input + board[size - 1 - y][1];
                    // 270도
                    board[size - 1 - x][2] += input;
                }
            }

            System.out.println("#" + test_case);
            for (int y = 0; y < size; y++) {
                System.out.println(String.join(" ", board[y]).replace("null",""));
            }
        }
    }
}
