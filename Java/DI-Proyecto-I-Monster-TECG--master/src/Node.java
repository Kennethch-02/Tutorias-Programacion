/**
 *  Class Node
 *
 *  To use in linear data structures
 */
public class Node {
    private Object data;
    private Node next;
    private Node previous;
    public Node(Object data) {
        this.next = null;
        this.previous = null;
        this.data = data;
    }

    public Object getData() {
        return this.data;
    }
    public void setData(Object data) {
        this.data = data;
    }
    public Node getNext() {
        return this.next;
    }
    public void setNext(Node node) {
        this.next = node;
    }
    public Node getPrevious(){
        return this.previous;
    }
    public void setPrevious(Node node){
        this.previous = node;
    }
}

