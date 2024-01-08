package eviction_policies;

import algorithm.dll.DoublyLinkedList;
import algorithm.dll.DoublyLinkedListNode;

import java.util.HashMap;

public class LRUEvictionPolicy implements IEvictionPolicy <String> {

    DoublyLinkedList<String> ddl;
    HashMap<String, DoublyLinkedListNode<String>> mapping;

    public LRUEvictionPolicy() {
        ddl = new DoublyLinkedList<>();
        mapping = new HashMap<>();
    }
    @Override
    public void keyAccessed(String key) {
        if (mapping.containsKey(key)) {
            DoublyLinkedListNode<String> node = mapping.get(key);
            ddl.addNodeToEnd(node);
        } else {
            DoublyLinkedListNode<String> newNode = ddl.addElementToEnd(key);
            mapping.put(key, newNode);
        }
    }

    @Override
    public String evict() {
        DoublyLinkedListNode<String> front = ddl.removeElementFromFront();
        if (front != null) {
            mapping.remove(front.element);
            return front.element;
        }

        return null;
    }
}
