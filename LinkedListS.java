import java.security.InvalidParameterException;

public class LinkedListS {
    private NodeS first;
    private int size; // comment

    public LinkedListS() {
        this.first = null;
        this.size = 0;
    }

    public int getSize() {
        return this.size;
    }

    public void addFirst(String data) {
        NodeS newNode = new NodeS(data);
        newNode.next = this.first;
        this.first = newNode;
        this.size++;
    }

    public boolean contain(String data) {
        NodeS current = this.first;
        while (current != null) {
            if (current.data.equals(data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public int indexOf(String data) {
        if (!this.contain(data)) {
            return -1;
        }
        return this.indexOf(data, 0, this.first);
    }

    private int indexOf(String data, int index, NodeS current) {
        if (current.data.equals(data)) {
            return index;
        }
        return this.indexOf(data, index + 1, current.next);
    }

    public boolean removeAtIndex(int index) {
        if (index < 0 || index >= this.size || this.first == null) {
            // Index out of bounds or list is empty
            return false;
        }
        
        if (index == 0) {
            this.first = this.first.next; // Remove first
            return true;
        } 
        // Traverse the list to find the node at the given index
        NodeS prev = null;
        NodeS current = this.first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
            
        // Remove the node at the given index
        prev.next = current.next;	
        current = null; // recycle 
        this.size--; // Decrease the size of the list
        return true;
    }

    public String get(int index){
        if (index >= this.size || index < 0){
            throw new IndexOutOfBoundsException("illegal index " + index);
        }      
        NodeS current = this.first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    public void addLast(String data) {
        if (this.size == 0) {
            this.addFirst(data);
            return;
        }
        NodeS current = this.first;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new NodeS(data);
        this.size++;
    }

    public String [] toArray(){
        String [] result = new String[this.size];
        NodeS current = this.first;
        for (int i = 0; i < this.size; i++){
            result[i] = current.data;
            current = current.next;
        }
        return result;
    }
    
    public void add(int index, String data) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("illegal index " + index);
        }
        if (index == 0){ 
            this.addFirst(data);
            return;
        }
        if (index == this.size - 1){
            this.addLast(data);
            return;
        }
        NodeS insert = new NodeS(data);
        NodeS prev = this.first;
        NodeS current = this.first.next;
        for (int i = 0; i < index; i++) {
            prev = current;
            current = current.next;
        }
        prev.next = insert;
        insert.next = current;
        this.size++;
    }

    public LinkedListS reverse () {
       NodeS cur = this.first;
       LinkedListS rev = new LinkedListS();
       while (cur != null){
	        rev.addFirst(cur.data);
            cur = cur.next;
       }
       return rev;

    }

    public LinkedListS subListBad(int start, int end) {
       if (start < 0 || end >= this.size) {
           throw new InvalidParameterException();
       }
       NodeS cur = this.first;
       LinkedListS sub = new LinkedListS();
       for (int i = 0; i < this.size; i++) {
           if (start <= i && i < end) {
               sub.addLast(cur.data);
           }
           cur = cur.next;
       }
       return sub;
   }

   public LinkedListS subListGood(int start, int end) {
        if (start < 0 || end >= this.size) {
            throw new InvalidParameterException();
        }
        NodeS cur = this.first;
        LinkedListS sub = new LinkedListS();
        for (int i = 0; i < this.size; i++) {
            if (start <= i && i < end) {
             sub.addFirst(cur.data);
            }
            cur = cur.next;
        }
        return sub.reverse();
    }

    public boolean equals(LinkedListS other) {
        if (this.size != other.getSize()) {
            return false;
        }
        NodeS myCur = this.first;
        NodeS otherCur = other.first;
        while (myCur != null && otherCur != null) {
            if (!myCur.data.equals(otherCur.data)) {
                return false;
            }
            myCur = myCur.next;
            otherCur = otherCur.next;
        }
        return true;
    }
 
 
}
