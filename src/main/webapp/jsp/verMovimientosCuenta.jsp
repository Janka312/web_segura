<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Mis Movimientos</title>
    <link rel="shortcut icon"
	href="${pageContext.request.contextPath}/images/icon1.png"
	type="image/x-icon">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css" /> 
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/predeterminados.css" /> 
    
</head>
<body>
    
     <!-- BANNER -->
    <%@include file = '../templates/banner.jsp' %>
    
    <!-- VER MIS MOVIMIENTOS PANTALLA -->
    
        <br> <br>
    <p class="h3 ms-5">MOVIMIENTOS DE LA CUENTA:  ${cuenta.nombreCuenta}</p>
    <br>
        <p class="ms-5" >Monto total de la Cuenta: $ ${cuenta.total}</p>
        <p class="ms-5" >Tipo de Cuenta: ${cuenta.tipoCuenta}</p>
    
    <br>
    <div class="container text-center mb-5" >
        <table class="table table-hover">
            <thead>
                <tr>
                    
                     <th scope="col">FECHA</th>
                    <th scope="col">ORIGEN </th>
                    <th scope="col">DESTINO</th>
                    <th scope="col">MOVIMIENTO </th>
                    <th scope="col">MONTO</th>
                    <th scope="col">DESCRIPCIÓN</th>
                    
                </tr>
            </thead>
            <tbody>
            
            <c:forEach items="${listaMovimientos}" var="movimiento">
            <tr>
                
                <td>${movimiento.fecha}</td>
               
                <td> ${movimiento.cuentaOrigen.nombreCuenta} </td>
                <td>${movimiento.cuentaDestino.nombreCuenta}</td>
                 <td>${movimiento.getClass().simpleName}</td>
                <td>${movimiento.monto}</td>
                <td>${movimiento.descripcion}</td>
                
            </tr>
        </c:forEach>
            
        </tbody>
        
        </table>
        </div>

    
    
    <!-- BOOTSTRAP Y FONTAWESOME -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
        crossorigin="anonymous"></script>
    <script src="https://kit.fontawesome.com/87553d44ff.js" crossorigin="anonymous"></script>
    
    
    
</body>
</html>