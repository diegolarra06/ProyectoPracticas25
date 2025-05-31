window.onload = function () {
  var slides = document.querySelectorAll(".carruselcontenido .slide");
  var btnAnterior = document.getElementById("btn-anterior");
  var btnSiguiente = document.getElementById("btn-siguiente");
  var indiceActual = 0;

  function mostrarSlide(indice) {
    for (var i = 0; i < slides.length; i++) {
      slides[i].classList.remove("activo");
    }
    slides[indice].classList.add("activo");
  }

  if (btnAnterior && btnSiguiente && slides.length > 0) {
    btnAnterior.onclick = function () {
      indiceActual--;
      if (indiceActual < 0) {
        indiceActual = slides.length - 1;
      }
      mostrarSlide(indiceActual);
    };

    btnSiguiente.onclick = function () {
      indiceActual++;
      if (indiceActual >= slides.length) {
        indiceActual = 0;
      }
      mostrarSlide(indiceActual);
    };

    setInterval(function () {
      indiceActual++;
      if (indiceActual >= slides.length) {
        indiceActual = 0;
      }
      mostrarSlide(indiceActual);
    }, 6000);

    mostrarSlide(indiceActual);
  }

  
  var formulario = document.getElementById("formulario");
  if (formulario) {
    formulario.onsubmit = function (e) {
      var nombre = document.getElementById("nombre").value;
      var correo = document.getElementById("correo").value;

      if (nombre.trim() === "") {
        alert("Por favor, introduce tu nombre.");
        e.preventDefault();
        return false;
      }

      if (correo.trim() === "" || !correo.includes("@")) {
        alert("Por favor, introduce un correo electrónico válido.");
        e.preventDefault();
        return false;
      }

      alert("¡Gracias por inscribirte!");
      return true;
    };
  }

  var botonMenu = document.getElementById("boton-menu");
  var menu = document.querySelector(".menu-principal");

  if (botonMenu && menu) {
    botonMenu.onclick = function () {
      if (menu.style.display === "block") {
        menu.style.display = "none";
      } else {
        menu.style.display = "block";
      }
    };
  }

  
  var botonesInscribir = document.querySelectorAll(".btn-inscribirse");
  for (var j = 0; j < botonesInscribir.length; j++) {
    botonesInscribir[j].onclick = function () {
      alert("¡Te has inscrito al evento!");
    };
  }

  console.log("Script cargado correctamente.");
};
