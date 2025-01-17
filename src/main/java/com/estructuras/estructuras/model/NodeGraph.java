package com.estructuras.estructuras.model;

public class NodeGraph {
    int node;
    NodeEdge edge;
    NodeGraph nextNode;
    String status;

    public String getStatus() {
        return status;
    }

    public int getNode() {
        return node;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public NodeEdge getArista() {
        return edge;
    }
}
