package com.sena.practica03.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sena.practica03.models.Productos;
import com.sena.practica03.repositoryes.ProductosRepository;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController 
public class ProductosController {

    @Autowired 
    private ProductosRepository productosRepository;

    @GetMapping("/productos")
    public List<Productos> getAllProductos() {
        return productosRepository.findAll();
    }
@PostMapping("/{Id}")
    public ResponseEntity<Productos> getProductoById(@PathVariable Integer Id) {
        return productosRepository.findById(Id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


}