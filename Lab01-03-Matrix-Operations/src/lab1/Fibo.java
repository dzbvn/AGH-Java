package lab1;
import java.util.Arrays;
import java.util.Scanner;

public class Fibo
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        if(n >= 1 && n<=45)
        {
         int[] tab = new int[n];
         tab[0] = 1;
         if(n>=2){
             tab[1] = 1;
             for(int i = 2; i < n; i++){
                 tab[i] = tab[i-1] + tab[i-2];
             }
             System.out.println(Arrays.toString(tab));
        }

        else {
            return;
        }

    }

    }
}
