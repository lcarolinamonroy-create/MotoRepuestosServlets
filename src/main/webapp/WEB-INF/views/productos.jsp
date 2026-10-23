<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Productos Moto Repuestos Express</title>
    <style>
        body { font-family: Arial, sans-serif; max-width: 1000px; margin: 30px auto; color: #222; }
        h1 { color: #8b1e2d; }
        form { display: grid; gap: 10px; max-width: 420px; padding: 18px; background: #fff5f2; border: 1px solid #e3c8c3; }
        input, button { padding: 9px; font-size: 14px; }
        button { background: #8b1e2d; color: white; border: 0; cursor: pointer; }
        table { border-collapse: collapse; width: 100%; margin-top: 25px; }
        th, td { border: 1px solid #ccc; padding: 9px; text-align: left; }
        th { background: #8b1e2d; color: white; }
        .success { color: #18733c; }
        .error { color: #a40000; }
    </style>
</head>
<body>
    <h1>Gestión de productos</h1>
    <p>Este módulo utiliza un formulario JSP y un Servlet con métodos GET y POST.</p>

    <c:if test="${param.guardado == 'true'}">
        <p class="success">Producto guardado correctamente.</p>
    </c:if>
    <c:if test="${not empty error}">
        <p class="error"><c:out value="${error}" /></p>
    </c:if>

    <h2>Registrar producto</h2>
    <form action="${pageContext.request.contextPath}/productos" method="post">
        <label>Nombre <input type="text" name="nombre" required></label>
        <label>Categoría <input type="text" name="categoria" required></label>
        <label>Precio <input type="number" name="precio" min="0.01" step="0.01" required></label>
        <label>Stock <input type="number" name="stock" min="0" required></label>
        <button type="submit">Guardar producto</button>
    </form>

    <h2>Productos registrados</h2>
    <table>
        <thead>
        <tr><th>ID</th><th>Nombre</th><th>Categoría</th><th>Precio</th><th>Stock</th></tr>
        </thead>
        <tbody>
        <c:forEach var="producto" items="${productos}">
            <tr>
                <td><c:out value="${producto.id}" /></td>
                <td><c:out value="${producto.nombre}" /></td>
                <td><c:out value="${producto.categoria}" /></td>
                <td><c:out value="${producto.precio}" /></td>
                <td><c:out value="${producto.stock}" /></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>
