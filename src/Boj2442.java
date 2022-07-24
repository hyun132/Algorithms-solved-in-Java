import java.util.Scanner;

public class Boj2442 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0; i<n;i++){
            for(int j=0;j<n+i;j++){
                if(n-1-i<=j) System.out.print("*");
                else System.out.print(" ");
            }
            if(i<n-1)System.out.println();
        }
    }
}
