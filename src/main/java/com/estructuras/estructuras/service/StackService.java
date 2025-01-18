package com.estructuras.estructuras.service;

import com.estructuras.estructuras.model.StackLA;
import com.estructuras.estructuras.model.StackTDA;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class StackService {

    private StackTDA stack;

    public StackService() {
        this.stack = new StackLA(4); // Inicializa el grafo
    }


    private Object[] getStackState() {
        // Retorna el estado actual de la pila
        return ((StackLA) this.stack).getStack();
    }

    public Map<String, Object> push(int v) {
        Map<String, Object> response = new HashMap<>();
        try {
            this.stack.push(v);
            response.put("message", "Element pushed successfully");
            response.put("stack", getStackState());
        } catch (IllegalStateException e) {
            response.put("error", e.getMessage());
        }
        return response;
    }


    public Map<String, Object> pop() {
        Map<String, Object> response = new HashMap<>();
        try {
            Object poppedElement = this.stack.pop();
            response.put("poppedElement", poppedElement);
            response.put("stack", getStackState());
        } catch (Exception e) {
            response.put("error", e.getMessage());
        }
        return response;
    }

    public Map<String, Object> readTop() {
        Map<String, Object> response = new HashMap<>();
        try {
            Object topElement = this.stack.readTop();
            response.put("topElement", topElement);
            response.put("stack", getStackState());
        } catch (Exception e) {
            response.put("error", e.getMessage());
        }
        return response;
    }
    public Map<String, Object> unstack() {
        Map<String, Object> response = new HashMap<>();
        try {
            Object unstackedElement = this.stack.unstack();
            response.put("unstackedElement", unstackedElement);
            response.put("stack", getStackState());
        } catch (Exception e) {
            response.put("error", e.getMessage());
        }
        return response;
    }

    public Map<String, Object> isEmpty() {
        Map<String, Object> response = new HashMap<>();
        response.put("isEmpty", this.stack.isEmpty());
        response.put("stack", getStackState());
        return response;
    }

    public Map<String, Object> isFull() {
        Map<String, Object> response = new HashMap<>();
        response.put("isFull", this.stack.isFull());
        response.put("stack", getStackState());
        return response;
    }
}
