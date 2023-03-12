package cache.eviction_strategy;

import doubly_linked_list.DoublyLinkedList;
import doubly_linked_list.Node;

import java.util.HashMap;
import java.util.Map;

public class LRUEvictionStragegy implements EvictionStrategy {

    private DoublyLinkedList doublyLinkedList;
    private Map<String, Node> nodeMapper;

    public LRUEvictionStragegy() {
        this.doublyLinkedList = new DoublyLinkedList();
        this.nodeMapper = new HashMap<>();
    }

    @Override
    public void keyAccessed(String key) {
        if (nodeMapper.containsKey(key)) {
            doublyLinkedList.deattachNode(nodeMapper.get(key));
        } else {
            Node node = new Node();
            node.value = key;
            doublyLinkedList.addNodeAtEnd(node);
            nodeMapper.put(key, node);
        }
    }

    @Override
    public String evictKey() {
        Node node = doublyLinkedList.moveHead();
        return node.value;
    }
}
