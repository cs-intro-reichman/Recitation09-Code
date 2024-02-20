public class LinkedListTwoData {
    private NodeTwoData first;
    private int size;

    public LinkedListTwoData () {
        this.first = null;
        this.size = 0;
    }
 
    public void addFirst(String name) {
        NodeTwoData newNode = new NodeTwoData(name);
        newNode.next = this.first;
        this.first = newNode;
        this.size++;
    }

    public boolean contain(String name){
        NodeTwoData current = this.first;
        while (current != null){
            if (current.name.equals(name)){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public int indexOf (String name){
        if (!this.contain(name)) {
            return -1;
        }
        return this.indexOf(name, 0, this.first);
    }  

    private int indexOf (String name, int index, NodeTwoData current){
        if (current.name.equals(name)){
            return index;
        }
        return this.indexOf(name, index + 1, current.next);
    }

    public void update(int index){
        if (index >= this.size || index < 0){
            throw new IndexOutOfBoundsException("illegal index " + index);
        }     
        NodeTwoData current = this.first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.counter++; // call by reference so will change in the actual list
    }
 
    public void addUnique(String name){
        if (!this.contain(name)){
            this.addFirst(name);
            return;
        }
        this.update(this.indexOf(name));
    }
  
}