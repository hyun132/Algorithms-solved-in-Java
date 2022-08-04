import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj16236 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine().trim());

        int[][] map = new int[size][size];
        int[] fishies = new int[7];

        LinkedList<Integer> q = new LinkedList<>();

        for (int i = 0; i < size; i++) {
            int[] row = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < size; j++) {
                map[i][j] = row[j];
                if (row[j] == 9) {
                    q.add(i * size + j);
                    map[i][j] = 0;
                }
                if (map[i][j] > 0 && map[i][j] <= 6) fishies[row[j]]++;
            }
        }

        int[] dirY = {-1,0, 1,  0};
        int[] dirX = {0,-1, 0,  1};
        int count = 0;
        int babySize = 2;
        int answer = 0;
        int eat = 0;
        int currentPosition = -1;
        Set<Integer> visited = new HashSet<>();
        ArrayList<Integer> temp = new ArrayList<>();
        visited.add(q.peekFirst());
        while (!q.isEmpty()) {
            count++;
            int qSize = q.size();

            for (int i = 0; i < qSize; i++) {
                currentPosition = q.removeFirst();
                for (int d = 0; d < 4; d++) {
                    int ny = (currentPosition / size) + dirY[d];
                    int nx = (currentPosition % size) + dirX[d];
                    if (0 <= ny && ny < size && 0 <= nx && nx < size && !q.contains(size*ny+nx) && visited.add(size*ny+nx)) {
                        if(map[ny][nx] > babySize ) continue;
                        if (map[ny][nx] > 0 && map[ny][nx] < babySize) {
                            temp.add(ny * size + nx);
                        } else if ((map[ny][nx] == babySize || map[ny][nx] == 0)) {
                            q.add(ny * size + nx);
                            visited.add(ny * size + nx);
                        }

                    }
                }
            }

            temp.sort(((Comparator<Integer>) Comparator.comparingInt((Integer o) -> o / size)).thenComparing(Comparator.comparingInt(o -> o % size)));

            if (temp.size() > 0) {
                int position = temp.remove(0);
                q.clear();
                q.add(position);
                fishies[map[position / size][position % size]]--;
                map[position / size][position % size] = 0;

                eat++;
                if (eat == babySize) {
                    babySize++;
                    eat = 0;
                }
                visited.clear();
                answer += count;
                count=0;
                temp.clear();
            }
            else {
                visited.add(currentPosition);
            }
            int sum = 0;
            for (int idx = 1; idx < Math.min(babySize, 7); idx++) {
                sum += fishies[idx];
            }
            if (sum==0) {
                q.clear();
            }
        }
        System.out.println(answer);
    }
}




