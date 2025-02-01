public class Problem3 {
    public static void main(String[] args) {
        String s="abcac";
        int n=10;

        int curr_len=s.length();
        while(curr_len<10){
            s+=s;
            curr_len+=s.length();
        }
        int index=0;
        int res=0;
        while(index<n){
            if(s.charAt(index)=='a') res++;
            index++;
        }
        System.out.print(res);
    }
}
