package algorithm.algoexpert;

public class RemoveDuplicatesFromLinkedList {
    public static void main(String[] args) {
        LinkedList linkedList1 = new LinkedList(1);
        LinkedList linkedList2 = new LinkedList(1);
        linkedList1.next = linkedList2;
        LinkedList linkedList3 = new LinkedList(1);
        linkedList2.next = linkedList3;
        LinkedList linkedList4 = new LinkedList(2);
        linkedList3.next = linkedList4;
        LinkedList linkedList5 = new LinkedList(2);
        linkedList4.next = linkedList5;
        LinkedList linkedList6 = new LinkedList(3);
        linkedList5.next = linkedList6;
        LinkedList linkedList7 = new LinkedList(3);
        linkedList6.next = linkedList7;
        LinkedList linkedList8 = new LinkedList(4);
        linkedList7.next = linkedList8;
        LinkedList linkedList9 = new LinkedList(4);
        linkedList8.next = linkedList9;
        LinkedList linkedList10 = new LinkedList(5);
        linkedList9.next = linkedList10;

        LinkedList result = new RemoveDuplicatesFromLinkedList().removeDuplicatesFromLinkedList(linkedList1);
        System.out.println(result);
    }

    public LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
        int min = linkedList.value;

        LinkedList previousNode = linkedList;
        LinkedList nextNode = linkedList.next;
        while(nextNode != null) {
            if (nextNode.value == min) {
                previousNode.next = nextNode.next;
            } else {
                min = nextNode.value;
                previousNode = nextNode;
            }
            nextNode = nextNode.next;
        }

        return linkedList;
    }

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }
}
