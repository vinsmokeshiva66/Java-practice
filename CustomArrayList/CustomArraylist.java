import java.util.*;
public class CustomArraylist {
    private int arr[];
    private int default_size=10;
    private int size=0;

    CustomArraylist(){
        this.arr=new int[default_size];
    }

    private void add(int num){
        if(isFull()){
            resize();
        }
        arr[size++]=num;
    }

    private boolean isFull(){
        if(size==arr.length) return true;
        else return false;
    }

    private void resize(){
        int temp[]=new int[arr.length*2];
        for(int i=0;i<size;i++){
            temp[i]=arr[i];
        }
        arr=temp;
    }

    private void set(int num){
        arr[size++]=num;
    }

    private int get(int num){
        for(int i=0;i<size;i++){
            if(arr[i]==num) return i;
        }
        return -1;
    }

    @Override
    public String toString(){
        return Arrays.toString(arr);
    }
    public static void main(String[] args){
        CustomArraylist list=new CustomArraylist();
        list.add(1);
        list.get(1);
        list.set(3);

        for(int i=0;i<11;i++){
            list.add(i);
        }
        System.out.print(list);
    }


}
