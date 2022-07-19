import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

//11:6
public class Boj10828 {
    public static void main2(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int repeat = Integer.parseInt(br.readLine());
        ArrayList<Integer> stack = new ArrayList<>();
        for (int i=0;i<repeat;i++){
            String[] input = br.readLine().split(" ");

            switch (input[0]){
                case "push":
                    stack.add(Integer.parseInt(input[1]));
                    break;
                case "size":
                    System.out.println(stack.size());
                    break;
                case "empty":
                    System.out.println(stack.size()>0?0:1);
                    break;
                case "pop":
                    if(stack.size()>0) System.out.println(stack.remove(stack.size()-1));
                    else System.out.println(-1);
                    break;
                case "top":
                    if(stack.size()>0) System.out.println(stack.get(stack.size() - 1));
                    else System.out.println(-1);
                    break;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int repeat = Integer.parseInt(br.readLine());
        int[] stack = new int [repeat];
        int size=-1;
        String[] input;
        for (int i=0;i<repeat;i++){
            input = br.readLine().split(" ");

            switch (input[0]){
                case "push":
                    stack[++size] = Integer.parseInt(input[1]);
                    break;
                case "size":
                    System.out.println(size+1);
                    break;
                case "empty":
                    System.out.println(size>-1?0:1);
                    break;
                case "pop":
                    if(size>-1){
                        System.out.println(stack[size]);
                        size--;
                    }
                    else System.out.println(-1);
                    break;
                case "top":
                    if(size>-1) System.out.println(stack[size]);
                    else System.out.println(-1);
                    break;
            }
        }
    }
}
