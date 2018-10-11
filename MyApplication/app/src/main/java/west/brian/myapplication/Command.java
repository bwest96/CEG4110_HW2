package west.brian.myapplication;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Command {
    private Stack<int[]> stack;
    private Stack<int[]> stackR;
    public  Command(){
        stack = new Stack<int[]>();
        stackR = new Stack<int[]>();
    }

    public void pushCmd(int[] arr){
        int [] x = new int[6];
        for(int i = 0;i<x.length;i++){
            x[i] = arr[i];
        }
        stack.push(x);
    }

    public int[] undo(){
        int[] x = new int[6];
        x = stack.pop();
        return x;
    }

    public boolean Sisempty(){
        return stack.isEmpty();
    }

    public boolean Qisempty(){
        return stackR.isEmpty();
    }

    public void addCmd(int[] arr){
        int [] x = new int[6];
        for(int i = 0;i<x.length;i++){
            x[i] = arr[i];
        }
        stackR.push(x);
    }

    public int[] redo(){
        int[] x = new int[6];
        x = stackR.pop();
        return x;
    }

    public void emptyRedo(){
        stackR.removeAllElements();
    }

}
