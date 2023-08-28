<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mis Cuentas</title>
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/images/icon1.png"
	type="image/x-icon">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/estilos.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/predeterminados.css" />
<script src="${pageContext.request.contextPath}/js/caida-texto.js"></script>
<script src="${pageContext.request.contextPath}/js/ajusteSaldoBtn.js"></script>

</head>
<body>

	<!-- BANNER -->
	<%@include file='../templates/banner.jsp'%>

	<!-- DASHBOARD -->

	<br>
	<br>
	<div class="d-flex justify-content-between">
		<p class="h3 ms-5">MIS CUENTAS</p>
		<span class="justify-content-center"> <a
			class="btn text-decoration-none bg-1 text-white ms-5 font-w700 me-5 pe-3"
			href="GestionCuentaController?ruta=crearCuentaPantalla"> + Nueva cuenta</a></span>
	</div>

	<br>


	<div class="d-flex justify-content-center">
		<!-- CUENTAS DE INGRESO/EGRESO -->
		<div>
			<p class="tipoCuenta ms-5">CUENTAS DE INGRESO-GASTO</p>
			<div class="ingresoGasto mx-5">
				<c:forEach items="${listaCuentas}" var="cuenta">
					<c:if test="${cuenta.tipoCuenta == 'INGRESO_GASTO'}">
						<div class="cuentaIE card-body ms-3 my-4">
							<h5 class="card-title">
								<i class="fa-solid fa-sack-dollar" style="color: #909c41;"></i>
								${cuenta.nombreCuenta}
							</h5>
							
							<span>Monto total</span> <span>$ ${cuenta.total} </span>
							
							<form
								action=" GestionCuentaController?ruta=verMovimientosCuentaPantalla"
								method="POST">
								<input type="hidden" name="cuentaId" value="${cuenta.id}" />
								<button type="submit"
									class="btn bg-1 text-white font-w700 mt-3 boton-ver-movimiento"
									>Ver Movimientos</button>
							</form>

							<form action="GestionCuentaController?ruta=ajustarSaldoPantalla"
								method="post">
								<input type="hidden" name="cuentaId" value="${cuenta.id}" />
								<button type="submit"
									class="btn bg-1 text-white font-w700 mt-3 boton-ajustar"
									style="display: none;">Ajustar Saldo</button>
							</form>
							
							
						</div>
					
					</c:if>
				</c:forEach>
			</div>
		</div>


		<div class="container me-5">
		<div class="container d-flex justify-content-end">
					<form action="${pageContext.request.contextPath}/VisualizarDashboardController" 
						method="GET" class="mb-4 d-flex align-items-center mt-3">
						<input type="hidden" name="ruta"
							value="visualizarDashboardPorMes"> <label
							for="mesSeleccionado" class="form-label me-3">Selecciona un
							mes:</label> <select id="mesSeleccionado" name="mesSeleccionado"
							class="form-select">
							<option value="1">Enero</option>
							<option value="2">Febrero</option>
							<option value="3">Marzo</option>
							<option value="4">Abril</option>
							<option value="5">Mayo</option>
							<option value="6">Junio</option>
							<option value="7">Julio</option>
							<option value="8">Agosto</option>
							<option value="9">Septiembre</option>
							<option value="10">Octubre</option>
							<option value="11">Noviembre</option>
							<option value="12">Diciembre</option>
						</select> <br>
						<button type="submit" class="btn text-white ms-5 me-0 bg-1 font-w700">Mostrar</button>
					</form>
				</div>
			<!-- CUENTAS DE INGRESO -->
			<div class="row">
				<p class="tipoCuenta">CUENTAS DE INGRESO</p>
				<div class="ingreso mb-4 d-flex flex-wrap">
				
				
					<c:forEach items="${listaCuentas}" var="cuenta">
						<c:if test="${cuenta.tipoCuenta == 'SOLO_INGRESO'}">
							<div class="col-3">
								<div class="cuenta card-body  my-4 ms-3  " style="width: 250px;">
									<h5 class="card-title">
										<i class="fa-solid fa-sack-dollar" style="color: #909c41;"></i>
										${cuenta.nombreCuenta}
									</h5>
									<p class="card-text">Total ingresado: $ ${cuenta.montoMovidoIngreso}</p>

									<form
										action="GestionCuentaController?ruta=verMovimientosCuentaPantalla"
										method="post">
										<input type="hidden" name="cuentaId" value="${cuenta.id}" />
										<button type="submit"
											class="mt-2 btn bg-1 text-white font-w700 boton-ver-movimiento"
											>Ver Movimientos</button>
									</form>

								</div>

							</div>
						</c:if>
					</c:forEach>
				</div>

			</div>
			<!-- CUENTAS DE EGRESO -->
			<p class="tipoCuenta">CUENTAS DE GASTO</p>
			<div class="row">
				<div class="egreso mb-4 d-flex flex-wrap">
					<c:forEach items="${listaCuentas}" var="cuenta">
						<c:if test="${cuenta.tipoCuenta == 'SOLO_GASTO'}">
							<div class="col-3">
								<div class="cuenta card-body  my-4 ms-3  " style="width: 250px;">
									<h5 class="card-title">
										<i class="fa-solid fa-sack-dollar" style="color: #909c41;"></i>
										${cuenta.nombreCuenta}
									</h5>
									<p class="card-text">Total Gastado: $ ${cuenta.montoMovidoGasto}</p>

								 
									<form
										action="GestionCuentaController?ruta=verMovimientosCuentaPantalla"
										method="post">
										<input type="hidden" name="cuentaId" value="${cuenta.id}" />
										<button type="submit"
											class="btn bg-1 text-white font-w700 mt-2 boton-ver-movimiento"
											>Ver Movimientos</button>
										
									</form>

								</div>
							</div>
						</c:if>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>

	<!-- BOOTSTRAP Y FONTAWESOME -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
		crossorigin="anonymous"></script>
	<script src="https://kit.fontawesome.com/87553d44ff.js"
		crossorigin="anonymous"></script>
</body>
</html>

