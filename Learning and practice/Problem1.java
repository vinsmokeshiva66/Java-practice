public class Problem1 {
    public static void main(String[] args) {
        String s="73421*+*-";
        int p1=1;

        int sign_index=2;
        while(s.charAt(sign_index)>='0' && s.charAt(sign_index)<='9'){
            sign_index++;
        }
        int n1=Character.getNumericValue(s.charAt(0));
        int n2=Character.getNumericValue(s.charAt(p1));
        int res=check(n1,n2,s.charAt(sign_index));
        p1++;
        sign_index++;

        while(s.charAt(p1)>='0' && s.charAt(p1)<='9' && sign_index<s.length()){
            int temp=Character.getNumericValue(s.charAt(p1));
            res=check(res,temp,s.charAt(sign_index));
            p1++;
            sign_index++;
        }
        System.out.print(res);
    }
    public static int check(int n1,int n2,char ch){
        if(ch=='+'){
            return n1+n2;
        }else if(ch=='-'){
            return n1-n2;
        }else if(ch=='*'){
            return n1*n2;
        }else{
            return n1/n2;
        }
    }
}
