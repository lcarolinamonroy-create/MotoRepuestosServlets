package com.motorepuestos.servlets.repository;

import com.motorepuestos.servlets.model.Producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/** Ejecuta las consultas JDBC del módulo de productos. */
public class ProductoRepository {

    private static final String LISTAR_SQL = "SELECT id, nombre, categoria, precio, stock "
            + "FROM producto ORDER BY id DESC";
    private static final String INSERTAR_SQL = "INSERT INTO producto "
            + "(nombre, categoria, precio, stock) VALUES (?, ?, ?, ?)";

    public List<Producto> listar() throws SQLException {
        List<Producto> productos = new ArrayList<>();

        try (Connection connection = ConexionBD.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(LISTAR_SQL);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Producto producto = new Producto();
                producto.setId(resultSet.getLong("id"));
                producto.setNombre(resultSet.getString("nombre"));
                producto.setCategoria(resultSet.getString("categoria"));
                producto.setPrecio(resultSet.getBigDecimal("precio"));
                producto.setStock(resultSet.getInt("stock"));
                productos.add(producto);
            }
        }
        return productos;
    }

    public void guardar(Producto producto) throws SQLException {
        try (Connection connection = ConexionBD.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(INSERTAR_SQL)) {
            statement.setString(1, producto.getNombre());
            statement.setString(2, producto.getCategoria());
            statement.setBigDecimal(3, producto.getPrecio());
            statement.setInt(4, producto.getStock());
            statement.executeUpdate();
        }
    }
}
