/** Represents a node in a linked list.  A node has a value and a pointer
 * to another node. */
public class Node {

    int data;  
    Node next;
     
    /** Constructs a node with the given data. The new node will point to 
     *  the given node (next). */
    Node(int data, Node next) {
       this.data = data;
       this.next = next;
    }
         
    /** Constructs a node with the given data. The new node will point 
     *  to null */
    Node(int data) {
       this(data, null);
    }
 
    public static void test(Node temp){
        temp.data = 5;
    }
            
 }
 