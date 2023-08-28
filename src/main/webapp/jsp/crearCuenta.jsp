<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Nueva Cuenta</title>
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

	<!-- FORM PARA CREAR CUENTA -->
	
	 <br> <br>
        <p class="h3 ms-5">NUEVA CUENTA</p>
    <br>
	
    <div class="d-flex justify-content-center" >
    
    <form class="registro" action="GestionCuentaController?ruta=crearCuenta" method="POST">
    
        <input type="hidden" name="ruta" value="crearCuenta"> <!-- PARA QUE ES ESTO  -->
        
          <div class="mb-3">
                <label for="nombreCuenta" class="form-label">NOMBRE DE LA CUENTA</label>
                <input type="text" id="nombreCuenta" name="nombreCuenta" class="form-control" placeholder="Nombre" required>
            </div>
      
       <div class="mb-3">
                <label for="montoInicial" class="form-label">MONTO INICIAL </label>
                <div class="d-flex align-items-center">
                    <i class="fa fa-dollar-sign trailing me-2"></i>
                    <input type="number" id="montoInicial" min="0.1" name="total" class="form-control" placeholder="Monto" step="0.01" required>
                </div>
            </div>
            
        <!-- Campo de selección para el tipo de cuenta -->
            <div class="mb-3">
                <label for="tipoCuenta" class="form-label">TIPO DE CUENTA</label>
                <div class="form-control text-center" id="tipoCuenta" name="tipoCuenta">
                    <c:forEach items="${tiposCuenta}" var="tipo">
                        <input type="radio" name="tipoCuenta" id="${tipo}" value="${tipo}" class="ms-4" required/>
                        <label class="me-4">${tipo}</label>
                    </c:forEach>
                </div>
            </div>
        <br>
            <button type="submit" class="btn bg-1 text-white font-w700">CREAR CUENTA</button> 
    </form>
    </div>
    
    <!-- BOOTSTRAP Y FONTAWESOME -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
        crossorigin="anonymous"></script>
    <script src="https://kit.fontawesome.com/87553d44ff.js" crossorigin="anonymous"></script>
    
</body>
</html>