<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ajustar Saldo</title>
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
    <%@include file="../templates/banner.jsp" %>

    <!-- FORMULARIO PARA AJUSTAR SALDO -->
    <div class="container mt-5">
    <br> <br>
    <h3 class="mb-4">AJUSTAR SALDO</h3>
    <br>
        <div class="row justify-content-center">
            <div class="col-md-6">
                
                <form action="GestionCuentaController?ruta=ajustarSaldo" method="POST" class="registro">
                   
                        <input type="text" id="cuentaId" name="cuentaId" value="${cuenta.id}" readonly style="display:none;">
                 
                    <div class="mb-3">
                        <label for="nombreCuenta" class="form-label">Nombre de la Cuenta Destino</label>
                        <input type="text" class="form-control" id="nombreCuenta" name="nombreCuenta" value="${cuenta.nombreCuenta}" readonly>
                    </div>
                   
                        <input type="date"  id="fecha" name="fecha"  style="display:none;">
               
                    <div class="mb-3">
                        <label for="monto" class="form-label">Monto</label>
                        <input type="number" step="0.01" class="form-control" id="monto" name="monto" required>
                    </div>
                    <button type="submit" class="btn bg-1 text-white font-w700">Realizar Ajuste</button>
                </form>
            </div>
        </div>
    </div>

    <!-- BOOTSTRAP -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
        crossorigin="anonymous"></script>

</body>
</html>