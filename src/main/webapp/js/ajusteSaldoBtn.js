document.addEventListener("DOMContentLoaded", function() {
    var cuentas = document.querySelectorAll(".cuentaIE");
	//var botonVerMovimiento; // Definir la variable aquí

    cuentas.forEach(function(cuenta) {
        var botonAjustar = cuenta.querySelector(".boton-ajustar");
		//botonVerMovimiento = cuenta.querySelector(".boton-ver-movimiento"); // Actualizar el valor aquí

        cuenta.addEventListener("mouseover", function() {
            botonAjustar.style.display = "block";
          //  botonVerMovimiento.style.display = "block"; // Mostrar el botón de Ver Movimiento
        });

        cuenta.addEventListener("mouseout", function() {
            botonAjustar.style.display = "none";
      //      botonVerMovimiento.style.display = "none"; // Ocultar el botón de Ver Movimiento
        });
    });
});





		
		/*document.addEventListener("DOMContentLoaded", function() {
			var cuentas = document.querySelectorAll(".cuenta");
	
			cuentas.forEach(function(cuenta) {
				var botonAjustar = cuenta.querySelector(".boton-ver-movimiento");
				

				cuenta.addEventListener("mouseover", function() {
					botonAjustar.style.display = "block";
				});

				cuenta.addEventListener("mouseout", function() {
					botonAjustar.style.display = "none";
				});
			});
		});*/