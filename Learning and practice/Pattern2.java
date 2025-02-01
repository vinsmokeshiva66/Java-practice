import java.util.Scanner;

public class Pattern2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        int outer_space=n/2;
        int inner_space=1;

        for(int i=0;i<n;i++){
            for(int j=0;j<outer_space;j++){
                System.out.print(" ");
            }
            if(i<n/2) outer_space--;
            else outer_space++;

            if(i==0 || i==n-1){
                System.out.println("*");
            }else{
                System.out.print("*");
                for(int j=0;j<inner_space;j++){
                    System.out.print(" ");
                }
                if(i<n/2) inner_space+=2;
                else inner_space-=2;
                System.out.println("*");
            }
        }
        sc.close();
    }
}
