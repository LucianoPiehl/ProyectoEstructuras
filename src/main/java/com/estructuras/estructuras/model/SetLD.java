package com.estructuras.estructuras.model;

public class SetLD implements SetTDA {
    private class Node {
        int info;
        Node next;
    }

    private Node c;
    @Override
    public void InitializeSet() {
        c = null;
    }

    @Override
    public void Add(int x) {
        if (this.Belong(x)){
            Node newNode = new Node();
            newNode.info = x;
            newNode.next = c;
            c = newNode;
        }
    }

    @Override
    public int Choose() {
        return c.info;
    }

    @Override
    public boolean EmptySet() {
        return (c == null);
    }

    @Override
    public void Pop(int x) {
        if(c != null){
            if (c.info == x){
                c = c.next;
            }else {
                Node aux = c;
                while (aux.next != null && aux.next.info != x){
                    aux = aux.next;
                    if (aux.next != null){
                        aux.next = aux.next.next;
                    }
                }
            }
        }
    }

    @Override
    public boolean Belong(int x) {
        Node aux = c;
        while (aux != null && aux.info != x){
            aux = aux.next;
        }
        return (aux == null);
    }
}
