import java.util.Scanner;

public class Boj2443 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0; i<n;i++){
            for(int j=0;j<n*2-i-1;j++){
                if(j<i) System.out.print(" ");
                else System.out.print("*");
            }
            if(i<n-1)System.out.println();
        }
    }
}
