package algorithm.dll;

import algorithm.exception.InvalidElementException;

public class DoublyLinkedList <Element> {

    final private DoublyLinkedListNode<Element> head, tail;

    public DoublyLinkedList() {
        head = new DoublyLinkedListNode<>(null);
        tail = new DoublyLinkedListNode<>(null);

        head.next = tail;
        tail.prev = head;
    }

    public DoublyLinkedListNode<Element> detachNode(DoublyLinkedListNode<Element> node) {
        if (!isEmpty() || node != null) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.next = null;
            node.prev = null;
        }
        return node;
    }

    public void addNodeToEnd(DoublyLinkedListNode<Element> node) {
        detachNode(node);
        tail.prev.next = node;
        node.next = tail;
        node.prev = tail.prev;
        tail.prev = node;
    }

    public DoublyLinkedListNode<Element> addElementToEnd(Element element) {
        if (element == null) {
            throw new InvalidElementException();
        }

        DoublyLinkedListNode<Element> node = new DoublyLinkedListNode<Element>(element);
        tail.prev.next = node;
        node.next = tail;
        node.prev = tail.prev;
        tail.prev = node;

        return node;
    }

    public DoublyLinkedListNode<Element> removeElementFromFront() {
        if (!isEmpty()) {
            return detachNode(head.next);
        }
        return null;
    }

    public boolean isEmpty() {
        return head.next == tail;
    }
}
