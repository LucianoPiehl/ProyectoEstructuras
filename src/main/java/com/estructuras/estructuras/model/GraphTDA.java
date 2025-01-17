package com.estructuras.estructuras.model;


public interface GraphTDA {
    void InitializeGraph(); // Sin pre-condicion.
    void AddVertex(int v, String estado); // Grafo inicializado y existe nodo v.
    void DeleteVertex(int v); // Grafo inicializado y existe nodo v.
    void AddEdge(int v1, int v2, int p); // Grafo inicializado y no existe arista (v1, v2).
    void DeleteEdge(int v1, int v2); // Grafo inicializado y existe arista (v1, v2).
    int EdgeWeight(int v1, int v2); // Grafo inicializado y existe arista (v1, v2).
    SetTDA vertex(); // Grafo Inicializado.
    boolean EdgeExists(int v1, int v2); // Grafo inicializado y existen nodos v1,v2


    void ChangeStatus(String estado, NodeGraph nodo);
    public NodeGraph ReturnNode(int v);
    public SetTDANode AdjacentNodes(NodeEdge arista, String estado);

}
