package com.phongth2004110017.tieuluancuoiky;

public class Node {
    HangHoa data;
    Node next;

    public Node() {
        data = null;
        next = null;

    }

    public Node(HangHoa hangHoa) {
        data = hangHoa;
        next = null;
    }

    public Node(HangHoa hangHoa, Node node) {
        data = hangHoa;
        next = node;
    }

}
