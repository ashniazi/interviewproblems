
/*
HH Solution

Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.

A Node is defined as:
    class Node {
        int data;
        Node next;
    }


boolean hasCycle(Node head) {
        //Traverse through list.
        if(head == null)
        return false;
        Node slow = head;
        Node fast = head.next;
        while(slow!=fast){
        if(slow == null || fast.next == null)
        return false;
        slow = slow.next;
        fast = fast.next.next;
        }
        return true;
        }


        Alternate :

boolean hasCycle(Node head) {
    //Traverse through list.
    Set<Node> seen = new Hashset<>();
    while(head != null){
        seen.add(head);
        head = head.next;
        if(seen.contains(head))
            return true;
    }
    return false;


}
 */


package com.company;

import java.util.concurrent.TimeUnit;

//Node Class
class Node {
    public int data;
    public Node next;

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    public void printLink() {
        System.out.print("{" + data + "}");
    }

    public String toString() {
        return data + "";
    }
}

//Linked List Class
class LList {
    public Node head;

    //Init head to null
    public LList() {
        head = null;
    }

    //Check if List is empty.
    public boolean isEmpty(LList list) {
        return head == null;
    }

    //Insert node at the first index.
    public void prepend(int d) {
        Node n = new Node(d, null);
        //Node n points to what head pointed to.
        n.next = head;
        head = n; //set head to point to new node
    }

    //returns if node is the last node, i,e points to head.
    public boolean checkIfLastNode(Node n) {
        return (n.next == head);
    }

    public boolean checkIfSecondLastNode(Node n) {
        return (n.next.next == head);
    }

    //Insert node at the last index
    public void append(int d) {
        Node newNode = head;
        //Iterate through the list until finding the last one.
        if(head.next == null)
            head.next = newNode;
        while(newNode.next.next.data != head.data)
            newNode = newNode.next;
        newNode.next = new Node(d,head);
    }

    public void printList() {
        Node currentNode = head;
        System.out.print("List: ");
        try {
            while (currentNode.next != head) {
                currentNode.printLink();

                currentNode = currentNode.next;
            }
        } catch (Exception e) {}
        System.out.println("");

    }//end of printList
}//

public class Main {


    boolean hasCycle(Node head) {


        return false;
    }

    public static void main(String[] args) throws Exception {
        //Init the head
        //printWithDelays("Creating Linked List:...", TimeUnit.MILLISECONDS, 20);
        LList llist = new LList();
        //printWithDelays("Success.\n", TimeUnit.MILLISECONDS, 20);
        //printWithDelays("Checking if List is empty...", TimeUnit.MILLISECONDS, 20);
        System.out.println(String.valueOf(llist.isEmpty(llist)));

        //Add first node
        llist.prepend(69);
        llist.prepend(34);
        llist.prepend(33);

        llist.printList();
        llist.append(74);
        System.out.println(llist.head);
        //llist.printList();


    }

    public static void printWithDelays(String data, TimeUnit unit, long delay)
            throws InterruptedException {
        for (char ch : data.toCharArray()) {
            System.out.print(ch);
            unit.sleep(delay);
        }
    }
}
