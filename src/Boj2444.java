import java.util.Scanner;

public class Boj2444 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int i=-n+1; i<n;i++){
            for(int j=0;j<2*n-Math.abs(i)-1;j++){
                if(j<Math.abs(i)) sb.append(" ");
                else sb.append("*");
            }
            if(i<n-1) sb.append("\n");
        }
        System.out.print(sb);
    }
}
