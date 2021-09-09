<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>AgregarProducto</title>
</head>

<body>
    <form action="AgregarProducto" method="POST">
        <div class="mb-3">
            <label for="nombreProducto" class="form-label">Nombre: </label>
            <input type="text" class="form-control" id="nombreProducto" name="nombre_producto">
        </div>
        <div class="mb-3">
            <label for="precioProducto" class="form-label">Precio: </label>
            <input type="number" class="form-control" id="precioProducto" name="precio_producto">
        </div>
        <div class="mb-3">
            <label for="descripcionProducto" class="form-label">Descripción: </label>
            <input type="text" class="form-control" id="descripcionProducto" name="descripcion_producto">
        </div>
        <div class="mb-3">
            <label for="categoriaProducto" class="form-label">Categoria: </label>
            <select name="categoria_producto" id="categoriaProducto">
                <c:forEach items="${listaCategoria}" var="catTemp">
                <option value="${catTemp.getIdCategoria()}">${catTemp.getNombreCategoria()}</option>
                </c:forEach>
            </select>
        </div>
        
        <button type="submit" class="btn btn-primary">ENVIAR</button>
    </form>
</body>

</html>