package lab1;
import java.util.Scanner;

public class Problem610A {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int c = 0;
        for(int i = 1; i < n/2; i++){
            if(i == n/2 - i){
                System.out.println(i);
            }
            else{
                //System.out.print(i);
                //System.out.println(n/2-i);
                c += 1;
            }
        }
        System.out.println(c/2);
    }
}
