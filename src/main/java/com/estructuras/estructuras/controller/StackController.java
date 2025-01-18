package com.estructuras.estructuras.controller;
import com.estructuras.estructuras.service.StackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/stack")
public class StackController {
    @Autowired
    private StackService stackService;

    // Endpoint para agregar elemento
    @PostMapping("/push")
    public Map<String, Object> push(@RequestParam int v) {
        return stackService.push(v);
    }

    @PostMapping("/pop")
    public Map<String, Object> pop() {
        return stackService.pop();
    }

    @GetMapping("/readTop")
    public Map<String, Object> readTop() {
        return stackService.readTop();
    }

    @PostMapping("/unstack")
    public Map<String, Object> unstack() {
        return stackService.unstack();
    }

    @GetMapping("/isEmpty")
    public Map<String, Object> isEmpty() {
        return stackService.isEmpty();
    }

    @GetMapping("/isFull")
    public Map<String, Object> isFull() {
        return stackService.isFull();
    }
}
