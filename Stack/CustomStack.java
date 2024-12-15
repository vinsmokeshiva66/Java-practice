import java.util.*;
import java.util.EmptyStackException;

public class CustomStack {
    private int arr[];
    private int top=-1;
    private int default_size=10;

    CustomStack(){
        this.arr=new int[default_size];
    }

    private boolean isEmpty(){
        return top==-1;
    }

    private int peek() throws EmptyStackException{
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return arr[top];
    }

    private void pop() throws EmptyStackException{
        if(isEmpty()){
            throw new EmptyStackException();
        }
        arr[top--]=-1;
    }

    private void push(int num){
        if(top==default_size-1){
            resize();
        }
        arr[++top]=num;
    }

    private void resize(){
        int temp[]=new int[arr.length*2];
        for(int i=0;i<arr.length;i++){
            temp[i]=arr[i];
        }
        default_size*=2;
        arr=temp;
    }

    private int search(int num) throws EmptyStackException{
        if(isEmpty()){
            throw new EmptyStackException();
        }
        for(int i=0;i<=top;i++){
            if(arr[i]==num) return i;
        }
        return -1;
    }

    @Override
    public String toString(){
        return Arrays.toString(arr);
    }

    public static void main(String[] args){
        CustomStack stack=new CustomStack();
        stack.push(5);
        stack.push(3);
        stack.isEmpty();
        System.out.println(stack.peek());
        stack.search(5);
        for(int i=2;i<30;i++){
            stack.push(i);
        }
        stack.pop();
        System.out.println(stack);

    }
}

