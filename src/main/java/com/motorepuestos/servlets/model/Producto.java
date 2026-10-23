package com.motorepuestos.servlets.model;

import java.math.BigDecimal;

/** Representa un producto almacenado en la tabla productos. */
public class Producto {

    private Long id;
    private String nombre;
    private String categoria;
    private BigDecimal precio;
    private int stock;

    public Producto() {
    }

    public Producto(String nombre, String categoria, BigDecimal precio, int stock) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.stock = stock;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    public BigDecimal getPrecio() { return precio; }
    public void setPrecio(BigDecimal precio) { this.precio = precio; }
    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }
}
