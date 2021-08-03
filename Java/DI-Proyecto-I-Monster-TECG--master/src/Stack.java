/**
 *  Class Stack for linear data structures
 */
public class Stack {
    private int maxSize;
    private Object[] stackArray;
    private int top;
    public Stack(int maxSize){
        this.maxSize = maxSize;
        this.top = 0;
        this.stackArray = new Object[maxSize];
    }
    public void push(Object newObject) throws Exception {
        if (top < maxSize) {
            this.stackArray[++top] = newObject;
        } else {
            throw new Exception("Stack is full");
        }
    }
    public Object pop() {
        return this.stackArray[top--];
    }
    public Object peek() {
        return this.stackArray[top];
    }
}