import java.util.Scanner;

public class Boj2446 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int i=-n+1; i<n;i++){
            for(int j=0;j<n+Math.abs(i);j++){
                if(j<n-1-Math.abs(i)) sb.append(" ");
                else sb.append("*");;
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
