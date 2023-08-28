<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="shortcut icon" href="${pageContext.request.contextPath}/images/icon1.png" type="image/x-icon">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/estilos.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/predeterminados.css" />
	<script src="${pageContext.request.contextPath}/js/error.js"></script>
	

<title>Mi Chaucherita</title>
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous" />
</head>
	
<body>
	<div class="container-fluid login">
		<!-- Login Form -->
		<div class="container px-5 pt-5">
			<div class="row align-items-center my-5 py-5">
				<div class="col-6 mb-5">
					<div class="card bg-glass ms-5">
						<div class="card-body pt-5 pb-4 px-5">
							<h1 class="text-center mb-5">Login</h1>
						
							<!-- FORM -->
												
							<form action="${pageContext.request.contextPath}/LoginController?ruta=ingresar" method="POST">
								<!-- User -->
								<div class="form-outline mb-4 d-flex align-items-center">
									<i class="fa-lg fa-solid fa-user me-2"></i> <input type="text"
										id="impUsuario" name="usuario" placeholder="Usuario"
										class="form-control" />
								</div>
								<!-- Password -->
								<div class="form-outline mb-1 d-flex align-items-center">
									<i class="fa-lg fa-solid fa-lock me-2"></i> <input
										type="password" id="impPassword" name="password"
										placeholder="Contraseña" class="form-control" />
								</div>
								<div class="d-flex justify-content-center mb-3">
							<div id="mensaje-error" class="text-danger  <%= request.getAttribute("mensajeError") != null ? "" : " d-none" %>">
        							<%= request.getAttribute("mensajeError") %></div>
							</div>
								<!-- Submit button -->
								<div class="d-flex justify-content-center ">
									<button type="submit" id="btn" class="btn">INGRESAR</button>
								</div>
							</form>
							
							<br>
							<br>
							<!-- ICONOS REDES SOCIALES -->
							<div class="text-center">
								<p class="mb-2">Síguenos en</p>
								<button type="button" class="btn btn-link btn-floating mx-1">
									<i class="fab fa-facebook-f"></i>
								</button>
								<button type="button" class="btn btn-link btn-floating mx-1">
									<i class="fab fa-google"></i>
								</button>
								<button type="button" class="btn btn-link btn-floating mx-1">
									<i class="fab fa-twitter"></i>
								</button>
								<button type="button" class="btn btn-link btn-floating mx-1">
									<i class="fab fa-github"></i>
								</button>
							</div>
						</div>
					</div>
				</div>
				<div class=" title col-6 mb-5 mb-0" >
					<h1 class="my-5 display-5 falling-text">
						Mi chaucherita <br /> <span style="color: hsl(218, 81%, 75%)">EPN</span>
					</h1>

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