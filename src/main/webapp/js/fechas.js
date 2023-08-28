document.addEventListener('DOMContentLoaded', function() {
    const fechaInput = document.getElementById('fecha');
    const form = document.querySelector('.registro');

    form.addEventListener('submit', function(event) {
      // Obtener la fecha actual en formato yyyy-mm-dd
      const fechaActual = new Date().toISOString().split('T')[0];
      // Establecer la fecha actual en el campo oculto
      fechaInput.value = fechaActual;
    });
  });