import apiFetch from "./client.js";

export async function login(email, password) {
    // Debe apuntar al endpoint del backend, NO al archivo login.js
    // Como client.js ya tiene API_URL = "/api", esto llamará a "/api/login"
    return apiFetch("/login", {
        method: "POST",
        body: JSON.stringify({ email, password })
    });
}
