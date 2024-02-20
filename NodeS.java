public class NodeS {
    String data;
    NodeS next;

    public NodeS(String data, NodeS next) {
        this.data = data;
        this.next = next;
    }

    public NodeS(String data) {
        this(data, null);
    }

    public String toString() {
        return this.data;
    }
}
