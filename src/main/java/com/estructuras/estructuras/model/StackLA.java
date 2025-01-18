package com.estructuras.estructuras.model;

public class StackLA implements StackTDA {
    private int maxSize;     // Tamaño máximo de la pila
    private Object[] stack;  // Array para almacenar elementos de cualquier tipo
    private int top;         // Índice del tope de la pila

    public StackLA(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new Object[maxSize];
        this.top = -1;       // Pila vacía inicialmente
    }

    public Object[] getStack() {
        Object[] currentStack = new Object[top + 1];
        System.arraycopy(this.stack, 0, currentStack, 0, top + 1);
        return currentStack; // Devuelve una copia de los elementos actuales en la pila
    }

    @Override
    public void push(Object element) {
        if (isFull()) {
            throw new IllegalStateException("La pila está llena");
        }
        this.stack[++top] = element; // Incrementa el índice del tope y agrega el elemento
        System.out.println("Se hizo Push con valor: "+this.stack[top]);
    }

    @Override
    public Object unstack() {
        if (isEmpty()) {
            throw new IllegalStateException("La pila está vacía");
        }
        System.out.println("Se hizo Unstack con valor: "+this.stack[top--]);
        return this.stack[top--]; // Devuelve el elemento y reduce el índice del tope
    }

    @Override
    public Object pop() {
        //Verificar funcionamiento, no fue testeada.
        if (top < 0 || top >= this.stack.length) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Object a = this.stack[top];
        System.out.println("Se hizo Pop con valor: "+this.stack[top]);
        this.stack[top] = null;
        this.top -= 1;
        if (!(top==-1)) {
            System.out.println("Ahora esa posicion por el Pop tiene valor: " + this.stack[top]);
        }
        return a;
    }

    @Override
    public Object readTop() {
        if (isEmpty()) {
            throw new IllegalStateException("La pila está vacía");
        }
        System.out.println("Se hizo readTop con valor: "+this.stack[top]);
        return this.stack[top]; // Devuelve el elemento en el tope sin removerlo
    }

    @Override
    public boolean isEmpty() {
        System.out.println("Se hizo isEmpty dio resultado: "+ String.valueOf(top == -1));
        return top == -1;
    }

    @Override
    public boolean isFull() {
        System.out.println("Se hizo isFull dio resultado: "+ String.valueOf(top == maxSize-1));
        return top == maxSize - 1;
    }
}
