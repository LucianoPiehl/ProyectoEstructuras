package com.estructuras.estructuras.service;
import com.estructuras.estructuras.model.*;
import org.springframework.stereotype.Service;

@Service
public class GraphService {

    private GraphTDA graph;

    public GraphService() {
        this.graph = new GraphLD(); // Inicializa el grafo
        this.graph.InitializeGraph();
    }

    public void addVertex(int v, String status) {
        graph.AddVertex(v, status);
    }

    public void removeVertex(int v) {
        graph.DeleteVertex(v);
    }

    public void addEdge(int v1, int v2, int weight) {
        graph.AddEdge(v1, v2, weight);
    }

    public void removeEdge(int v1, int v2) {
        graph.DeleteEdge(v1, v2);
    }
    public int edgeWeight(int v1, int v2){
        return graph.EdgeWeight(v1,v2);
    }
    public boolean edgeExists(int v1, int v2) {
        return graph.EdgeExists(v1, v2);
    }

    public SetTDA getVertices() {
        return graph.vertex();
    }

    public SetTDANode getAdjacentNodes(int v) {
        NodeGraph node = graph.ReturnNode(v);
        return graph.AdjacentNodes(node.getArista(), "some_status");
    }

    // Otros métodos necesarios que usen la lógica de tu GraphLA...
}


