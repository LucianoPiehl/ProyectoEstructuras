package com.estructuras.estructuras.model;

public interface StackTDA {
    void push(Object element);  // Inserta un elemento en la pila
    Object unstack(); // Elimina y devuelve el elemento en el tope
    Object pop();
    Object readTop();           // Devuelve el elemento en el tope sin eliminarlo
    boolean isEmpty();          // Verifica si la pila está vacía
    boolean isFull();           // Verifica si la pila está llena
    Object getStack();
}
