// 1. Importamos CONFIG en lugar de UI_PATHS
import { login } from "../../services/loginApi.js";
import { CONFIG } from "../../services/config.js";

const form = document.getElementById("login-form");

form.addEventListener("submit", async (event) => {
    event.preventDefault();
    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;

    try {
        const data = await login(email, password);

        if (data.success) {
            console.log("Login exitoso, redirigiendo...");

            window.location.href = CONFIG.ROUTES.OPERARIO_HOME;
        } else {
            alert("Credenciales inválidas. Por favor, intente de nuevo.");
        }
    } catch (error) {
        console.error("Error en el proceso de login:", error);
        alert("No se pudo conectar con el servidor. Verifique su conexión.");
    }
});