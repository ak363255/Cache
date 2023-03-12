package doubly_linked_list;

public class DoublyLinkedList {
    Node head ,tail;
    public Node getHead(){
        return head;
    }
    public Node getTail(){
        return tail;
    }
    public void addNodeAtEnd(Node node){
        if(tail == null){
            tail = node;
            head = node;
        }else{
            if(node != null){
                tail.nextNode = node;
                node.previousNode = tail;
                tail = node;
            }
        }
    }

    public Node moveHead(){
        Node temp = head;
        if(head != null){
            Node nextNode = head.nextNode;
            if(nextNode != null){
                nextNode.previousNode = null;
            }
            head = nextNode;
        }
        return temp;
    }

    public void deattachNode(Node node){
        if(node != null){
            Node nextNode = node.nextNode;
            Node previousNode = node.previousNode;
            if(nextNode != null){
                nextNode.previousNode = previousNode;
            }
            if(previousNode != null){
                previousNode.nextNode = nextNode;
            }
        }
    }
}

