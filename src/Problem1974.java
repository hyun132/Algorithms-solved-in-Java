import java.util.*;

public class Problem1974 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

        for (int test_case = 1; test_case <= T; test_case++) {

            ArrayList<HashSet<Integer>> board = new ArrayList<>(30);
            int answer = 1;

            for (int i=0; i<30; i++){
                board.add(i, new HashSet<Integer>());
            }

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    int inputValue = sc.nextInt();
                    if(answer==0)continue;
                    if (board.get(i).add(inputValue) && board.get(j+10).add(inputValue) && board.get(20 + 3 * (i/3) + j/3).add(inputValue)) {
                    } else {
                        answer = 0;
                    }
                }
            }
            System.out.println("#" + test_case + " " + answer);

        }
    }
}
