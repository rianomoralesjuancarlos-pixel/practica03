package com.sena.practica03.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity 
public class Productos {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private Double valor;
    private String categoria;
    private Integer cantidad;

    //constructores
    public Productos() {
        
    //constructor con todos los atributos
    }   


    public Productos(Integer id, String nombre, Double valor, String categoria, Integer cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.valor = valor;
        this.categoria = categoria;
        this.cantidad = cantidad;
    }


    public Integer getProductoId() {
        return this.id;
    }

    public void setProductoId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getValor() {
        return this.valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Integer getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }


    public Object map(Object object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'map'");
    }

    }

