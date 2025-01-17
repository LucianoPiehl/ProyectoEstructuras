package com.estructuras.estructuras.controller;

import com.estructuras.estructuras.service.GraphService;
import com.estructuras.estructuras.model.SetTDA;
import com.estructuras.estructuras.model.SetTDANode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/graph")
public class GraphController {

    @Autowired
    private GraphService graphService;



    // Endpoint para agregar un nodo
    @PostMapping("/addVertex")
    public ResponseEntity<Void> addVertex(@RequestParam int v, @RequestParam String status) {
        graphService.addVertex(v, status);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    // Endpoint para eliminar un nodo
    @DeleteMapping("/deleteVertex")
    public ResponseEntity<Void> deleteVertex(@RequestParam int v) {
        graphService.removeVertex(v);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    // Endpoint para agregar una arista
    @PostMapping("/addEdge")
    public ResponseEntity<Void> addEdge(@RequestParam int v1, @RequestParam int v2, @RequestParam int weight) {
        graphService.addEdge(v1, v2, weight);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    // Endpoint para eliminar una arista
    @DeleteMapping("/deleteEdge")
    public ResponseEntity<Void> deleteEdge(@RequestParam int v1, @RequestParam int v2) {
        graphService.removeEdge(v1, v2);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    // Endpoint para verificar si existe una arista
    @GetMapping("/edgeExists")
    public boolean edgeExists(@RequestParam int v1, @RequestParam int v2) {
        return graphService.edgeExists(v1, v2);
    }

    // Endpoint para obtener todos los vértices
    @GetMapping("/getVertices")
    public SetTDA getVertices() {
        return graphService.getVertices();
    }

    // Endpoint para obtener nodos adyacentes a un nodo específico
    @GetMapping("/getAdjacentNodes")
    public SetTDANode getAdjacentNodes(@RequestParam int v) {
        return graphService.getAdjacentNodes(v);
    }
}
