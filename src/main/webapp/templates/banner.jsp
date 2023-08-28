<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    
    <nav class="navbar text-white bg-1">
        <div class="container-fluid">
            <span class="navbar-brand mb-0 ms-3 h1">MI CHAUCHERITA</span>
            <!-- CON JSTL -->
            <span class="navbar-brand mb-0 h3" id="bienvenida">¡Bienvenido, <c:out value="${sessionScope.usuarioLogeado.nombre}"/>! </span>
            <span class="navbar-brand mb-0 me-3 h3"><a class="text-decoration-none text-white"
                    href="./LoginController?ruta=salir">SALIR</a></span>
        </div>
    </nav>
    <nav class="navbar  bg-2">
        <div class="container-fluid mx-5">
            <span class="navbar-brand mb-0 h3">
                <a class="text-decoration-none banner" href="VisualizarDashboardController?ruta=visualizar"> Mis cuentas</a>
               
                <a class="text-decoration-none ms-5 banner " href="GestionCuentaController?ruta=verMovimientosPantalla"> Mis Movimientos</a>
            </span>
            <div " >
                <span class=" navbar-brand mb-0 h3 px-5"><a class="text-decoration-none banner"
                    href="GestionCuentaController?ruta=ingresoPantalla"> Ingresar </a></span>
                <span class="navbar-brand mb-0 h3 px-5"><a class="text-decoration-none banner" href="GestionCuentaController?ruta=egresoPantalla">
                        Egresar</a></span>
                <span class="navbar-brand mb-0 h3 px-5 "><a class="text-decoration-none banner"
                        href="GestionCuentaController?ruta=transferirPantalla"> Tranferir </a></span>
            </div>
        </div>
    </nav>
        
</body>
</html>