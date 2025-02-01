import java.util.Scanner;

public class Pattern1 {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        int stars=n/2+1;
        int spaces=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=stars;j++){
                System.out.print("*");
            }
            for(int j=1;j<=spaces;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=stars;j++){
                System.out.print("*");
            }
            System.out.println();

            if(i<n/2+1){
                stars-=1;
                spaces+=2;
            }
            if(i==n/2+1){
                stars=2;
                spaces=n-3;
            }
            if(i>n/2+1){
                stars+=1;
                spaces-=2;
            }
        }
        sc.close();
    }
}
