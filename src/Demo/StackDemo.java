package Demo;


class  Stack {

    int[] a = new int[5];
    int i = 0; //数组下标

    //入栈
    public void push(int n) {
        a[++i] = n;
    }

    //出栈
    public int pop() {
        if (i > 0) {
            return a[i--];
        }
        return -1;
    }

}
public class StackDemo {

    public static void main(String[] args){

        //测试堆栈
        System.out.println("1.数组实现一个堆栈： ");
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push(5);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }
}

