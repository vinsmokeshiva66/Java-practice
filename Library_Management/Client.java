public class Client {
    public static void main(String[] args) {
        for(int i=1;i<=10;i++){
            System.out.print("for Loop"+" "+i+" ");
        }
        System.out.println();

        int count=1;
        while(count<=10){
            System.out.print("While loop"+" "+count+" ");
            count++;
        }
        System.out.println();

        count=1;
        do{
            System.out.print("Do While"+" "+count+" ");
            count++;
        }while(count<11);
        
    }
}



