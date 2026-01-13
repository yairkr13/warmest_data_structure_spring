package warmest;

import java.util.HashMap;
import java.util.Map;

public class WarmestDataStructure implements WarmestDataStructureInterface {

    // Node in a doubly linked list - keeps key, value and order
    private static class Node {
        String key;
        int value;
        Node prev;
        Node next;

        Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // Fast access from key to its node
    private final Map<String, Node> map = new HashMap<>();

    // Dummy head and tail to simplify list logic
    private final Node head = new Node(null, 0);
    private final Node tail = new Node(null, 0);

    public WarmestDataStructure() {
        // Initially, the list is empty: head <-> tail
        head.next = tail;
        tail.prev = head;
    }

    @Override
    public Integer put(String key, int value) {
        Node toPutNode = map.get(key);

        // It's a new key
        if (toPutNode == null) {
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            addToEnd(newNode); // new key becomes the warmest
            return null;
        }

        // Not a new key - update value and refresh its position
        int oldValue = toPutNode.value;
        toPutNode.value = value; //changing the old value to new
        moveToEnd(toPutNode); // accessed again, so it's warmest now
        return oldValue;
    }

    @Override
    public Integer remove(String key) {
        // Remove from map first (O(1))
        Node toDeleteNode = map.remove(key);
        if (toDeleteNode == null) {
            return null; // key does not exist
        }

        int oldValue = toDeleteNode.value;
        removeNode(toDeleteNode); // unlink from the list
        return oldValue;
    }

    @Override
    public Integer get(String key) {
        Node toGetNode = map.get(key);
        if (toGetNode == null) {
            return null; // key not found
        }

        // Accessing a key makes it the warmest
        moveToEnd(toGetNode);
        return toGetNode.value;
    }

    @Override
    public String getWarmest() {
        if (isEmpty()) {
            return null; // no keys in the structure
        }
        // The warmest key is always right before the tail
        return tail.prev.key;
    }

    // ---------- Helper Functions ----------
    // Adds a node right before the tail (warmest position)
    private void addToEnd(Node node) {
        Node lastReal = tail.prev; // in the first time lastReal = Head

        lastReal.next = node;
        node.prev = lastReal;

        node.next = tail;
        tail.prev = node;
    }

    // Removes a node from the linked list
    private void removeNode(Node node) {
        Node before = node.prev;
        Node after = node.next;

        before.next = after;
        after.prev = before;

        node.prev = null; //delete the unuse node
        node.next = null;
    }

    // Moves an existing node to the warmest position
    private void moveToEnd(Node node) {
        // Already warmest - nothing to do
        if (tail.prev == node) {
            return;
        }
        removeNode(node);
        addToEnd(node);
    }

    // Checks if the structure has no real nodes
    private boolean isEmpty() {
        return head.next == tail;
    }
}