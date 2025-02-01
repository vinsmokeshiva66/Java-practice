public class Problem2 {
    public static void main(String[] args) {
        String s="zohofinance";
        int n=s.length();

        for(int i=0;i<s.length();i++){
            for(int j=0;j<s.length();j++){
                if(i==j || i+j==n-1){
                    System.out.print(s.charAt(j));
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
