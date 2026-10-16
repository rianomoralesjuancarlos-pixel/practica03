package com.sena.practica03.repositoryes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sena.practica03.models.Productos;

@Repository 
public interface ProductosRepository extends JpaRepository< Productos, Integer> {

    Productos findByNombre(String nombre);

    }
