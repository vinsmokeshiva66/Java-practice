import java.util.Scanner;

public class Pattern4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        int star=(n*2)-1;
        int right_space=0;
        int left_space=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<right_space;j++){
                System.out.print(" ");
            }
            for(int j=0;j<star;j++){
                System.out.print("*");
            }
            for(int j=0;j<left_space;j++){
                System.out.print(" ");
            }
            right_space++;
            left_space++;
            star-=2;
            System.out.println();
        }
        sc.close();
    }
}
