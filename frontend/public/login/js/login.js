import { login }
from "../../services/loginApi.js";

const form =
document.getElementById(
  "login-form"
);

form.addEventListener(
  "submit",

  async (event) => {

    event.preventDefault();

    const email =
      document.getElementById(
        "email"
      ).value;

    const password =
      document.getElementById(
        "password"
      ).value;

    const data = await login(email, password);

    if(data.success) {
      // CAMBIO: Quitar "/public" porque Nginx ya está parado en esa carpeta
      window.location.href = "/operario/operario.html"; 
    } else {
      alert("Credenciales inválidas");
    }
  }

);
