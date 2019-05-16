package practice2019.coding.gfg.helper;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LinkedList {
    public List<ListNode> nodes;
    public ListNode head;
    public ListNode tail;

     public LinkedList(List<ListNode> nodes, ListNode head, ListNode tail) {
        this.nodes = nodes;
        this.head = head;
        this.tail = tail;
    }

    public static LinkedList createDescendingList() {
        List<ListNode> nodes = IntStream.rangeClosed(1, 10).mapToObj(ListNode::new).collect(Collectors.toList());
        Collections.reverse(nodes);
        ListNode head = connectNodes(nodes, 0);
        ListNode tail = nodes.get(nodes.size() - 1);
        return new LinkedList(nodes, head, tail);

    }

    private static ListNode connectNodes(List<ListNode> list, int index) {
        if (index > list.size() - 1) {
            return null;
        }
        ListNode head = list.get(index);
        head.next = connectNodes(list, index + 1);
        return head;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        ListNode head = this.head;
        while (head != null) {
            builder.append(head.data);
            builder.append(",");
            head = head.next;
        }
        return builder.toString();

    }
}
