<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listar Producto</title>

<!-- bootstrap 5 -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>

    <!-- plantilla scriptlet version
    </%
    InscripcionDAO inscripcionDAO = new InscripcionDAO();
    List<InscripcionDTO> lista = InscripcionDAO.obtieneInscritos();
    request.setAttribute("lista", lista);
    System.out.println(lista);
    %/> -->

	<table class="table">
        <thead>
            <tr>
                <th>ID Producto</th>
                <th>Nombre</th>
                <th>Precio</th>
                <th>Descripción</th>
                <th>Categoria</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${listaPC}" var="listaTemp">
            <tr>
                <td scope="row">${listaTemp.getProducto().getIdProducto()}</td>
                <td>${listaTemp.getProducto().getNombreProducto()}</td>
                <td>${listaTemp.getProducto().getPrecioProducto()}</td>
                <td>${listaTemp.getProducto().getDescripcionProducto()}</td>
                <td>${listaTemp.getCategoria().getNombreCategoria()}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    

    <!-- bootstrap 5 -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>

</body>
</html>