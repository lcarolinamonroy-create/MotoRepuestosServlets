package com.motorepuestos.servlets.controller;

import com.motorepuestos.servlets.model.Producto;
import com.motorepuestos.servlets.repository.ProductoRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.math.BigDecimal;

/** Atiende las operaciones GET y POST del formulario de productos. */
@WebServlet("/productos")
public class ProductoServlet extends HttpServlet {

    private final ProductoRepository productoRepository = new ProductoRepository();

    /** Consulta los productos y muestra la página JSP. */
    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        try {
            request.setAttribute(
                    "productos",
                    productoRepository.listar()
            );

            request.getRequestDispatcher(
                    "/WEB-INF/views/productos.jsp"
            ).forward(request, response);

        } catch (Exception error) {
            error.printStackTrace();

            request.setAttribute(
                    "error",
                    "No fue posible consultar los productos: "
                            + error.getClass().getSimpleName()
                            + " - "
                            + error.getMessage()
            );

            request.getRequestDispatcher(
                    "/WEB-INF/views/productos.jsp"
            ).forward(request, response);
        }
    }

    /** Recibe el formulario, valida los datos y registra el producto. */
    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        try {
            String nombre = request.getParameter("nombre");
            String categoria = request.getParameter("categoria");
            BigDecimal precio = new BigDecimal(
                    request.getParameter("precio")
            );
            int stock = Integer.parseInt(
                    request.getParameter("stock")
            );

            if (nombre == null || nombre.isBlank()
                    || categoria == null || categoria.isBlank()
                    || precio.compareTo(BigDecimal.ZERO) <= 0
                    || stock < 0) {

                throw new IllegalArgumentException(
                        "Verifica los datos del producto."
                );
            }

            Producto producto = new Producto(
                    nombre,
                    categoria,
                    precio,
                    stock
            );

            productoRepository.guardar(producto);

            response.sendRedirect(
                    request.getContextPath()
                            + "/productos?guardado=true"
            );

        } catch (Exception error) {
            error.printStackTrace();

            request.setAttribute(
                    "error",
                    "No fue posible guardar el producto: "
                            + error.getMessage()
            );

            doGet(request, response);
        }
    }
}
