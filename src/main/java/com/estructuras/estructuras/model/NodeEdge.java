package com.estructuras.estructuras.model;

public class NodeEdge {
    int nametag;
    NodeGraph destinationNode;
    NodeEdge nextEdge;

    public NodeGraph getDestinationNode() {
        return destinationNode;
    }

    public NodeEdge getNextEdge() {
        return nextEdge;
    }
}
