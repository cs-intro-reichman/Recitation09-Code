public class NodeTwoData {
    int counter;
    String name;
    NodeTwoData next;
   
   /** Constructs a node with the given data. The new node will point to
    *  the given node (next). */
    public NodeTwoData(String name, int counter, NodeTwoData next) {
        this.name = name;
        this.counter = counter;
        this.next = next;
    }
        
   /** Constructs a node with the given data. The new node will point to null , every new item
    will have counter (quantity) 1*/
    public NodeTwoData(String name) {
        this(name, 1, null);
    }     
 }
 
 