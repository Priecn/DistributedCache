package algorithm.dll;

public class DoublyLinkedListNode<Element> {
    public DoublyLinkedListNode<Element> next, prev;
    public Element element;

    public DoublyLinkedListNode(Element element) {
        this.element = element;
        next = null;
        prev = null;
    }
}
