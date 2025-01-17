package com.estructuras.estructuras.model;

public interface SetTDANode {
    void InitializeSet(); // Sin pre-condicion.
    void Add(NodeGraph x); // Conjunto inicializado.
    NodeGraph Choose(); // Conjunto inicializado y no vacio.
    boolean EmptySet(); // Conjunto Incializado.
    void Pop(NodeGraph x); // Conjunto inicializado.
    boolean Belongs(NodeGraph x); // Conjunto inicializado
}
