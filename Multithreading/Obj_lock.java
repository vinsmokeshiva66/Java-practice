public class Obj_lock {
    public synchronized void display(String message){
        for(int i=0;i<5;i++){
            System.out.println(message+"-"+i);
            try{
                Thread.sleep(500);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
