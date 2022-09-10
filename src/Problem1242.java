import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1242 {
    static int[][] numberRatio = {
            {3, 2, 1, 1}, // 0
            {2, 2, 2, 1}, // 1
            {2, 1, 2, 2}, // 2
            {1, 4, 1, 1}, // 3
            {1, 1, 3, 2}, // 4
            {1, 2, 3, 1}, // 5
            {1, 1, 1, 4}, // 6
            {1, 3, 1, 2}, // 7
            {1, 2, 1, 3}, // 8
            {3, 1, 1, 2}, // 9
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(st.nextToken());

        for (int tc = 1; tc <= TC; tc++) {
            sb.append("#").append(tc).append(" ");
            int answer = 0;
            int y, x;

            st = new StringTokenizer(br.readLine().trim());
            y = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());

            int[] lastCode = new int[8];
            int[] convertedCode = new int[x * 4];
            int[] lastBinary = new int[x * 4];
            String last = "";
            //0만있는 행은 버린다.
            boolean found = false;
            for (int i = 0; i < y; i++) {
                String str = br.readLine().trim();
                //올바른 암호코드가 하나이상 있을테니 found가 true일때까지 계속 반복한다.

                if (last.equals(str)) continue;
                else {
                    last = str;
                    convertedCode = new int[str.length() * 4];
                    for (int j = 0; j < str.length(); j++) {
                        int tmp = Character.digit(str.charAt(j), 16);
                        for (int m = 0; m < 4; m++) {
                            convertedCode[j * 4 + (3 - m)] = (((tmp & (1 << m)) > 0) ? 1 : 0);
                        }
                    }

                    //여기서 가장 짧은 0이나 1을 구한다.
                    int idx = convertedCode.length - 1;
                    while (idx >= 0) {
                        //같은 라인에 암호가 더 있을 수도 있기 때문에 idx가 0될때까지 찾는다.
                        int[] resultCode = new int[8];
                        int resultCodeIdx = 7;
                        while (resultCodeIdx >= 0 && idx >= 0) {
                            int[] ratio = new int[4];
                            int ratioIdx = 3;
                            while (idx >= 0 && ratioIdx >= 0) {
                                if (convertedCode[idx] == 1 && lastBinary[idx]==0) {
                                    int o = 0;
                                    while (convertedCode[idx] == 1) {
                                        o++;
                                        idx--;
                                    }
                                    ratio[ratioIdx--] = o;
                                }
                                if (ratioIdx < 3 && convertedCode[idx] == 0) {
                                    int z = 0;
                                    while (idx >= 0 && convertedCode[idx] == 0) {
                                        z++;
                                        idx--;
                                    }
                                    ratio[ratioIdx--] = z;
                                } else {
                                    idx--;
                                }
                            }

                            if (ratioIdx == -1) {
                                int todiv = Math.min(ratio[1], Math.min(ratio[2], ratio[3]));
                                int[] temp = new int[4];
                                for (int k = 0; k < 4; k++) {
                                    temp[k] = ratio[k] / todiv;
                                }
                                for (int n = 0; n < 10; n++) { //마지막 숫자의 0은 앞에 패딩도 포함되어있을 수 있기 때문에
                                    if ((numberRatio[n][1] == temp[1]) && (numberRatio[n][2] == temp[2]) && (numberRatio[n][3] == temp[3]) && (numberRatio[n][0] <= temp[0])) {
                                        resultCode[resultCodeIdx--] = n;
                                    }
                                }

                            }
                            if (ratioIdx == -1 && resultCodeIdx == -1) {
                                if ((lastCode[0] == resultCode[0]) && (lastCode[1] == resultCode[1]) && (lastCode[2] == resultCode[2]) && (lastCode[3] == resultCode[3]) && (lastCode[4] == resultCode[4]) && (lastCode[5] == resultCode[5]) && (lastCode[6] == resultCode[6]) && (lastCode[7] == resultCode[7]))
                                    break;
                                int odd = 0, even = 0;
                                for (int m = 1; m < 7; m += 2) {
                                    even += resultCode[m];
                                    odd += resultCode[m - 1];
                                }
                                odd += resultCode[6];

                                if ((odd * 3 + even + resultCode[7]) % 10 == 0) {
                                    answer += (even + odd + resultCode[7]);
                                    lastCode = resultCode.clone();
                                }
                            }
                        }
                    }
                    lastBinary = convertedCode.clone();
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.print(sb.toString());
    }
}
