package com.estructuras.estructuras.model;

public interface SetTDA {
    void InitializeSet(); // Sin pre-condicion.
    void Add(int x); // Conjunto inicializado.
    int Choose(); // Conjunto inicializado y no vacio.
    boolean EmptySet(); // Conjunto Incializado.
    void Pop(int x); // Conjunto inicializado.
    boolean Belong(int x); // Conjunto inicializado
}
