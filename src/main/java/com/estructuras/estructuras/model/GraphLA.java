package com.estructuras.estructuras.model;

//Vertices = vertex
//Aristas = Edges
public class GraphLA implements GraphTDA {
    NodeGraph origin;

    @Override
    public void InitializeGraph() {
        origin = null;
    }

    @Override
    public void AddVertex(int v, String estado) {
        NodeGraph aux = new NodeGraph();
        aux.status = estado;
        aux.node = v;
        aux.edge = null;
        aux.nextNode = origin;
        origin = aux;
        System.out.println(aux.status);
        System.out.println(aux.node);
        System.out.println(aux.edge);
        System.out.println(aux.nextNode);
    }
    private NodeGraph Vert2Node(int v){
        NodeGraph aux = origin;
        while (aux != null && aux.node != v){
            aux = aux.nextNode;
        }
        return aux;
    }
    @Override
    public void DeleteVertex(int v) {
        if(origin.node == v){
            origin = origin.nextNode;
        }
        NodeGraph aux = origin;
        while(aux != null){
            this.DeleteEdgeNode(aux, v);
            if(aux.nextNode != null && aux.nextNode.node == v){
                aux.nextNode = aux.nextNode.nextNode;
            }
            aux = aux.nextNode;
        }
    }

    @Override
    public void AddEdge(int v1, int v2, int p) {
        NodeGraph n1 = Vert2Node(v1);
        NodeGraph n2 = Vert2Node(v2);
        NodeEdge aux = new NodeEdge();
        aux.nametag = p;
        aux.destinationNode = n2;
        aux.nextEdge = n1.edge;
        n1.edge = aux;
    }
    private void DeleteEdgeNode(NodeGraph node, int v){
        NodeEdge aux = node.edge;
        if (aux != null){
            if (aux.destinationNode.node == v){
                node.edge = aux.nextEdge;
            }else{
                while (aux.nextEdge != null && aux.nextEdge.destinationNode.node != v){
                    aux = aux.nextEdge;
                }
                if (aux.nextEdge != null){
                    aux.nextEdge = aux.nextEdge.nextEdge;
                }
            }
        }
    }
    @Override
    public void DeleteEdge(int v1, int v2) {
        NodeGraph n1 = Vert2Node(v1);
        DeleteEdgeNode(n1, v2);
    }

    @Override
    public int EdgeWeight(int v1, int v2) {
        NodeGraph n1 = Vert2Node(v1);
        NodeEdge aux = n1.edge;
        while (aux.destinationNode.node != v2){
            aux = aux.nextEdge;
        }
        return aux.nametag;
    }

    @Override
    public SetTDA vertex() {
        SetTDA c = new SetLD();
        c.InitializeSet();
        NodeGraph aux = origin;
        while (aux != null){
            c.Add(aux.node);
            aux = aux.nextNode;
        }
        return c;
    }

    @Override
    public boolean EdgeExists(int v1, int v2) {
        NodeGraph n1 = Vert2Node(v1);
        NodeEdge aux = n1.edge;
        while (aux != null && aux.destinationNode.node != v2){
            aux = aux.nextEdge;
        }
        return (aux != null);
    }

    @Override
    public void ChangeStatus(String status, NodeGraph node) {
        node.status = status;
    }
    public NodeGraph ReturnNode(int v){
        NodeGraph node = Vert2Node(v);
        return node;
    }


    public SetTDANode AdjacentNodes(NodeEdge edge, String status){
        SetTDANode adjacentNodes = new SetLDNode();
        while (edge != null) {
            NodeGraph destinationNode = edge.getDestinationNode();
            if (destinationNode.getStatus().equals(status)) {
                adjacentNodes.Add(destinationNode);
            }
            edge = edge.getNextEdge();
        }
        return adjacentNodes;

    }
}
