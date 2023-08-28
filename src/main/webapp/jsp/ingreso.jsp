<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ingreso</title>
    <link rel="shortcut icon"
	href="${pageContext.request.contextPath}/images/icon1.png"
	type="image/x-icon">
    
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css" /> 
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/predeterminados.css" /> 
    <script src="${pageContext.request.contextPath}/js/fechas.js"></script>
</head>
<body>


	<!-- BANNER -->
    <%@include file = '../templates/banner.jsp' %> 
    
     <!-- REGISTRAR UN INGRESP  -->
    <br> <br>
    <p class="h3 ms-5">REGISTRO DE INGRESOS</p>
    <br>


    <div class="d-flex justify-content-center">

        <form class="registro" action="GestionCuentaController?ruta=ingreso" method="POST">
         <input type="hidden" name="ruta" value="ingreso">

            <div class="mb-3">
           
			<input type="date" name="fecha" id="fecha" style="display:none;">
            
        		
                <label for="cuentaDestino" class="form-label">SELECCIONA UNA CUENTA</label>
                <select id="cuentaDestino" name="cuentaDestino" class="form-select" required>
                    <c:forEach items="${listaCuentas}" var="cuenta">
                        <option value= "${cuenta.id}"> ${cuenta.nombreCuenta} </option>
                    </c:forEach>
                </select>
            </div>

            <div class="mb-3">
                <label for="descripcion" class="form-label">DESCRIPCIÓN DEL INGRESO</label>
                <input type="text" id="descripcion" name="descripcion" class="form-control"
                    placeholder="Descripción" required>
            </div>

            <div class="mb-3">

                <label for="montoIngreso" class="form-label">MONTO</label>
                <div class="d-flex align-items-center">
                    <i class="fa fa-dollar-sign trailing me-2"></i>
                    <input type="number" min="0.1" id="montoIngreso" name="monto" class="form-control"
                        placeholder="Monto" step="0.1"  required>
                </div>

            </div>
            
            <br>
            <button type="submit" class="btn text-white bg-1 font-w700">REGISTRAR INGRESO</button>
        </form>
    </div>
   
    
       <!-- BOOTSTRAP Y FONTAWESOME -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
        crossorigin="anonymous"></script>
    <script src="https://kit.fontawesome.com/87553d44ff.js" crossorigin="anonymous"></script>
</body>
</html>