# stack
## 스택 코드 구현
```java
class Stack {
    int index;
    int [] st;
    int size;
    public Stack(int size){
        this.size = size;
        this.st = new int[size];
        this.index = -1;
    }
    public int peek() {
        if(empty()){
            System.out.println("Stack is Empty!");
            return -1;
        }
        return st[this.index];
    }
    public boolean empty() {
        return (this.index == -1);
    }
    public boolean isFull() {
        return (index == this.size-1);
    }
    public void push(int num) {
        if(isFull()) {
            System.out.println("Stack is full!");
            return;
        }
        st[++this.index] = num;
    }
    public int pop() {
        if(empty()){
            System.out.println("Stack is Empty!");
            return -1;
        }
        return st[this.index--];
    }

}
public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack(4);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.pop());
        System.out.println((stack.peek()));
        System.out.println(stack.pop());
        System.out.println((stack.peek()));

    }
}
```

## Stack 클래스
```java
import java.util.Stack;
Stack <integer> st = new Stack();
```
### 메서드

