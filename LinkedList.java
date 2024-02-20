public class LinkedList {
    private Node first;
    private int size;
	
    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        LinkedList l2 = new LinkedList();
        LinkedList l3 = l1;
        l1.addFirst(1);    
        l2.addFirst(1);
        l1.addFirst(2);    
        l2.addFirst(2);
        l1.addFirst(3);    
        l2.addFirst(3);
        System.out.println(l1 == l3);
        
        // System.out.println(l1);
        // System.out.println(l2);
        test(l1);
        System.out.println(l1);
        l1.addLast(1, 4);
        System.out.println(l1);
        l1.addLast(0, 5);
        System.out.println(l1);
        try {
            l1.addLast(l1.size, 6);    
        } catch (Exception e) {
            // TODO: handle exception
            l1.addLast(l1.size - 1, 6);
        } finally {
            System.out.println(l1);
        }
        l1.addLast(l1.size-1,7);
        System.out.println(l1);
        l1.removeAtIndex(2);
        System.out.println(l1);
        l1.removeAtIndex1(2);
        System.out.println(l1);
        System.out.println(l1.get(0));
        System.out.println(l1.get(l1.size-1));
        System.out.println(l1.get(2));
        
    }

    /** Constructs an empty list. */
    public LinkedList () {
        this.first = null; // some default value 
        this.size = 0;
     }

     public boolean isEmpty () {
        // return this.first == null; //
        return this.size == 0;
     }
    
     public int get(int index){
        if (index >= this.size || index < 0){
            throw new IndexOutOfBoundsException("illegal index " + index);
        }      
        Node current = this.first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }
    // n * O(1) = O(n)
    /** Inserts the given element at the beginning of this list */
    public void addFirst(int ele) {
        Node newNode = new Node(ele);
        newNode.next = this.first; 
        this.first = newNode;
        this.size++;
    } 

    // O(n) * n = O(n^2)
public void addLast(int val) {
    // Creates a new node with the given value
    Node newNode = new Node(val);
    // If the list is empty, the new node becomes the first node
    if (first == null) {
        first = newNode;
    } else {
        // Finds the last node and makes it point to the new node
        Node current = first;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        }
        size++;
    }   
    public boolean equals (LinkedList other){
        if (this.size != other.size) {
            return false;
        }
        Node cur = this.first.next;
        Node otherCur = other.first.next;
    
        while (cur != null) {
            if (cur.data != otherCur.data) {
                return false;
            }
            cur = cur.next;
            otherCur = otherCur.next;
        }
        return true;
    }
    
    /** Returns a string representation of this list. */
    public String toString() {
        if (this.size == 0) {
            return "()";  
        }
        // Starting from the first node, iterates through this list
        // and builds the string incrementally
        String str = "(";
        Node current = this.first;
        while (current != null) {
            str += current.data + " ";
            current = current.next;
        }
        // Removes the trailing space and adds the ‘)’
        return str.substring(0, str.length() - 1) + ")";
    }

    public static void test(LinkedList temp){
        temp.addFirst(1);
    }

    public static void test2(LinkedList temp){
        Node.test(temp.first.next);
    }
    
    public boolean removeAtIndex(int index) {
        if (index < 0 || index >= this.size || this.first == null) {
            // Index out of bounds or list is empty
            return false;
        }
        
        if (index == 0) {
            this.first = this.first.next;
            this.size--; // Decrease the size of the list
            return true;
        } 
        // Traverse the list to find the node at the given index
        Node current = first;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
            
        // Remove the node at the given index
        current.next = current.next.next;
        
        this.size--; // Decrease the size of the list
        return true;
    }
    
    public boolean removeAtIndex1(int index) {
        if (index < 0 || index >= this.size || this.first == null) {
            // Index out of bounds or list is empty
            return false;
        }
        
        if (index == 0) {
            this.first = this.first.next;
            this.size -- ;
            return true;
        } 
        
        // Traverse the list to find the node at the given index
        Node prev = null;
        Node current = this.first;
        for (int i = 0; i < index; i++) {
            prev = current;
            current = current.next;
        }
            
        // Remove the node at the given index
        prev.next = current.next;
        current = null;
        
        this.size--; // Decrease the size of the list
        return true;
    }
   
    public void addLast(int index, int e) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("illegal index " + index);
        }
        if (index == 0){ 
            this.addFirst(e);
            return;
        }
        if (index == this.size - 1){
            this.addLast(e);
            return;
        }
        Node insert = new Node(e);
        Node prev = this.first;
        Node current = this.first.next;
        for (int i = 0; i < index; i++) {
            prev = current;
            current = current.next;
        }
        prev.next = insert;
        insert.next = current;
        this.size++;
    }

    public int[] toArray() {
        int[] arr = new int[this.size];
        Node cur = this.first;
        for (int i = 0; i < arr.length; i++) {
        arr[i] = cur.data;
        cur = cur.next; 
        }
        return arr;
    }

    public void printSize () {
        System.out.println(this.size);
    } 
    
    
}

