package com.estructuras.estructuras.model;

import com.estructuras.estructuras.model.NodeGraph;

public class SetLDNode implements SetTDANode {
    private class Node {
        NodeGraph info;
        Node next;
    }

    private Node c;
    @Override
    public void InitializeSet() {
        c = null;
    }

    @Override
    public void Add(NodeGraph x) {
        if (this.Belongs(x)){
            Node nuevo = new Node();
            nuevo.info = x;
            nuevo.next = c;
            c = nuevo;
        }
    }

    @Override
    public NodeGraph Choose() {
        return c.info;
    }

    @Override
    public boolean EmptySet() {
        return (c == null);
    }

    @Override
    public void Pop(NodeGraph x) {
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
    public boolean Belongs(NodeGraph x) {
        Node aux = c;
        while (aux != null && aux.info != x){
            aux = aux.next;
        }
        return (aux == null);
    }
}
