import java.util.Scanner;

public class Pattern3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        int left_space=n;
        int right_space=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<left_space;j++){
                System.out.print(" ");
            }
            for(int j=0;j<n;j++){
                System.out.print("*");
            }
            for(int j=0;j<right_space;j++){
                System.out.print(" ");
            }
            left_space--;
            right_space++;
            System.out.println();
        }
        sc.close();
    }
}
