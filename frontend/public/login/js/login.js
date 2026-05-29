import { login } from "../../services/loginApi.js";
import { UI_PATHS } from "../../services/config.js";

const form = document.getElementById("login-form");

form.addEventListener("submit", async (event) => {
    event.preventDefault();
    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;

    try {
        const data = await login(email, password);
        if (data.success) {
            // Usamos la ruta centralizada
            window.location.href = UI_PATHS.OPERARIO_PANEL;
        } else {
            alert("Credenciales inválidas");
        }
    } catch (error) {
        console.error(error);
        alert("Error de conexión con el servidor");
    }
});
