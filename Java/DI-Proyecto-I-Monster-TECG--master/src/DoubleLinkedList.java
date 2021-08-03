/**
 * this list will be used for handling cards
 */
public class DoubleLinkedList {
    private Node head;
    private Node last;
    private int size;
    /**
     * Attributes
     */
    public DoubleLinkedList() {
        this.head = null;
        this.last = null;
        this.size = 0;
    }
    public boolean isEmpty() {
        return this.head == null;
    }
    public int size() {
        return this.size;
    }
    public void insertFirst(Object data) {
        Node newNode = new Node(data);
        if(isEmpty()){
            this.head = newNode;
            this.last = newNode;
            newNode.setNext(null);
            newNode.setPrevious(last);
            this.size++;
        }else{
            newNode.setNext(this.head);
            this.head.setPrevious(newNode);
            newNode.setPrevious(this.last);
            this.head = newNode;
            this.size++;
        }
    }
    public void insertEnd(Object data) {
        Node newNode = new Node(data);
        this.head.setPrevious(newNode);
        newNode.setPrevious(this.last);
        this.last.setNext(newNode);
        newNode.setNext(null);
        this.last = newNode;
    }
    public void deleteFirst(){
        if(isEmpty() == false) {
            if (this.head == this.last) {
                this.head = null;
                this.last = null;
                this.size = 0;
            } else {
                Node temp = this.head;
                this.head = temp.getNext();
                this.head.setPrevious(temp.getPrevious());
                this.size--;
            }
        }
    }
    public void deleteEnd(){
        if(isEmpty() == false){
            if(this.head == this.last){
                this.head = null;
                this.last = null;
                this.size = 0;
            }else{
                Node temp = this.last;
                this.last = temp.getPrevious();
                this.head.setPrevious(temp.getPrevious());
                this.last.setNext(null);
                this.size--;
            }
        }
    }
    public void displayList() {
        Node current = this.head;
        while (current != null) {
            System.out.println(current.getData());
            current = current.getNext();
        }
    }
    public Node find(Object searchValue) {
        Node current = this.head;
        while (current != null) {
            if (current.getData().equals(searchValue)) {
                return current;
            } else {
                current = current.getNext();
            }
        }
        return null;
    }
    public Object Data_find(int position){
        Node current = this.head;
        int i = 1;
        while (current != null) {
            if (i == position) {
                 return current.getData();
            }
            else {
                current = current.getNext();
                i++;
            }
        }
        return null;
    }
    public Node delete(Object searchValue) {
        Node current = this.head;
        while (current != null) {
            if (current.getData().equals(searchValue)) {
                if (current == this.head) {
                    if(this.head.getNext() == null){
                        this.head = null;
                        this.last = null;
                        this.size = 0;
                    }else{
                        Node temp = this.head;
                        this.head = temp.getNext();
                        this.head.setPrevious(temp.getPrevious());
                        this.size--;
                    }
                } else {
                    if(current.getNext() == null){
                        this.head.setPrevious(current.getPrevious());
                        current.getPrevious().setNext(null);
                        this.size--;
                    }else{
                        current.getPrevious().setNext(current.getNext());
                        current.getNext().setPrevious(current.getPrevious());
                        this.size--;
                    }
                }
                return current;
            } else {
                current = current.getNext();
            }
        }
        return null;
    }

}
